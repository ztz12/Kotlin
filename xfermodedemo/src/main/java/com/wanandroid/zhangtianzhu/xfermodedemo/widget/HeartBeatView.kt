package com.wanandroid.zhangtianzhu.xfermodedemo.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.wanandroid.zhangtianzhu.xfermodedemo.R

/**
 * 心跳绘制
 */
class HeartBeatView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    private var mHearBeatBitmap: Bitmap
    private var mSrcBitmap: Bitmap
    private val mPaint = Paint()
    private var mItemWidth = 0
    private var dx = 0f
    private var xfermode: Xfermode
    private var mSrcCanvas: Canvas

    init {
        mPaint.color = Color.RED
        val opt = BitmapFactory.Options()
        opt.inSampleSize = 2
        mHearBeatBitmap = BitmapFactory.decodeResource(resources, R.drawable.ping_pong, opt)
        mSrcBitmap = Bitmap.createBitmap(mHearBeatBitmap.width, mHearBeatBitmap.height, Bitmap.Config.ARGB_8888)
        xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        mSrcCanvas = Canvas(mSrcBitmap)
        mItemWidth = mHearBeatBitmap.width
        start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //清空画布，重复绘制
        mSrcCanvas.drawColor(Color.RED, PorterDuff.Mode.CLEAR)
        mSrcCanvas.drawRect(mHearBeatBitmap.width - dx,
                0f,
                mHearBeatBitmap.width.toFloat(),
                mHearBeatBitmap.height.toFloat(), mPaint)

        val layer = canvas.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(mHearBeatBitmap, 0f, 0f, mPaint)
        mPaint.xfermode = xfermode
        canvas.drawBitmap(mSrcBitmap, 0f, 0f, mPaint)
        mPaint.xfermode = null
        canvas.restoreToCount(layer)
    }

    private fun BitmapToDrawable(drawable: Drawable): Bitmap {
        val w = drawable.intrinsicWidth
        val h = drawable.intrinsicHeight
        val config: Bitmap.Config = if (drawable.opacity != PixelFormat.OPAQUE) Bitmap.Config.ARGB_8888 else Bitmap.Config.RGB_565
        val bitmap = Bitmap.createBitmap(w, h, config)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, w, h)
        drawable.draw(canvas)
        return bitmap
    }

    private fun start() {
        val animator = ValueAnimator.ofFloat(0f, mItemWidth.toFloat())
        animator.duration = 4500
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener { animator ->
            dx = animator.animatedValue as Float
            invalidate()
        }
        animator.start()
    }
}