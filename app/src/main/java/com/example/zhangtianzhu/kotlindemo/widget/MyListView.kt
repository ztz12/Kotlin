package com.example.zhangtianzhu.kotlindemo.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

/**
 * 此方法解决scrollView与listView或者两个listview互相嵌套嵌套只显示一行item的问题，但是在使用EditeText作为item，并调用他的addTextChangedListener方法时
 * 方法会被多次调用，添加并保存上一个item内容也无法保存，，所以不能在该情况下使用MyListView
 */
open class MyListView constructor(context: Context,attributeSet: AttributeSet):ListView(context,attributeSet){
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //kotlin中右移 shr 左移shi,无符号右移ushr 相当于java中>>>
        val heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE shr 2,MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, heightSpec)
    }
}