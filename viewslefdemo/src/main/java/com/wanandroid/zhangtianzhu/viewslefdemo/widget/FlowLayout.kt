package com.wanandroid.zhangtianzhu.viewslefdemo.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class FlowLayout(context: Context, attributeSet: AttributeSet) : ViewGroup(context, attributeSet) {
    //每行中的view
    private val mRowViews: MutableList<MutableList<View>> = ArrayList()
    //每行中view的高度
    private val mRowHeightList: MutableList<Int> = ArrayList()
    //当前行的view
    private var mCurLineView: MutableList<View> = ArrayList()

    /**
     * 子视图需要其margin,必须重写该方法
     */
    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //会执行两次onMeasure方法，所以先清空列表
        mRowHeightList.clear()
        mRowViews.clear()
        mCurLineView.clear()
        val widthModel = MeasureSpec.getMode(widthMeasureSpec)
        val heightModel = MeasureSpec.getMode(heightMeasureSpec)
        val widthSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        //FlowLayout的自身宽高，确定自身大小
        var flowWidth = 0
        var flowHeight = 0
        //每行的宽高
        var lineWidth = 0
        var lineHeight = 0

        for (i in 0 until childCount) {
            //获取每个子view
            val childView = getChildAt(i)
            //子视图自身进行测量
            measureChildWithMargins(childView, widthMeasureSpec, 0, heightMeasureSpec, 0)
            //获取子视图宽高
            val childHeight = childView.measuredHeight
            val childWidth = childView.measuredWidth

            //获取子视图真正占的大小
            //这里必须重写viewgroup的generateLayoutParams并返回MarginLayoutParams
            val params: MarginLayoutParams = childView.layoutParams as MarginLayoutParams
            val childRealWidth = childWidth + params.rightMargin + params.leftMargin
            val childRealHeight = childHeight + params.topMargin + params.bottomMargin

            //当前子视图的行宽和超过父布局宽度，重新设置父布局宽度
            if (lineWidth + childRealWidth > widthSize) {
                //获取最大值
                flowWidth = Math.max(flowWidth, lineWidth)
                flowHeight += lineHeight
                //保存行view数据
                mRowViews.add(mCurLineView)

                //保存行高
                mRowHeightList.add(lineHeight)

                //重新开启一个新的集合，保存新view
                mCurLineView = ArrayList()
                mCurLineView.add(childView)

                //重置行宽高
                lineWidth = childRealWidth
                lineHeight = childRealHeight
            } else {
                //不超过添加行view
                mCurLineView.add(childView)
                lineWidth += childRealWidth
                lineHeight = Math.max(lineHeight, childRealHeight)
            }

            //保存最后一行数据
            if (i == childCount - 1) {
                flowWidth = Math.max(flowWidth, lineWidth)
                flowHeight += lineHeight
                mRowViews.add(mCurLineView)
                mRowHeightList.add(flowHeight)
            }
        }

        //如果是match_parent就直接使用宽高尺寸
        if (widthModel == MeasureSpec.EXACTLY) {
            flowWidth = widthSize
        }

        if (heightModel == MeasureSpec.EXACTLY) {
            flowHeight = heightSize
        }
        setMeasuredDimension(flowWidth, flowHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var left = 0
        var top = 0
        var bottom = 0
        var right = 0

        var curLeft = 0
        var curTop = 0
        val lineSize = mRowViews.size
        //遍历每行view
        for (i in 0 until lineSize) {
            val lineView: MutableList<View> = mRowViews[i]
            //遍历每列view
            for (j in 0 until lineView.size) {
                val view = lineView[j]
                val params: MarginLayoutParams = view.layoutParams as MarginLayoutParams
                left = curLeft + params.leftMargin
                top = curTop + params.topMargin
                right = left + view.measuredWidth
                bottom = top + view.measuredHeight
                view.layout(left, top, right, bottom)

                curLeft += view.measuredWidth + params.leftMargin + params.rightMargin
            }
            //重置
            curLeft = 0
            //高度递增
            curTop += mRowHeightList[i]
        }

        //onLayout也会执行两次，所以清空
        mRowViews.clear()
        mRowHeightList.clear()
    }

}