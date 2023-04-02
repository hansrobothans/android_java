[TOC]

# P10_MainActivity
新建工程  

# P15_ViewGroupActivity
通过java代码实例化布局参数，并加载  

# P19_LayoutParamsActivity
获取布局参数，并在log中显示出来  

# P20_PaddingMarginActivity
内外边距
   margin外边距  
   padding内边距  

# P21_LinearLayoutActivity
线性布局  
## 方向
竖直  
```
android:orientation="vertical" 
``` 
水平
```  
android:orientation="horizontal"  
``` 
## weigh权重
```  
android:layout_weight="2"
```  
设置权重则对应方向尺寸失效，所以最好设置为0。
如
```
android:layout_width="0dp"
android:layout_height="0dp"
```

# P22_RelativeLayoutActivity
相对布局  
## 属性说明：
### 相对于兄弟元素  
|属性名称|属性含义|
|---|----|
|android:layout_below="@id/aaa" |在指定View的下方|
|android:layout_above="@id/aaa" |在指定View的上方|
|android:layout_toLeftOf="@id/aaa" |在指定View的左边|
|android:layout_toRightOf="@id/aaa" |在指定View的右边|
|android:layout_alignTop="@id/aaa" |与指定View的上边界一致|
|android:layout_alignBottom="@id/aaa" |与指定View下边界一致|
|android:layout_alignLeft="@id/aaa" |与指定View的左边界一致|
|android:layout_alignRight="@id/aaa" |与指定View的右边界一致|
### 相对于父元素
|属性名称 |属性含义|
|---|----|
|android:layout_alignParentLeft="true" |在父元素内左边|
|android:layout_alignParentRight="true" |在父元素内右边|
|android:layout_alignParentTop="true" |在父元素内顶部|
|android:layout_alignParentBottom="true" |在父元素内底部|
###  对齐方式
|属性名称| 属性含义|
|---|----|
|android:layout_centerInParent="true" |居中布局|
|android:layout_centerVertical="true" |垂直居中布局|
|android:layout_centerHorizontal="true" |水平居中布局|
###  间隔
|属性名称 |属性含义|
|---|----|
|android:layout_marginBottom="" |离某元素底边缘的距离|
|android:layout_marginLeft="" |离某元素左边缘的距离|
|android:layout_marginRight ="" |离某元素右边缘的距离|
|android:layout_marginTop="" |离某元素上边缘的距离|
|android:layout_paddingBottom="" |往内部元素底边缘填充距离|
|android:layout_paddingLeft="" |往内部元素左边缘填充距离|
|android:layout_paddingRight ="" |往内部元素右边缘填充距离|
|android:layout_paddingTop="" |往内部元素右边缘填充距离|

# P23_FrameLayoutActivity
帧布局  
帧布局的特点，会按照排列顺序依次覆盖  

# P24_GridLayoutActivity
网格布局  
## 问题一
[按钮颜色始终是蓝紫色解决办法](https://www.cnblogs.com/szyx/p/16376851.html)  
我的解决方法：  
默认的颜色设置来自于res/values/themes.xml与夜间模式下的res/values-night/themes.xml  
修改themes.xml下的  
```html
<style name="Theme.HelloWorld" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
```
修改为
```html
<style name="Theme.HelloWorld" parent="Theme.MaterialComponents.DayNight.DarkActionBar.Bridge">
```
## 属性
|名称 |含义|
|---|----|
|android:columnCount |列数|
|android:rowCount |行数|
|android:layout_columnSpan |横跨的列数|
|android:layout_rowSpan |横跨的行数|
```xml {.line-numbers}
<!--    android:layout_gravity="fill"-->
<!--    设置这个属性才会填充满两列-->
```

# P25_TextViewActivity
## TextView (文本框)
用于显示文本的一个控件。  
**文本的字体尺寸单位为 sp :**  
   sp: scaled pixels(放大像素). 主要用于字体显示。  
## TextView 属性   
|属性名 |作用|
|---|----|
|id |为TextView设置一个组件id，根据id，我们可以在Java代码中通过findViewById()的方法获取到该对象，然后进行相关属性的设置|
|layout_width |组件的宽度|
|layout_height |组件的高度|
|gravity |设置控件中内容的对齐方向，TextView中是文字，ImageView中是图片等等|
|text|设置显示的文本内容，一般我们是把字符串写到string.xml文件中，然后通过@String/xxx取得对应的字符串内容的|
|textColor |设置字体颜色，同上，通过colors.xml资源来引用|
|textStyle |设置字体风格，三个可选值：normal(无效果)，bold(加粗)，italic(斜体)|
|textSize |字体大小，单位一般是用sp|
|background |控件的背景颜色，可以理解为填充整个控件的颜色，可以是图片|
|autoLink |识别链接类型 （web, email, phone ,map ,none, all）|

# P26_TextViewShapeActivity
文本设置边框

## 实现原理：
编写一个ShapeDrawable的资源文件！然后TextView将 background 设置为这个drawable资源即可
## ShapeDrawable的资源文件
* <solid android:color = "xxx"> 这个是设置背景颜色的
* <stroke android:width = "xdp" android:color="xxx"> 这个是设置边框的粗细,以及边框颜色的
* <padding androidLbottom = "xdp"...> 这个是设置边距的
* <corners android:topLeftRadius="10px"...> 这个是设置圆角的
* <gradient> 这个是设置渐变色的,可选属性有: startColor:起始颜色 endColor:结束颜色 centerColor:中间颜色 angle:方向角度,等于0时,从左到右,然后逆时针方向转,当angle = 90度时从下往上 type:设置渐变的类型编写矩形边框的Drawable：
* 编写矩形边框的Drawable：
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape
   xmlns:android="http://schemas.android.com/apk/res/android"
   >
<!-- 设置一个黑色边框 -->
   <stroke android:width="2px" android:color="#000000"/>
<!-- 渐变 -->
   <gradient
      android:angle="270"
      android:endColor="#C0C0C0"
      android:startColor="#FCD209" />
<!-- 设置一下边距,让空间大一点 -->
   <padding
      android:left="5dp"
      android:top="5dp"
      android:right="5dp"
      android:bottom="5dp"/>
</shape>
```
* 编写圆角矩形边框的Drawable
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape
  xmlns:android="http://schemas.android.com/apk/res/android"
  >
  <!-- 设置透明背景色 -->
  <solid android:color="#87CEEB" />
  <!-- 设置一个黑色边框 -->
  <stroke
    android:width="2px"
    android:color="#000000" />
  <!-- 设置四个圆角的半径 -->
  <corners
    android:bottomLeftRadius="10px"
    android:bottomRightRadius="10px"
    android:topLeftRadius="10px"
    android:topRightRadius="10px" />
  <!-- 设置一下边距,让空间大一点 -->
  <padding
    android:bottom="5dp"
    android:left="5dp"
    android:right="5dp"
    android:top="5dp" />
</shape>
```
* 带图片(drawableXxx)的TextView   

|属性名 |作用|
|---|---|
|android:drawableLeft |文本左边设置图片|
|android:drawableRight |文本右边设置图片|
|android:drawableBottom |文本下边设置图片|
|android:drawableTop |文本上边设置图片|

# shape的使用
在Android开发中，我们可以使用shape定义各种各样的形状，也可以定义一些图片资源。相对于传统图片来说，使用shape可以减少资源占用，减少安装包大小，还能够很好地适配不同尺寸的手机。  
## 1. shape属性
shape 属性基本语法示例：  
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape
  xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape=["rectangle" | "oval" | "line" | "ring"] > // 定义形状
  <corners //圆角属性
    android:radius="integer"
    android:topLeftRadius="integer"
    android:topRightRadius="integer"
    android:bottomLeftRadius="integer"
    android:bottomRightRadius="integer" />
  <gradient //渐变属性
    android:angle="integer"
    android:centerX="integer"
    android:centerY="integer"
    android:centerColor="integer"
    android:endColor="color"
    android:gradientRadius="integer"
    android:startColor="color"
    android:type=["linear" | "radial" | "sweep"]
    android:useLevel=["true" | "false"] />
  <padding //边距属性
    android:left="integer"
    android:top="integer"
    android:right="integer"
    android:bottom="integer" />
  <size //大小属性
    android:width="integer"
    android:height="integer" />
  <solid //填充属性
    android:color="color" />
  <stroke //描边属性
    android:width="integer"
    android:color="color"
    android:dashWidth="integer"
    android:dashGap="integer" />
</shape>
```
## 2. 基本属性
Shape可以定义控件的一些展示效果，例如圆角，渐变，填充，描边，大小，边距； shape 子标签就可以实现这些效果， shape 子标签有下面几个属性：corners，gradient，padding，size，solid，stroke：  

* **corners（圆角）**是用来字义圆角
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
  <corners //定义圆角
    android:radius="10dp" //全部的圆角半径；
    android:topLeftRadius="5dp" //左上角的圆角半径；
    android:topRightRadius="5dp" //右上角的圆角半径；
    android:bottomLeftRadius="5dp" //左下角的圆角半径；
    android:bottomRightRadius="5dp" /> //右下角的圆角半径。
</shape>
```
* **solid（填充色）**是用以指定内部填充色；
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
  <solid android:color="#ffff00"/> //内部填充色
</shape>
```
* **gradient（渐变）**用以定义渐变色，可以定义两色渐变和三色渐变，及渐变样式；
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
  <gradient
    android:type=["linear" | "radial" | "sweep"] //共有3中渐变类型，线性渐变（默认）/放射渐变/扫描式渐变；
    android:angle="90" //渐变角度，必须为45的倍数，0为从左到右，90为从上到下；
    android:centerX="0.5" //渐变中心X的相当位置，范围为0～1；
    android:centerY="0.5" //渐变中心Y的相当位置，范围为0～1；
    android:startColor="#24e9f2" //渐变开始点的颜色；
    android:centerColor="#2564ef" //渐变中间点的颜色，在开始与结束点之间；
    android:endColor="#25f1ef" //渐变结束点的颜色；
    android:gradientRadius="5dp" //渐变的半径，只有当渐变类型为radial时才能使用；
    android:useLevel="false" /> //使用LevelListDrawable时就要设置为true。设为false时才有渐变效果。
</shape>
```
* **stroke（描边）**是描边属性，可以定义描边的宽度，颜色，虚实线等；
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
  <stroke
    android:width="1dp" //描边的宽度
    android:color="#ff0000" //描边的颜色
    // 以下两个属性设置虚线
    android:dashWidth="1dp" //虚线的宽度，值为0时是实线
    android:dashGap="1dp" /> //虚线的间隔
</shape>
```
* **padding（内边距）**是用来定义内部边距
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
  <padding
    android:left="10dp" //左内边距；
    android:top="10dp" //上内边距；
    android:right="10dp" //右内边距；
    android:bottom="10dp" /> //下内边距。
</shape>
```
* **size（大小）**标签是用来定义图形的大小的
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android" >
  <size
    android:width="50dp" //宽度
    android:height="50dp" />// 高度
</shape>
```
## 3. 特殊属性
Shape可以定义当前Shape的形状的，比如矩形，椭圆形，线形和环形；这些都是通过 shape 标签属性来定义的， shape 标签有下面几个属性：rectangle，oval，line，ring：  
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape=["rectangle" | "oval" | "line" | "ring"] //shape的形状，默认为矩形，可以设置为矩形(rectangle)、椭圆形(oval)、线性形状(line)、环形(ring)
  //下面的属性只有在android:shape="ring"时可用：
  android:innerRadius="10dp" // 内环的半径；
  android:innerRadiusRatio="2" // 浮点型，以环的宽度比率来表示内环的半径；
  android:thickness="3dp" // 环的厚度；
  android:thicknessRatio="2" // 浮点型，以环的宽度比率来表示环的厚度；
  android:useLevel="false"> // boolean值，如果当做是LevelListDrawable使用时值为true，否则为false。
</shape>
```
* rectangle（矩形）
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape="rectangle">
  <solid android:color="@color/colorPrimary"/>
</shape>
```
* oval（椭圆）
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape="oval">
  <solid android:color="@color/colorPrimary"/>
  <size android:height="100dp"
    android:width="100dp"/>
</shape>
```
* line（线）
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape="line">
  <stroke
    android:width="1dp"
    android:color="@color/colorAccent"
    android:dashGap="3dp"//虚线间距
    android:dashWidth="4dp"/>//虚线宽度
  <size android:height="3dp"/>
</shape>
```
* ring（圆环）
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
  android:shape="ring"
  android:useLevel="false"
  android:innerRadius="20dp" // 内环的半径
  android:thickness="10dp"> // 圆环宽度
  <!--useLevel需要设置为false-->
  <solid android:color="@color/colorAccent"/>
</shape>
```
## 4. shape用法
1. 在res/drawable下新建 shape_text.xml 文件；
2. 在布局中引用 shape_text.xml 文件；

# P27_EditTextActivity
1. EditText 输入框，集成与TextView, 也继承其属性
## EditText 特有属性

|属姓名 |说明|
|---|---|
|android:hint |默认提示文本|
|android:textColorHint |默认提示文本的颜色|
|android:selectAllOnFocus |布尔值。点击输入框获得焦点后，获取到输入框中所有的文本内容|
|android:inputType |对输入的数据进行限制|
|android:minLines |设置最小行数|
|android:maxLines |设置最大行数 PS:当输入内容超过maxline,文字会自动向上滚动！！|
|android:singleLine |只允许单行输入，而且不会滚动|
|android:textScaleX |设置字与字的水平间隔|
|android:textScaleY |设置字与字的垂直间隔|
|android:capitalizesentences：|仅第一个字母大写 ；words：每一个单词首字母大小，用空格区分单词；characters:每一个英文字母都大写|

# P28_ButtonActivity
Button(按钮)
Button 控件继承 TextView ，拥有 TextView 的属性
StateListDrawable 简介
StateListDrawable 是Drawable资源的一种，可以根据不同的状态，设置不同的图片效果，关键节点 < selector > ，我们只需要将Button的 background 属性设置为该drawable资源即可轻松实现，按下 按钮时不同的按钮颜色或背景！  
|属性名 |说明|
|---|--|
drawable |引用的Drawable位图,我们可以把他放到最前面,就表示组件的正常状态~|
|state_focused |是否获得焦点|
|state_window_focused |是否获得窗口焦点|
|state_enabled |控件是否可用|
|state_checkable |控件可否被勾选|
|state_checked |控件是否被勾选|
|state_selected |控件是否被选择,针对有滚轮的情况|
|state_pressed |控件是否被按下|
|state_active |控件是否处于活动状态|
|state_single |控件包含多个子控件时,确定是否只显示一个子控件|
|state_first |控件包含多个子控件时,确定第一个子控件是否处于显示状态|
|state_middle |控件包含多个子控件时,确定中间一个子控件是否处于显示状态|
|state_last |控件包含多个子控件时,确定最后一个子控件是否处于显示状态|

* btn_bg1.xml
```xml {.line-numbers}
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
  <item android:drawable="@color/color1" android:state_pressed="true"/>
  <item android:drawable="@color/color4" android:state_enabled="false"/>
  <item android:drawable="@color/color3" />
</selector>
```

# P29_ImageViewActivity
ImageView 见名知意，就是用来显示图像的一个View或者说控件
需掌握的知识点：
1. ImageView的src属性和blackground的区别；
2. adjustViewBounds设置图像缩放时是否按长宽比
3. scaleType设置缩放类型
4. 最简单的绘制圆形的ImageView
## src属性和background属性的区别
在API文档中我们发现ImageView有两个可以设置图片的属性，分别是：src和background
常识：  
1. background通常指的都是背景,而src指的是内容!!  
2. 当使用src填入图片时,是按照图片大小直接填充,并不会进行拉伸,而使用background填入图片,则是会根据ImageView给定的宽度来进行拉伸  
## Java代码中设置blackground和src属性:
```java {.line-numbers}
setImageDrawable();//前景(对应src属性):
setBackgroundDrawable();//背景(对应background属性):
```
## scaleType 属性 android:scaleType
android:scaleType用于设置显示的图片如何缩放或者移动以适应ImageView的大小 
Java代码中可以通过
```java {.line-numbers}
imageView.setScaleType(ImageView.ScaleType.CENTER);
```
来设置~ 可选值如下：
1. fitXY:对图像的横向与纵向进行独立缩放,使得该图片完全适应ImageView,但是图片的横纵比可能会发生改变
2. fitStart:保持纵横比缩放图片,知道较长的边与Image的编程相等,缩放完成后将图片放在ImageView的左上角
3. fitCenter:同上,缩放后放于中间;
4. fitEnd:同上,缩放后放于右下角;
5. center:保持原图的大小，显示在ImageView的中心。当原图的size大于ImageView的size，超过部分裁剪处理。
6. centerCrop:保持横纵比缩放图片,知道完全覆盖ImageView,可能会出现图片的显示不完全
7. centerInside:保持横纵比缩放图片,直到ImageView能够完全地显示图片
8. matrix:默认值，不改变原图的大小，从ImageView的左上角开始绘制原图， 原图超过ImageView的部分作裁剪处理

# P30_RadioButtonActivity
## RadioButton (单选按钮) 基本用法与事件处理：
单选按钮，就是只能够选中一个，所以我们需要把RadioButton放到RadioGroup按钮组中，从而实现 单选功能！
先熟悉下如何使用RadioButton，一个简单的性别选择的例子： 
另外我们可以为外层RadioGroup设置orientation属性然后设置RadioButton的排列方式，是竖直还是水平
## 获得选中的值：这里有两种方法
1. 第一种是为 RadioButton 设置一个事件监听器 setOnCheckChangeListener
```java {.line-numbers}
RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
//第一种获得单选按钮值的方法
//为radioGroup设置一个监听器:setOnCheckedChanged()
radgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
   @Override
   public void onCheckedChanged(RadioGroup group, int checkedId) {
      RadioButton radbtn = (RadioButton) findViewById(checkedId);
      Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
   }
});
```
PS：另外有一点要切记，要为每个 RadioButton 添加一个id，不然单选功能不会生效！！！
2. 第二种方法是通过单击其他按钮获取选中单选按钮的值，当然我们也可以直接获取，这个看需求~
```java {.line-numbers} linenos
Button btnchange = (Button) findViewById(R.id.btnpost);
RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
//为radioGroup设置一个监听器:setOnCheckedChanged()
btnchange.setOnClickListener(new OnClickListener() {
   @Override
   public void onClick(View v) {
      for (int i = 0; i < radgroup.getChildCount(); i++) {
         RadioButton rd = (RadioButton) radgroup.getChildAt(i);
         if (rd.isChecked()) {
            Toast.makeText(getApplicationContext(), "点击提交按钮,获取你选择的是:" + rd.getText(), Toast.LENGTH_LONG).show();
            break;
         }
      }
   }
});
```
代码解析： 
这里我们为提交按钮设置了一个 setOnClickListener 事件监听器,每次点击的话遍历一次RadioGroup判断哪个按钮被选中。
我们可以通过下述方法获得RadioButton的相关信息！
```java {.line-numbers}
getChildCount( )//获得按钮组中的单选按钮的数目；
getChinldAt(i)//根据索引值获取我们的单选按钮
isChecked( )//判断按钮是否选中
```



```python linenos
def greet(name):
    print("Hello, " + name + "!")
```


* 
```xml {.line-numbers}

```
