package com.example.zhangtianzhu.kotlindemo.adapter

import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class SimpleTouchCallback(private val recyclerAdapter: RecyclerAdapter):ItemTouchHelper.Callback() {
    //返回滑动方向
    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        val dragFlags = ItemTouchHelper.UP or  ItemTouchHelper.DOWN//支持上下滑动
        val swipeFlags = ItemTouchHelper.LEFT//只允许从右往左删除
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    //长按item才可以拖动
    override fun isLongPressDragEnabled(): Boolean = true

    //返回true,左右滑动支持删除
    override fun isItemViewSwipeEnabled(): Boolean = true

    //当用户拖动item上下滑动从旧位置移动到新位置调用该方法
    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
        recyclerAdapter.ItemMove(viewHolder!!.adapterPosition,target!!.adapterPosition)
        return true
    }

    //左右滑动item删除时调用该方法，一般滑动达到item的一半时，item会继续滑动删除，否则反向滑动回原来的位置
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        recyclerAdapter.ItemDissmiss(viewHolder!!.adapterPosition)
    }

    //用户操作item，item没有删除，恢复初始化状态会调用该方法
    override fun clearView(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?) {
        super.clearView(recyclerView, viewHolder)
    }

    //自定义item删除交互动画
    override fun onChildDraw(c: Canvas?, recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}