package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R

/**
 * BitmapShader 着色器使用，设置不同的渲染效果，使用图片来作为纹理使用,可以实现圆角与圆角图片
 */
class TileModelView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val mPaint = Paint()
    private var mBitmapClampShader: BitmapShader
    private var mBitmapMirrorShader: BitmapShader
    private var mBitmapRepeatShader: BitmapShader
    private var mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.xyjy2)
    private val matrixShader: Matrix = Matrix()

    init {
        //作为纹理的图片，x轴绘制效果，y轴绘制效果
        mBitmapClampShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mBitmapMirrorShader = BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR)
        mBitmapRepeatShader = BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)

        val width = mBitmap.width
        val height = mBitmap.height

        mPaint.shader = mBitmapMirrorShader
        mPaint.isAntiAlias = true

        val scale = Math.max(width, height) / Math.min(width, height).toFloat()
        matrixShader.setScale(scale, scale)
        mBitmapClampShader.setLocalMatrix(matrixShader)
        mBitmapMirrorShader.setLocalMatrix(matrixShader)
        mBitmapRepeatShader.setLocalMatrix(matrixShader)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //将图片作为纹理绘制在矩形区域内
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
    }

    fun setModel(model: Int) {
        when (model) {
            0 -> mPaint.shader = mBitmapClampShader
            1 -> mPaint.shader = mBitmapMirrorShader
            2 -> mPaint.shader = mBitmapRepeatShader
        }
        invalidate()
    }
}