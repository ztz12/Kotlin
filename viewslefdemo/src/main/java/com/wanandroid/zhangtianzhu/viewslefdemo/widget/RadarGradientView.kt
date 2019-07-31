package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanandroid.zhangtianzhu.base.UIUtils
import com.wanandroid.zhangtianzhu.viewslefdemo.R

class RadarGradientView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    //雷达图宽与高
    private var mWidth = 0f
    private val circlePaint = Paint()

    //圆的间隔
    private val circleValus = floatArrayOf(0.2f, 0.4f, 0.6f, 0.8f, 1f)
    //扫描画笔
    private val scanPaint = Paint()
    //扫描线程
    private lateinit var scanRunnable: Runnable
    //扫描速率
    private val speed = 5f

    //矩阵旋转变化
    private val matrixRadar = Matrix()
    //扫描渲染，着色器
    private var scanShader: Shader? = null
    //更新间隔
    private val INTERVAL: Long = 50

    init {
        circlePaint.style = Paint.Style.STROKE
        circlePaint.isAntiAlias = true
        circlePaint.color = resources.getColor(R.color.Blue)
        circlePaint.strokeWidth = UIUtils.dip2px(0.5f).toFloat()

        scanPaint.style = Paint.Style.FILL_AND_STROKE
        scanPaint.isAntiAlias = true

        scanRunnable = Runnable {
            //以当前(mWidth/2,mWidth/2)的点进行旋转变换，速率为5,postRotate相当于 M^ = S * M 而postRotate相当于M^ = M * S,而setRotate直接设值,覆盖原来的值，可能会导致之前操作失效
            matrixRadar.postRotate(speed, mWidth / 2, mWidth / 2)
            invalidate()
            postDelayed(scanRunnable, INTERVAL)
        }
        post(scanRunnable)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val tempWidth = measuredWidth - paddingLeft - paddingRight - UIUtils.dip2px(0.5f).toFloat()
        val tempHeight = measuredHeight - paddingBottom - paddingTop - UIUtils.dip2px(0.5f).toFloat()
        mWidth = Math.min(tempWidth, tempHeight)

        //因为onMeasure方法会走两次，避免重复初始化
        if (scanShader == null) {
            //SweepGradient 扫范围渐变
            scanShader = SweepGradient(mWidth / 2, mWidth / 2, intArrayOf(Color.TRANSPARENT, Color.parseColor("#84B5CA")), null)
            scanPaint.shader = scanShader
        }
    }

    override fun onDraw(canvas: Canvas) {
        for (i in 0 until circleValus.size) {
            canvas.drawCircle(mWidth / 2, mWidth / 2, circleValus[i] * mWidth / 2, circlePaint)
        }
        //使用全局变量matrixRadar，不要写错为kotlin自带的matrix
        canvas.concat(matrixRadar)
        //画圆阴影
        canvas.drawCircle(mWidth / 2, mWidth / 2, circleValus[circleValus.size - 1] * mWidth / 2, scanPaint)
    }

}