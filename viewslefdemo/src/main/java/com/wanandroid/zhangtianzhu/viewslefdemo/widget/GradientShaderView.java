package com.wanandroid.zhangtianzhu.viewslefdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Java版 雷达
 */
public class GradientShaderView extends View {
    private float mWidth = 0;
    private Paint circlePaint;
    private Paint scanPaint;
    private int speed = 5;
    private int INTERVAL = 50;
    private float[] values = new float[]{0.2f,0.4f,0.6f,0.8f,1.0f};
    private float currentSize;
    private Matrix matrix;
    private Shader shader;
    private Runnable scanRunnable;
    public GradientShaderView(Context context) {
        this(context,null);
    }

    public GradientShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GradientShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        currentSize = dip2px(context,0.5f);
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(currentSize);
        scanPaint = new Paint();
        scanPaint.setAntiAlias(true);
        scanPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        matrix = new Matrix();
        scanRunnable = new Runnable() {
            @Override
            public void run() {
                matrix.postRotate(speed,mWidth/2,mWidth/2);
                invalidate();
                postDelayed(scanRunnable,INTERVAL);
            }
        };

        post(scanRunnable);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float tempWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight() - currentSize;
        float tempHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - currentSize;
        mWidth = Math.min(tempWidth,tempHeight);

        if(shader==null){
            shader = new SweepGradient(mWidth/2,mWidth/2,new int[]{Color.TRANSPARENT,Color.parseColor("#84B5CA")},null);
            scanPaint.setShader(shader);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(float pots: values){
            canvas.drawCircle(mWidth/2,mWidth/2,pots*mWidth/2,circlePaint);
        }

        canvas.concat(matrix);
        canvas.drawCircle(mWidth/2,mWidth/2,values[values.length-1]*mWidth/2,scanPaint);
    }

    public static int dip2px(Context context, float dipValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * density + 0.5f);
    }
}
