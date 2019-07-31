package com.wanandroid.zhangtianzhu.animatorchange.widget;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * @author yif
 * @description 表盘视图
 */
public class DialView extends View {
    /**
     * 表盘颜色
     */
    private static final String DEFAULT_DIAL_LINE_COLOR = "#3A5DFE";
    /**
     * 表盘的指针颜色
     */
    private static final String DEFAULT_POINTER_COLOR = "#FE3171";
    /**
     * 默认画笔宽度
     */
    private static final float LINE_WIDTH = dpToPx(5f);
    /**
     * 线的间隔，每根线相隔 10 度
     */
    private static final float LINE_INTERVAL = 10;
    /**
     * 线的条数
     */
    private static final int DEFAULT_LINE_COUNT = 5;
    /**
     * 动画时长
     */
    private static final int DURATION = 2500;

    private int mDialLineColor;
    private int mPointerColor;
    private float mWidth;

    /**
     * 线的个数
     */
    private int mLineCount;
    /**
     * 每个项的角度
     */
    private float mEachAngle;
    private float mPointerCircleRadius;
    private float mPointerLength;

    /**
     * 指针对应的指标路径
     */
    private Path mLinePath;

    /**
     * 指针路径
     */
    private Path mPointerPath;
    private Paint mLinePaint;
    private Paint mPointerPaint;

    private RectF mRectF;

    private ObjectAnimator mAnimator;

    /**
     * 当前项
     */
    private int mValue = 4;

    /**
     * 当前选择角度
     */
    private float mRoteAngle;

    public DialView(Context context) {
        this(context, null);
    }

    public DialView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setDialLineColor(Color.parseColor(DEFAULT_DIAL_LINE_COLOR));
        setPointerColor(Color.parseColor(DEFAULT_POINTER_COLOR));

        mLinePath = new Path();
        mPointerPath = new Path();

        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(LINE_WIDTH);

        mPointerPaint = new Paint();
        mPointerPaint.setAntiAlias(true);
        mPointerPaint.setStyle(Paint.Style.FILL);

        mRectF = new RectF();
        setLineCount(DEFAULT_LINE_COUNT);
    }

    /**
     * 设置线条数量
     *
     * @param lineCount
     */
    public void setLineCount(int lineCount) {
        this.mLineCount = lineCount + 1;
        mEachAngle = 360 / mLineCount - LINE_INTERVAL;
        mRoteAngle = 180 + mEachAngle / 2 + LINE_INTERVAL;
        createLinePath();
    }

    /**
     * 设置 指针的颜色
     *
     * @param pointerColor 指针的颜色
     */
    public void setPointerColor(int pointerColor) {
        this.mPointerColor = pointerColor;
    }

    /**
     * 设置 线的颜色
     *
     * @param dialLineColor 线的颜色
     */
    public void setDialLineColor(int dialLineColor) {
        this.mDialLineColor = dialLineColor;
    }

    public void start() {
        if (mAnimator != null) {
            mAnimator.cancel();
        }

        //第一个参数表示操作哪个控件，第二个参数表示操作这个控件的哪个属性,curPointAngle相当于调用下面setCurPointAngle方法
        //ObjectAnimator就会实时把动画产生的值传递给DiaLView类的setCurPointAngle方法然后重绘当前界面,值是从180 + mEachAngle / 2 + LINE_INTERVAL开始，
        //到mValue * (mEachAngle + LINE_INTERVAL) + 180结束
        mAnimator = ObjectAnimator.ofFloat(this,
                "curPointAngle",
                180 + mEachAngle / 2 + LINE_INTERVAL,
                mValue * (mEachAngle + LINE_INTERVAL) + 180);
        mAnimator.setDuration(DURATION);
        mAnimator.setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float x) {
                float factor = 0.45f;
                return (float) (Math.pow(2, -10 * x) * Math.sin((x - factor / 4) * (Math.PI * 2) / factor) + 1);
            }
        });
        mAnimator.start();
    }

    public void reset() {
        if (mAnimator != null) {
            mAnimator.cancel();
        }

        mRoteAngle = mEachAngle / 2 + LINE_INTERVAL + 180;
        invalidate();
    }


    public void setValue(int mValue) {
        this.mValue = mValue;
    }

    private void setCurPointAngle(float angle) {
        this.mRoteAngle = angle;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = Math.min(w, h);
        //宽度比例
        float mPointerCircleWidthRatio = 6;
        mPointerCircleRadius = mWidth / mPointerCircleWidthRatio / 2;
        //指针长度比例
        float mPointerLengthRatio = 4;
        mPointerLength = mWidth / mPointerLengthRatio;
        mRectF.top = LINE_WIDTH / 2;
        mRectF.right = mWidth - LINE_WIDTH / 2;
        mRectF.bottom = mWidth - LINE_WIDTH / 2;
        mRectF.left = LINE_WIDTH / 2;
        createLinePath();
        createPointerPath();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawDialLine(canvas);

        drawPointer(canvas);
    }

    private void drawPointer(Canvas canvas) {
        canvas.save();
        canvas.translate(mWidth / 2, mWidth / 2);
        //实现表盘旋转效果，是通过旋转当前画布来实现表盘自身旋转的错觉
        canvas.rotate(mRoteAngle);
        mPointerPaint.setColor(mPointerColor);
        canvas.drawPath(mPointerPath, mPointerPaint);
        canvas.restore();
    }

    private void drawDialLine(Canvas canvas) {
        mLinePaint.setColor(mDialLineColor);
        canvas.drawPath(mLinePath, mLinePaint);
    }

    private void createLinePath() {
        mLinePath.reset();
        for (int i = 0; i < mLineCount - 1; i++) {
            mLinePath.addArc(mRectF,
                    getRealOffsetAngle() + i * (mEachAngle + LINE_INTERVAL),
                    mEachAngle);
        }
    }

    private void createPointerPath() {
        RectF rectF = new RectF(
                -mPointerCircleRadius,
                -mPointerCircleRadius,
                mPointerCircleRadius,
                mPointerCircleRadius
        );
        mPointerPath.moveTo(mPointerCircleRadius, 0);
        mPointerPath.addArc(rectF, 0, 180);
        mPointerPath.lineTo(0, -mPointerLength);
        mPointerPath.lineTo(mPointerCircleRadius, 0);
        mPointerPath.close();
    }

    private float getRealOffsetAngle() {
        return 90 + mEachAngle / 2 + LINE_INTERVAL;
    }

    /**
     * 转换 dp 至 px
     *
     * @param dpValue dp值
     * @return px值
     */
    private static int dpToPx(float dpValue) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) (dpValue * metrics.density + 0.5f);
    }
}
