package com.example.zhangtianzhu.kotlindemo.adapter

interface ItemToucherAdapter {
    //数据交换
    fun ItemMove(firstPosition:Int,toPosition:Int)
    //数据删除
    fun ItemDissmiss(firstPosition:Int)
}