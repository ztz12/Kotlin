package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R

class GradientView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val colors = intArrayOf(Color.BLUE, Color.YELLOW, Color.GREEN, Color.RED)
    private val mPaint = Paint()
    private var mWidth = 0
    private var mHeight = 0

    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.heart)
    private val mBitmapShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    private var curShader: Shader

    //组合渲染
    private var linearShader: ComposeShader
    private var radialShader: ComposeShader
    private var sweepShader: ComposeShader

    init {
        mPaint.isAntiAlias = true
        mWidth = mBitmap.width
        mHeight = mBitmap.height
        val linearGradient = LinearGradient(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), colors, null, Shader.TileMode.CLAMP)
        //径向渐变
        val radialGradient = RadialGradient(mWidth / 2.toFloat(), mHeight / 2.toFloat(), 100f, colors, null, Shader.TileMode.CLAMP)
        val sweepGradient = SweepGradient(mWidth / 2.toFloat(), mHeight / 2.toFloat(), colors, null)

        //MULTIPLY 将两种效果进行叠加展示
        linearShader = ComposeShader(mBitmapShader, linearGradient, PorterDuff.Mode.MULTIPLY)
        radialShader = ComposeShader(mBitmapShader, radialGradient, PorterDuff.Mode.MULTIPLY)
        sweepShader = ComposeShader(mBitmapShader, sweepGradient, PorterDuff.Mode.MULTIPLY)

        mPaint.isAntiAlias = true
        curShader = linearShader

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.shader = curShader
        canvas.drawRect(0f, 0f, mWidth.toFloat(), mHeight.toFloat(), mPaint)
    }

    fun setModel(model: Int) {
        when (model) {
            0 -> curShader = linearShader
            1 -> curShader = radialShader
            2 -> curShader = sweepShader
        }
        //调用invalidate刷新只会重走draw,onDraw方法，只有重写requestLayout才会重新绘制整个view,从measure，onMeasure开始
        invalidate()
    }
}