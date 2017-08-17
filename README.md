# MNPasswordEditText [![](https://jitpack.io/v/maning0303/MNPasswordEditText.svg)](https://jitpack.io/#maning0303/MNPasswordEditText)
类似微信支付宝的密码输入框


## 截图：
![](https://github.com/maning0303/MNPasswordEditText/raw/master/screenshots/mn_pswedittext_001.png)


## 如何添加
### 1:Gradle添加：
#### 1.在Project的build.gradle中添加仓库地址

``` gradle
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

#### 2.在app目录下的build.gradle中添加依赖
``` gradle
	dependencies {
	     compile 'com.github.maning0303:MNPasswordEditText:V1.0.0'
	}
```

### 2:源码Module添加：
#### 直接关联pswedittextlibrary

``` gradle

	compile project(':pswedittextlibrary')

```

## 使用方法(查看Demo详情):

### 1:自定义参数介绍:
``` java

<declare-styleable name="MNPasswordEditText">

        <!--密码框的颜色-->
        <attr name="mnPsw_border_color" format="color"/>
        <!--密码文字的颜色,圆形密码颜色-->
        <attr name="mnPsw_text_color" format="color"/>
        <!--密码框的圆角-->
        <attr name="mnPsw_border_radius" format="dimension"/>
        <!--密码框的线的大小-->
        <attr name="mnPsw_border_width" format="dimension"/>
        <!--密码框的每个间隔,只有样式2才起作用-->
        <attr name="mnPsw_item_margin" format="dimension"/>
        <!--密码框背景色-->
        <attr name="mnPsw_background_color" format="color"/>
        <!--密码框输入的模式:4.明文,3.文字,2.图片,1.圆形-->
        <attr name="mnPsw_mode" format="enum">
            <!--圆形默认-->
            <enum name="Circle" value="1"/>
            <!--图片-->
            <enum name="Bitmap" value="2"/>
            <!--文本-->
            <enum name="Text" value="3"/>
            <!--原始-->
            <enum name="OriginalText" value="4"/>
        </attr>
        <!--密码框样式: 1.连在一起 2.分开单独显示-->
        <attr name="mnPsw_style" format="enum">
            <!--连在一起-->
            <enum name="StyleDefault" value="1"/>
            <!--单独-->
            <enum name="StyleOneself" value="2"/>
        </attr>
        <!--密码文字遮盖-->
        <attr name="mnPsw_cover_text" format="string"/>
        <!--密码图片遮盖-->
        <attr name="mnPsw_cover_bitmap_id" format="reference"/>
        <!--密码圆形遮盖颜色-->
        <attr name="mnPsw_cover_circle_color" format="color"/>
        <!--密码圆形遮盖半径-->
        <attr name="mnPsw_cover_circle_radius" format="dimension"/>
        <!--密码图片遮盖长宽-->
        <attr name="mnPsw_cover_bitmap_width" format="dimension"/>

    </declare-styleable>

```

### 2:布局文件使用:
``` java

    <com.maning.pswedittextlibrary.MNPasswordEditText
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="10dp"
        android:focusableInTouchMode="true"
        android:inputType="number"
        android:maxLength="6"
        android:textSize="20sp"
        app:mnPsw_background_color="#FFFFFF"
        app:mnPsw_border_color="#7e7e7e"
        app:mnPsw_border_radius="2dp"
        app:mnPsw_border_width="2dp"
        app:mnPsw_cover_bitmap_id="@mipmap/ic_launcher"
        app:mnPsw_cover_bitmap_width="30dp"
        app:mnPsw_item_margin="5dp"
        app:mnPsw_mode="Bitmap"
        app:mnPsw_style="StyleOneself"
        app:mnPsw_text_color="#393939"
        />

```

### 2:代码相关:
``` java

    mPswEditText = (MNPasswordEditText) findViewById(R.id.mPswEditText);
    //监听密码输入
    mPswEditText.setOnPasswordChangeListener(new MNPasswordEditText.OnPasswordChangeListener() {
        @Override
        public void onPasswordChange(String password) {
            tvShow.setText(password);
        }
    });

```

## 其他详情请查看Demo:

