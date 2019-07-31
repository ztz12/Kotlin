package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R

class BitmapShaderView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val mPaint = Paint()
    private var mWidth = 0
    private var mRadius = 0f
    private var type = 0//纹理图片变换操作
    private val mBitmap: Bitmap
    private val matrixShader = Matrix()
    private var mBitmapClamp:BitmapShader
    private var mRectF: RectF? = null

    init {
        mPaint.isAntiAlias = true
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.xyjy2)
        mBitmapClamp = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = Math.min(measuredWidth, measuredHeight)
        val mBitMapWidth = Math.min(mBitmap.width, mBitmap.height)
        mRadius = mWidth / 2.0f
        //设置合适的缩放比，让图片显示在mWidth宽度的区域内
        val scale = mWidth / mBitMapWidth.toFloat()
        matrixShader.setScale(scale, scale)
        mBitmapClamp.setLocalMatrix(matrixShader)
        mPaint.shader = mBitmapClamp
        if (mRectF == null) {
            mRectF = RectF(0f, 0f, mWidth.toFloat(), mWidth.toFloat())
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        when (type) {
            0 -> canvas.drawRect(0f, 0f, mWidth.toFloat(), mWidth.toFloat(), mPaint)
            1 -> canvas.drawRoundRect(mRectF, 30f, 30f, mPaint)
            else -> canvas.drawCircle(mRadius,mRadius, mRadius, mPaint)
        }
    }

    fun setType(type: Int) {
        this.type = type
        invalidate()
    }
}