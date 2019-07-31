package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.util.AttributeSet
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R

class MatrixSetPolyToPolyTest(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private val matrixPoly = Matrix()
    private var mBitmap: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.xyjy3)

    init {
        val src = floatArrayOf(0f, 0f,
                mBitmap.width.toFloat(), 0f,
                mBitmap.width.toFloat(), mBitmap.height.toFloat(),
                0f, mBitmap.height.toFloat())
        val dst = floatArrayOf(0f, 0f,
                mBitmap.width.toFloat(), 400f,
                mBitmap.width.toFloat(), mBitmap.height.toFloat() - 200f,
                0f, mBitmap.height.toFloat())

        //shr 有符号右移>> ，shl有符号左移 <<,无符号右移 ushr >>>
        //pointCount参数：0 相当于reset 1为位移,2为缩放、旋转、平移，3为缩放、旋转、平移与错切 ，4为缩放、旋转、平移、错切及任意形变
        matrixPoly.setPolyToPoly(src, 0, dst, 0, 4)
        matrixPoly.postScale(0.5f, 0.5f)
        matrixPoly.postTranslate(0f, 100f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(mBitmap, matrixPoly, null)
    }
}