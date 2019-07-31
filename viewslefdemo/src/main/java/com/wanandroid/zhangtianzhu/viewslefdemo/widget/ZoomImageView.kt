package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R

/**
 * 放大图片
 */
class ZoomImageView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    //放大镜大小半径
    private val RADIUS = 100

    private val zoomMatrix = Matrix()

    private val ZOOM = 2

    private lateinit var shapeDrawable: ShapeDrawable

    //原始图片
    private lateinit var srcBitmap: Bitmap
    //放大后图片
    private lateinit var zoomBitmap: Bitmap

    init {
        srcBitmap = BitmapFactory.decodeResource(resources, R.drawable.xyjy3)
        zoomBitmap = Bitmap.createScaledBitmap(srcBitmap, srcBitmap.width * ZOOM, srcBitmap.height * ZOOM,
                true)

        // BitmapShader 的作用 https://blog.csdn.net/nangeque/article/details/55682146
        val shader = BitmapShader(zoomBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        // 关于 OvalShape https://blog.csdn.net/zhangphil/article/details/52025152
        // OvalShape 是一个 圆形的 shape
        // RectShape 是一个 方形的 shape
        shapeDrawable = ShapeDrawable(RectShape())
        shapeDrawable.paint.shader = shader
        //绘制drawable的内置矩形区域
        shapeDrawable.setBounds(0, 0, RADIUS * 2, RADIUS * 2)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //画原图
        canvas.drawBitmap(srcBitmap, 0f, 0f, null)

        //画放大后的图
        shapeDrawable.draw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //获取手指在图片内部的点击坐标
        val x = event.x
        val y = event.y
        zoomMatrix.setTranslate(-x * ZOOM + RADIUS, -y * ZOOM + RADIUS)
        //矩阵变化重新设置图像放大区域
        shapeDrawable.paint.shader.setLocalMatrix(zoomMatrix)
        //重新设置图像位置区域
        shapeDrawable.setBounds((x - RADIUS).toInt(), (y - RADIUS).toInt(), (x + RADIUS).toInt(), (y + RADIUS).toInt())
        invalidate()
        return true
    }
}