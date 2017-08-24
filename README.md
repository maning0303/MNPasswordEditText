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
	     compile 'com.github.maning0303:MNPasswordEditText:V1.0.1'
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

## 其他详情请查看Demo


## 推荐:
Name | Describe |
--- | --- |
[GankMM](https://github.com/maning0303/GankMM) | （Material Design & MVP & Retrofit + OKHttp & RecyclerView ...）Gank.io Android客户端：每天一张美女图片，一个视频短片，若干Android，iOS等程序干货，周一到周五每天更新，数据全部由 干货集中营 提供,持续更新。 |
[MNUpdateAPK](https://github.com/maning0303/MNUpdateAPK) | Android APK 版本更新的下载和安装,适配7.0,简单方便。 |
[MNImageBrowser](https://github.com/maning0303/MNImageBrowser) | 交互特效的图片浏览框架,微信向下滑动动态关闭 |
[MNCalendar](https://github.com/maning0303/MNCalendar) | 简单的日历控件练习，水平方向日历支持手势滑动切换，跳转月份；垂直方向日历选取区间范围。 |
[MClearEditText](https://github.com/maning0303/MClearEditText) | 带有删除功能的EditText |
[MNCrashMonitor](https://github.com/maning0303/MNCrashMonitor) | Debug监听程序崩溃日志,展示崩溃日志列表，方便自己平时调试。 |
[MNProgressHUD](https://github.com/maning0303/MNProgressHUD) | MNProgressHUD是对常用的自定义弹框封装,加载ProgressDialog,状态显示的StatusDialog和自定义Toast,支持背景颜色,圆角,边框和文字的自定义。 |
[MNXUtilsDB](https://github.com/maning0303/MNXUtilsDB) | xUtils3 数据库模块单独抽取出来，方便使用。 |
[MNVideoPlayer](https://github.com/maning0303/MNVideoPlayer) | SurfaceView + MediaPlayer 实现的视频播放器，支持横竖屏切换，手势快进快退、调节音量，亮度等。------代码简单，新手可以看一看。 |
[MNZXingCode](https://github.com/maning0303/MNZXingCode) | 快速集成二维码扫描和生成二维码 |
[MNChangeSkin](https://github.com/maning0303/MNChangeSkin) | Android夜间模式，通过Theme实现 |
[SwitcherView](https://github.com/maning0303/SwitcherView) | 垂直滚动的广告栏文字展示。 |
[MNPasswordEditText](https://github.com/maning0303/MNPasswordEditText) | 类似微信支付宝的密码输入框。 |
[MNSwipeToLoadDemo](https://github.com/maning0303/MNSwipeToLoadDemo) | 利用SwipeToLoadLayout实现的各种下拉刷新效果（饿了吗，京东，百度外卖，美团外卖，天猫下拉刷新等）。 |

