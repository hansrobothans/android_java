
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
```xml
<!--    android:layout_gravity="fill"-->
<!--    设置这个属性才会填充满两列-->
```
