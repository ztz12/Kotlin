package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.*
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

class RunningLinearGradientView(context: Context, attributeSet: AttributeSet) : AppCompatTextView(context, attributeSet) {
    private val matrixShader = Matrix()
    //获取TextPaint使用getPaint方法
    private val textPaint = paint
    private val DELAY = 20f//偏移量
    private lateinit var linearGradient: LinearGradient
    private var transition = 0f

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val text = text.toString()
        //获取文字总宽度
        val textWidth = textPaint.measureText(text)
        val fontMetrics = Paint.FontMetrics()
        //获取文字总高度
        val textHeight = fontMetrics.bottom - fontMetrics.top

        //获取单个文字高度
        val textRowHeight = textPaint.textSize

        val gradient = textWidth / 20
        //编译开始横坐标
        linearGradient = LinearGradient(
                -gradient,
                textRowHeight,
                0f,
                textRowHeight,
                intArrayOf(0x22ffffff, Color.WHITE, 0x22ffffff),
                null,
                Shader.TileMode.CLAMP
        )
        textPaint.shader = linearGradient
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        transition += DELAY
        val textWidth = paint.measureText(text.toString())
        if (transition > textWidth) {
            //重新开始流动渐变
            matrixShader.setTranslate(-transition, 0f)
            transition = 0f
        }
        matrixShader.setTranslate(transition, 0f)
        linearGradient.setLocalMatrix(matrixShader)
        postInvalidateDelayed(50)
    }
}