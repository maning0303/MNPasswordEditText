package com.maning.pswedittextlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Field;

/**
 * Created by maning on 2017/8/16.
 */

public class MNPasswordEditText extends EditText {

    private static final String TAG = "MNPasswordEditText";

    private Context mContext;
    //长度
    private int maxLength;
    //文字大小
    private float textSize;
    //文字的画笔
    private Paint mPaintText;
    //线的画笔
    private Paint mPaintLine;
    //背景色
    private int backgroundColor;
    private int borderColor;
    private int textColor;
    private float borderRadius;
    private float borderWidth;
    private float itemMargin;
    private int inputMode;
    private int editTextStyle;
    //文字遮盖
    private String coverText;
    private int coverBitmapID;
    private int coverCirclrColor;
    private float coverCirclrRadius;
    private float coverBitmapWidth;


    public MNPasswordEditText(Context context) {
        this(context, null);
    }

    public MNPasswordEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MNPasswordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        //初始化参数
        initAttrs(attrs, defStyleAttr);

        //初始化相关
        init();
    }

    private void initAttrs(AttributeSet attrs, int defStyleAttr) {
        TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.MNPasswordEditText, defStyleAttr, 0);

        //背景色
        backgroundColor = array.getColor(R.styleable.MNPasswordEditText_mnPsw_background_color, Color.parseColor("#FFFFFF"));
        //边框颜色
        borderColor = array.getColor(R.styleable.MNPasswordEditText_mnPsw_border_color, Color.parseColor("#FF0000"));
        //文字的颜色
        textColor = array.getColor(R.styleable.MNPasswordEditText_mnPsw_text_color, Color.parseColor("#FF0000"));
        //边框圆角
        borderRadius = array.getDimension(R.styleable.MNPasswordEditText_mnPsw_border_radius, dip2px(6));
        //边框线大小
        borderWidth = array.getDimension(R.styleable.MNPasswordEditText_mnPsw_border_width, dip2px(1));
        //每个密码框的间隔
        itemMargin = array.getDimension(R.styleable.MNPasswordEditText_mnPsw_item_margin, dip2px(10));
        //输入的模式
        inputMode = array.getInt(R.styleable.MNPasswordEditText_mnPsw_mode, 1);
        //整体样式
        editTextStyle = array.getInt(R.styleable.MNPasswordEditText_mnPsw_style, 1);
        //替换的图片
        coverBitmapID = array.getResourceId(R.styleable.MNPasswordEditText_mnPsw_cover_bitmap_id, -1);
        //替换的文字
        coverText = array.getString(R.styleable.MNPasswordEditText_mnPsw_cover_text);
        if (TextUtils.isEmpty(coverText)) {
            coverText = "密";
        }
        //圆形的颜色
        coverCirclrColor = array.getColor(R.styleable.MNPasswordEditText_mnPsw_cover_circle_color, Color.parseColor("#FF0000"));
        //密码圆形遮盖半径
        coverCirclrRadius = array.getDimension(R.styleable.MNPasswordEditText_mnPsw_cover_circle_radius, 0);
        //密码图片遮盖长宽
        coverBitmapWidth = array.getDimension(R.styleable.MNPasswordEditText_mnPsw_cover_bitmap_width, 0);

        //回收
        array.recycle();
    }

    private void init() {
        //最大的长度
        maxLength = getMaxLength();

        //文字的大小
        textSize = getTextSize();

        //初始化画笔
        //文字
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setStyle(Paint.Style.FILL);
        mPaintText.setColor(textColor);
        mPaintText.setTextSize(textSize);

        //线
        mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setColor(borderColor);
        mPaintLine.setStrokeWidth(borderWidth);

        //隐藏光标
        setCursorVisible(false);
        //设置本来文字的颜色为透明
        setTextColor(Color.TRANSPARENT);
        //触摸获取焦点
        setFocusableInTouchMode(true);
        //屏蔽长按
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //获取宽高
        int measuredWidth = getMeasuredWidth();
        float itemH = getMeasuredHeight();

        //判断类型
        if (editTextStyle == 1) {
            //初始化背景框
            GradientDrawable drawable = new GradientDrawable();
            drawable.setStroke((int) borderWidth, borderColor);
            drawable.setCornerRadius(borderRadius);
            drawable.setColor(backgroundColor);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                //Android系统大于等于API16，使用setBackground
                setBackground(drawable);
            } else {
                //Android系统小于API16，使用setBackgroundDrawable
                setBackgroundDrawable(drawable);
            }
            float itemW = measuredWidth / maxLength;
            //画线
            for (int i = 1; i < maxLength; i++) {
                float startX = itemW * i;
                float startY = 0;
                float stopX = startX;
                float stopY = itemH;
                canvas.drawLine(startX, startY, stopX, stopY, mPaintLine);
            }
        } else {
            float margin = itemMargin;
            float itemW = measuredWidth / maxLength - margin;
            GradientDrawable drawable = new GradientDrawable();
            drawable.setStroke((int) borderWidth, borderColor);
            drawable.setCornerRadius(borderRadius);
            drawable.setColor(backgroundColor);
            Bitmap bitmap = drawableToBitmap(drawable, (int) itemW, (int) itemH);
            //画每个Item背景
            for (int i = 0; i < maxLength; i++) {
                float left = itemW * i + margin / 2 + margin * i;
                float top = 0;
                canvas.drawBitmap(bitmap, left, top, mPaintLine);
            }

        }

        //写文字
        String currentText = getText().toString();
        for (int i = 0; i < maxLength; i++) {
            if (!TextUtils.isEmpty(currentText) && i < currentText.length()) {
                //<!--密码框输入的模式:4.明文,3.文字,2.图片,1.圆形-->
                if (inputMode == 1) {
                    //圆点半径
                    float circleRadius = measuredWidth / maxLength * 0.5f * 0.3f;
                    if (coverCirclrRadius > 0) {
                        circleRadius = coverCirclrRadius;
                    }
                    float startX = (measuredWidth / maxLength) / 2.0f + measuredWidth / maxLength * i;
                    float startY = (itemH) / 2.0f;
                    mPaintText.setColor(coverCirclrColor);
                    canvas.drawCircle(startX, startY, circleRadius, mPaintText);
                } else if (inputMode == 2) {
                    float picW = measuredWidth / maxLength * 0.5f;
                    if (coverBitmapWidth > 0) {
                        picW = coverBitmapWidth;
                    }
                    float startX = (measuredWidth / maxLength - picW) / 2.0f + measuredWidth / maxLength * i;
                    float startY = (itemH - picW) / 2.0f;
                    //判断有没有图片
                    if (coverBitmapID == -1) {
                        //抛出异常
                        throw new NullPointerException("遮盖图片为空");
                    } else {
                        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), coverBitmapID);
                        bitmap = Bitmap.createScaledBitmap(bitmap, (int) picW, (int) picW, true);
                        canvas.drawBitmap(bitmap, startX, startY, mPaintText);
                    }
                } else if (inputMode == 3) {
                    String StrPosition = coverText;
                    float fontWidth = getFontWidth(mPaintText, StrPosition);
                    float fontHeight = getFontHeight(mPaintText, StrPosition);
                    float startX = (measuredWidth / maxLength - fontWidth) / 2.0f + measuredWidth / maxLength * i;
                    float startY = (itemH + fontHeight) / 2.0f - 6;
                    mPaintText.setColor(textColor);
                    canvas.drawText(StrPosition, startX, startY, mPaintText);
                } else {
                    String StrPosition = String.valueOf(currentText.charAt(i));
                    float fontWidth = getFontWidth(mPaintText, StrPosition);
                    float fontHeight = getFontHeight(mPaintText, StrPosition);
                    float startX = (measuredWidth / maxLength - fontWidth) / 2.0f + measuredWidth / maxLength * i;
                    float startY = (itemH + fontHeight) / 2.0f;
                    mPaintText.setColor(textColor);
                    canvas.drawText(StrPosition, startX, startY, mPaintText);
                }
            }
        }


    }

    public static Bitmap drawableToBitmap(Drawable drawable, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(
                width,
                height,
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }


    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        //刷新界面
        invalidate();
        if (mOnPasswordChangeListener != null) {
            mOnPasswordChangeListener.onPasswordChange(getText().toString());
        }
    }

    public float getFontWidth(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    public float getFontHeight(Paint paint, String str) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public int getMaxLength() {
        int length = 0;
        try {
            InputFilter[] inputFilters = getFilters();
            for (InputFilter filter : inputFilters) {
                Class<?> c = filter.getClass();
                if (c.getName().equals("android.text.InputFilter$LengthFilter")) {
                    Field[] f = c.getDeclaredFields();
                    for (Field field : f) {
                        if (field.getName().equals("mMax")) {
                            field.setAccessible(true);
                            length = (Integer) field.get(filter);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    private int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private OnPasswordChangeListener mOnPasswordChangeListener;

    public void setOnPasswordChangeListener(OnPasswordChangeListener onPasswordChangeListener) {
        mOnPasswordChangeListener = onPasswordChangeListener;
    }

    public interface OnPasswordChangeListener {
        void onPasswordChange(String password);
    }

}
