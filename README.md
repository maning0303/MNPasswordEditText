# MNPasswordEditText [![](https://jitpack.io/v/maning0303/MNPasswordEditText.svg)](https://jitpack.io/#maning0303/MNPasswordEditText)
Android验证码和密码输入框，能自定义输入框个数和样式（连体，下划线和方形框）
类似微信支付宝的密码输入框等


## 截图：
![](https://github.com/maning0303/MNPasswordEditText/raw/master/screenshots/mn_pswedittext_001.jpeg)
![](https://github.com/maning0303/MNPasswordEditText/raw/master/screenshots/mn_pswedittext_002.jpeg)


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
	     implementation 'com.github.maning0303:MNPasswordEditText:V1.0.3'
	}
```

### 2:源码Module添加：
#### 直接关联pswedittextlibrary

``` gradle

	implementation project(':pswedittextlibrary')

```

## 使用方法(查看Demo详情):

### 1:自定义参数介绍:
``` java

<declare-styleable name="MNPasswordEditText">
        <!--密码框的颜色-->
        <attr name="psw_border_color" format="color" />
        <!--密码框选中的颜色-->
        <attr name="psw_border_selected_color" format="color" />
        <!--密码文字的颜色,圆形密码颜色-->
        <attr name="psw_text_color" format="color" />
        <!--密码框的圆角-->
        <attr name="psw_border_radius" format="dimension" />
        <!--密码框的线的大小-->
        <attr name="psw_border_width" format="dimension" />
        <!--密码框的每个间隔,只有样式2才起作用-->
        <attr name="psw_item_margin" format="dimension" />
        <!--密码框背景色-->
        <attr name="psw_background_color" format="color" />
        <!--密码框输入的模式:4.明文,3.文字,2.图片,1.圆形-->
        <attr name="psw_mode" format="enum">
            <!--圆形默认-->
            <enum name="Circle" value="1" />
            <!--图片-->
            <enum name="Bitmap" value="2" />
            <!--文本-->
            <enum name="Text" value="3" />
            <!--原始-->
            <enum name="OriginalText" value="4" />
        </attr>
        <!--密码框样式: 1.连在一起 2.分开单独显示  3.下划线形式-->
        <attr name="psw_style" format="enum">
            <!--连在一起-->
            <enum name="StyleDefault" value="1" />
            <!--单独-->
            <enum name="StyleOneself" value="2" />
            <!--下划线形式-->
            <enum name="StyleUnderLine" value="3" />
        </attr>
        <!--密码文字遮盖-->
        <attr name="psw_cover_text" format="string" />
        <!--密码图片遮盖-->
        <attr name="psw_cover_bitmap_id" format="reference" />
        <!--密码圆形遮盖颜色-->
        <attr name="psw_cover_circle_color" format="color" />
        <!--密码圆形遮盖半径-->
        <attr name="psw_cover_circle_radius" format="dimension" />
        <!--密码图片遮盖长宽-->
        <attr name="psw_cover_bitmap_width" format="dimension" />
        <!--是否显示光标-->
        <attr name="psw_show_cursor" format="boolean" />
        <!--光标颜色-->
        <attr name="psw_cursor_color" format="color" />
        <!--光标高度-->
        <attr name="psw_cursor_height" format="dimension" />
        <!--光标宽度-->
        <attr name="psw_cursor_width" format="dimension" />
        <!--光标圆角-->
        <attr name="psw_cursor_corner_radius" format="dimension" />

    </declare-styleable>

```

### 2:布局文件使用（详细查看Demo）:
``` java

       <com.maning.pswedittextlibrary.MNPasswordEditText
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:layout_marginTop="10dp"
            android:focusableInTouchMode="true"
            android:inputType="number"
            android:maxLength="6"
            android:textSize="20sp"
            app:psw_border_color="#267eb4"
            app:psw_border_radius="4dp"
            app:psw_border_selected_color="#dc10a2"
            app:psw_border_width="2dp"
            app:psw_cover_text="密"
            app:psw_cursor_width="10dp"
            app:psw_item_margin="10dp"
            app:psw_mode="Text"
            app:psw_show_cursor="true"
            app:psw_style="StyleOneself"
            app:psw_text_color="#393939" /

```

### 2:代码相关:
``` java

    mPswEditText = (MNPasswordEditText) findViewById(R.id.mPswEditText);
    //监听输入的过程
    mPswEditText.setOnTextChangeListener(new MNPasswordEditText.OnTextChangeListener() {
        @Override
        public void onTextChange(String text, boolean isComplete) {
            tvShow.setText(text);
            if (isComplete) {
                Toast.makeText(MainActivity.this, "输入完成", Toast.LENGTH_SHORT).show();
            }
        }
    });

```

## 其他详情请查看Demo


## 版本记录：
    v1.0.4:
        1.新增光标显示
        2.自定义属性名称调整


## 推荐:
Name | Describe |
--- | --- |
[GankMM](https://github.com/maning0303/GankMM) | （Material Design & MVP & Retrofit + OKHttp & RecyclerView ...）Gank.io Android客户端：每天一张美女图片，一个视频短片，若干Android，iOS等程序干货，周一到周五每天更新，数据全部由 干货集中营 提供,持续更新。 |
[MNUpdateAPK](https://github.com/maning0303/MNUpdateAPK) | Android APK 版本更新的下载和安装 |
[MNImageBrowser](https://github.com/maning0303/MNImageBrowser) | 交互特效的图片浏览框架,微信向下滑动动态关闭 |
[MClearEditText](https://github.com/maning0303/MClearEditText) | 带有删除功能的EditText |
[MNPasswordEditText](https://github.com/maning0303/MNPasswordEditText) | 类似微信支付宝的密码输入框。 |
[MNCrashMonitor](https://github.com/maning0303/MNCrashMonitor) | Debug监听程序崩溃日志,展示崩溃日志列表，方便自己平时调试。 |
[MNProgressHUD](https://github.com/maning0303/MNProgressHUD) | MNProgressHUD是对常用的自定义弹框封装,加载ProgressDialog,状态显示的StatusDialog和自定义Toast,支持背景颜色,圆角,边框和文字的自定义。 |
[MNZXingCode](https://github.com/maning0303/MNZXingCode) | 快速集成二维码扫描和生成二维码 |
[MNMLKitScanner](https://github.com/maning0303/MNMLKitScanner) | 基于Google ML Kit 快速集成二维码扫描 |
[MNChangeSkin](https://github.com/maning0303/MNChangeSkin) | Android夜间模式，通过Theme实现 |
[MNVideoPlayer](https://github.com/maning0303/MNVideoPlayer) | SurfaceView + MediaPlayer 实现的视频播放器，支持横竖屏切换，手势快进快退、调节音量，亮度等。------代码简单，新手可以看一看。 |
[SwitcherView](https://github.com/maning0303/SwitcherView) | 垂直滚动的广告栏文字展示。 |
[MNCalendar](https://github.com/maning0303/MNCalendar) | 简单的日历控件练习，水平方向日历支持手势滑动切换，跳转月份；垂直方向日历选取区间范围。 |
[MNSwipeToLoadDemo](https://github.com/maning0303/MNSwipeToLoadDemo) | 利用SwipeToLoadLayout实现的各种下拉刷新效果（饿了吗，京东，百度外卖，美团外卖，天猫下拉刷新等）。 |

