
# Activity
* 官方解释：  
  Activity是一个应用程序的组件，他在屏幕上提供了一个区域，允许用户在上面做一些交互性的操作， 比如打电话，照相，发送邮件，或者显示一个地图！Activity可以理解成一个绘制用户界面的窗口， 而这个窗口可以填满整个屏幕，也可能比屏幕小或者浮动在其他窗口的上方！  
* 总结：
  1. Activity用于显示用户界面，用户通过Activity交互完成相关操
  2. 一个App允许有多个Activity    
* 继承Activity和AppCompatActivity区别  
AppCompatActivity兼容了很多低版本的一些东西  
AppcompaActivity相对于Activity的变化：主界面带有toolbar的标题栏  
## P52 创建  
![Activity创建流程](./image/Activity创建流程.png)    
启动一个Activity的几种方式:
  1. 显示启动:
```java {.line-numbers}
// 1. 最常见的：
startActivity(new Intent(当前Act.this,要启动的Act.class));
// 2. 通过Intent的ComponentName：
ComponentName cn = new ComponentName("当前Act的全限定类名","启动Act的全限定类名") ;
Intent intent = new Intent() ;
intent.setComponent(cn) ;
startActivity(intent) ;
// 3. 初始化Intent时指定包名：
Intent intent = new Intent("android.intent.action.MAIN");
intent.setClassName("当前Act的全限定类名","启动Act的全限定类名");
startActivity(intent);
```
  2. 隐式启动
   AndroidManifest中通过Intent-filter的Action,Category或data来实现
## P53 生命周期
![Activity生命周期](./image/Activity生命周期.png)     
## P54 组件间通信 Intent
### P54 组件间通信 Intent 传入1
```java {.line-numbers}
Intent in = new Intent(FirstActivity.this, ThirdActivity.class);
//1.传单个数据
in.putExtra("test","TTIT");
in.putExtra("number",100);
startActivity(in);
```
### P54 组件间通信 Intent 传入2
```java {.line-numbers}
Intent in = new Intent(FirstActivity.this, ThirdActivity.class);
//2.传多个数据
Bundle b = new Bundle();
b.putInt("number", 100);
b.putString("test", "TTIT");
in.putExtras(b);
startActivity(in);
```
### P54 组件间通信 Intent 传出
```java {.line-numbers}
// 1.FirstActivity启动ThirdActivity
startActivityForResult(in, 1001);
// 2.FirstActivity接受ThirdActivity返回的数据
@Override
protected void onActivityResult(int requestCode, int
resultCode, @Nullable Intent data) {
super.onActivityResult(requestCode, resultCode, data);
Log.e("tag", "requestCode =" + requestCode);
Log.e("tag", "resultCode =" + resultCode);
Log.e("tag", "data =" + data.getStringExtra("back"));
}
// 3.ThirdActivity设置返回的数据
Intent backIn = new Intent();
backIn.putExtra("back", "abcdef");
setResult(1002, backIn);
```
## Back Stack（回退堆栈）
``` {.line-numbers}
Java栈Stack概念：
后进先出(LIFO)，常用操作入栈(push)，出栈(pop)，处于最顶部的叫栈顶，最底部叫栈底
```
``` {.line-numbers}
Activity 管理机制:
1.我们的APP一般都是由多个Activity构成的，而在Android中给我们提供了一个Task(任务)的概念， 就是将多个相关的Activity收集起来，然后进行Activity的跳转与返回;
2.当切换到新的Activity，那么该Activity会被压入栈中，成为栈顶！ 而当用户点击Back键，栈顶的Activity出栈，紧随其后的Activity来到栈顶！
3.Task是Activity的集合，是一个概念，实际使用的Back Stack来存储Activity，可以有多个Task，但是 同一时刻只有一个栈在最前面，其他的都在后台
```
``` {.line-numbers}
1.FLAG_ACTIVITY_NEW_TASK
  默认启动标志，该标志控制创建一个新的Activity实例，首先会查找是否存在和被启动的Activity具有相同的亲和性的任务栈 如果有，则直接把这个栈整体移动到前台，并保持栈中旧activity的顺序不变，然后被启动的Activity会被压入栈，如果没有，则新建一个栈来存放被启动的activity
  Intent intent = new Intent(A.this, A.class);
  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
  startActivity(intent);
2.FLAG_ACTIVITY_CLEAR_TOP
  如果已经启动了四个Activity：A，B，C和D。在D Activity里，我们要跳到BActivity，同时希望C finish掉,可以采用下面启动方式，这样启动B Activity，就会把D，C都finished掉
  Intent intent = new Intent(D.this, B.class);
  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
  startActivity(intent);
3.FLAG_ACTIVITY_SINGLE_TOP
  从名字中不难看出该Flag相当于Activity加载模式中的singleTop模式，即原来Activity栈中有A、B、C、D这4个Activity实例，当在Activity D中再次启动Activity D时，Activity栈中依然还是A、B、C、D这4个Activity实例。
  Intent intent = new Intent(D.this, D.class);
  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
  startActivity(intent);
```

## P54 启动模式
``` {.line-numbers}
模式详解：
standard模式 ：
  标准启动模式，也是activity的默认启动模式。在这种模式下启动的activity可以被多次实例化，即在同一个任务中可以存在多个activity的实例，每个实例都会处理一个Intent对象。如果Activity A的启动模式为standard，并且A已经启动，在A中再次启动Activity A，即调用startActivity（new Intent（this，A.class）），会在A的上面再次启动一个A的实例，即当前的桟中的状态为A-->A。
singleTop模式 ：
  如果一个以singleTop模式启动的Activity的实例已经存在于任务栈的栈顶，那么再启动这个Activity时，不会创建新的实例，而是重用位于栈顶的那个实例，并且会调用该实例的onNewIntent()方法将Intent对象传递到这个实例中。举例来说，如果A的启动模式为singleTop，并且A的一个实例已经存在于栈顶中，那么再调用startActivity（newIntent（this，A.class））启动A时，不会再次创建A的实例，而是重用原来的实例，并且调用原来实例的onNewIntent()方法。这时任务栈中还是这有一个A的实例。如果以singleTop模式启动的activity的一个实例 已经存在与任务栈中，但是不在栈顶，那么它的行为和standard模式相同，也会创建多个实例。
singleTask模式 ：
  只允许在系统中有一个Activity实例。如果系统中已经有了一个实例，持有这个实例的任务将移动到顶部，同时intent将被通过onNewIntent()发送。如果没有，则会创建一个新的Activity并置放在合适的任务中。
singleInstance模式 ：
  保证系统无论从哪个Task启动Activity都只会创建一个Activity实例,并将它加入新的Task栈顶也就是说被该实例启动的其他activity会自动运行于另一个Task中。当再次启动该activity的实例时，会重用已存在的任务和实例。并且会调用这个实例 的onNewIntent()方法，将Intent实例传递到该实例中。和singleTask相同，同一时刻在系统中只会存在一个这样的Activity实例。
```
### P54 启动模式 standard模式:
![standard模式](./image/standard模式.png)

### P54 启动模式 singleTop模式:
**singleTop只要处于栈顶就不会重复创建，如果没有处于栈顶还是会重复创建**  
在该模式下，如果栈顶Activity为我们要新建的Activity（目标Activity），那么就不会重复创建新的Activity。  
![singleTop模式](./image/singleTop模式.png)

### P54 启动模式 singleTask模式:
``` {.line-numbers}
与singleTop模式相似，只不过singleTop模式是只是针对栈顶的元素，而singleTask模式下，如果task栈内存在目标Activity实例，则：
将task内的对应Activity实例之上的所有Activity弹出栈。
将对应Activity置于栈顶，获得焦点。
```
![singleTask模式](./image/singleTask模式.png)

### P54 启动模式 singleInstance（全局唯一）模式:
是我们最后的一种启动模式，也是我们最恶心的一种模式：在该模式下，我们会为目标Activity分配一个新的affinity，并创建一个新的Task栈，将目标Activity放入新的Task，并让目标Activity获得焦点。新的Task有且只有这一个Activity实例。 如果已经创建过目标Activity实例，则不会创建新的Task，而是将以前创建过的Activity唤醒（对应Task设为Foreground状态）
![singleInstance模式](./image/singleInstance模式.png)
```xml {.line-numbers}

```