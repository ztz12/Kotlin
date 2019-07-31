package com.example.zhangtianzhu.kotlindemo.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import com.example.zhangtianzhu.kotlindemo.R

class BaseView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {
    //画坐标系
    private val mPaint: Paint = Paint()
    //画坐标系上的数字
    private val mPaintNum = Paint()
    //画网格
    private val mPaintGrid = Paint()
    //lateinit不允许修饰原始的基本数据类型，比如Int，Double等
    private var mWidth: Int = 0
    private var mHeight: Int = 0
    //竖线之间间隔50px
    private val mDivide = 50
    private val mTextSize = dpToPx(10f)

    init {
        mPaint.color = resources.getColor(R.color.colorPrimaryOverlay)
        mPaint.strokeWidth = 5f
        mPaint.style = Paint.Style.STROKE
        mPaint.isAntiAlias = true
        mPaintNum.run {
            color = resources.getColor(R.color.title_black)
            style = Paint.Style.STROKE
            isAntiAlias = true
            textSize = mTextSize
        }
        mPaintGrid.run {
            color = resources.getColor(R.color.Grey400)
            strokeWidth = 1f
            style = Paint.Style.STROKE
            isAntiAlias = true
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = measuredWidth
        mHeight = measuredHeight
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.translate(mWidth / 2.toFloat(), mHeight / 2.toFloat())
        //快照 ，把当前画布保存，并放入特定的栈中
        canvas.save()
        drawCoordinate(canvas)
        //回滚，把栈中最顶层的画布取出来，然后按照这个恢复画布状态,调用该方法之前必须调用canvas.save方法
        canvas.restore()
        canvas.drawLine(-mWidth / 2.toFloat(), 0f, mWidth / 2.toFloat(), 0f, mPaint)
        canvas.drawLine(0f, mHeight / 2.toFloat(), 0f, -mHeight / 2.toFloat(), mPaint)
    }

    private fun drawCoordinate(canvas: Canvas) {
        var countLength = 0
        //画竖线
        while (countLength <= mWidth / 2) {
            countLength += mDivide
            //画网格
            canvas.drawLine(countLength.toFloat(), mHeight / 2.toFloat(), countLength.toFloat(), -mHeight / 2.toFloat(), mPaintGrid)
            canvas.drawLine(-countLength.toFloat(), mHeight / 2.toFloat(), -countLength.toFloat(), -mHeight / 2.toFloat(), mPaintGrid)
            //画标注
            canvas.drawLine(countLength.toFloat(), 0f, countLength.toFloat(), -10f, mPaintNum)
            canvas.drawLine(-countLength.toFloat(), 0f, -countLength.toFloat(), -10f, mPaintNum)
            if (countLength % (mDivide * 2) == 0) {
                canvas.drawText(countLength.toString(), countLength.toFloat() - 15f, mDivide / 2.toFloat(), mPaintNum)
                canvas.drawText((-countLength).toString(), -countLength.toFloat() - 15f, mDivide / 2.toFloat(), mPaintNum)
            }
        }
        //画横线
        countLength = 0
        while (countLength <= mHeight / 2) {
            countLength += mDivide
            //画网格
            canvas.drawLine(-mWidth / 2.toFloat(), countLength.toFloat(), mWidth / 2.toFloat(), countLength.toFloat(), mPaintGrid)
            canvas.drawLine(-mWidth / 2.toFloat(), -countLength.toFloat(), mWidth / 2.toFloat(), -countLength.toFloat(), mPaintGrid)
            //画标注
            canvas.drawLine(0f, countLength.toFloat(), 10f, countLength.toFloat(), mPaintNum)
            canvas.drawLine(0f, -countLength.toFloat(), 10f, -countLength.toFloat(), mPaintNum)
            if (countLength % (mDivide * 2) == 0) {
                canvas.drawText(countLength.toString(), -mDivide.toFloat(), countLength.toFloat() + 10f, mPaintNum)
                canvas.drawText((-countLength).toString(), -mDivide.toFloat(), -countLength.toFloat() + 10f, mPaintNum)
            }
        }
    }

    /**
     * dp 转 px
     */
    protected fun dpToPx(dp: Float): Float {
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        return dp * metrics.density + 0.5f
    }

    /**
     * sp 转px
     */
    protected fun spToPx(sp: Float): Float {
        val fontScale = Resources.getSystem().displayMetrics.scaledDensity
        return sp * fontScale + 0.5f
    }
}