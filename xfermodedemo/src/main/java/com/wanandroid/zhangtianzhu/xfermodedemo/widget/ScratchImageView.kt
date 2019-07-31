package com.wanandroid.zhangtianzhu.xfermodedemo.widget

import android.content.Context
import android.graphics.*
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.MotionEvent
import com.wanandroid.zhangtianzhu.xfermodedemo.R

class ScratchImageView(context: Context, attributeSet: AttributeSet) : AppCompatImageView(context, attributeSet) {
    //是否第一次测量
    private var isInit = false
    //是否展示完整图片
    private var isShowAll = false
    private var mXferModel: PorterDuffXfermode
    private lateinit var mBitmap: Bitmap
    private var mPreX = 0f
    private var mPreY = 0f
    private val mPaint = Paint()
    private val mPath = Path()
    private lateinit var mCanvas: Canvas

    private val PERCENT = 0.2f

    init {
        mPaint.run {
            isAntiAlias = true
            color = resources.getColor(R.color.Light_Green)
            style = Paint.Style.STROKE
            strokeWidth = dip2px(context, 10f)
            strokeJoin = Paint.Join.ROUND//设置圆角
            mXferModel = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        }
    }

    private fun createBitmap(w: Int, h: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.run {
            isAntiAlias = true
            color = resources.getColor(R.color.Light_Green)
        }
        canvas.drawRect(0f, 0f, w.toFloat(), h.toFloat(), paint)
        return bitmap
    }

    private val mRunnable = Runnable {
        val pixels = IntArray(width * height)
        val totalPixel: Float = (width * height).toFloat()
        //从指定的偏移位置，指定原图位置x y坐标开始的像素，并截取指定宽高之间的所得的每个像素颜色转换成int值存入到数组中
        //stride 指定的在行之间跳过的像素数目，就是指定多少个像素换一行
        mBitmap.getPixels(pixels, 0, width, 0, 0, width, height)

        var currentPixel = 0
        for (column in 0 until height) {
            for (row in 0 until width) {
                if (pixels[column * width + row] == 0) {
                    currentPixel++
                }
            }
        }
        //
        val result = currentPixel / totalPixel
        if (result >= PERCENT) {
            isShowAll = true
            postInvalidate()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (!isInit) {
            mBitmap = createBitmap(measuredWidth, measuredHeight)
            mCanvas = Canvas(mBitmap)
            isInit = true
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (isShowAll) {
            return
        }
        val layer = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(mBitmap, 0f, 0f, mPaint)
        mPaint.xfermode = mXferModel
        canvas.drawPath(mPath, mPaint)
        mCanvas.drawPath(mPath, mPaint)
        //去除画笔的混合模式
        mPaint.xfermode = null
        canvas.restoreToCount(layer)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mPreX = event.x
                mPreY = event.y
                mPath.moveTo(mPreX, mPreY)
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (mPreX + event.x) / 2
                val endY = (mPreY + event.y) / 2
                mPath.quadTo(mPreX, mPreY, endX, endY)
                mPreX = endX
                mPreY = endY
            }
            MotionEvent.ACTION_UP -> {
                post(mRunnable)
            }
        }
        postInvalidate()
        return true
    }

    private fun dip2px(context: Context, dipValue: Float): Float {
        val density = context.resources.displayMetrics.density
        return dipValue * density + 0.5f
    }

}