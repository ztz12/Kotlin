package com.example.zhangtianzhu.kotlindemo.paging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup
import com.example.zhangtianzhu.kotlindemo.bean.Student

class StudentAdapter:PagedListAdapter<Student,StudentViewHolder>(itemCallback) {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): StudentViewHolder = StudentViewHolder(p0)

    override fun onBindViewHolder(p0: StudentViewHolder, p1: Int) {
        p0.bindStudent(getItem(p1))
    }

    companion object {
        private val itemCallback = object :DiffUtil.ItemCallback<Student>(){
            //如果是同一个item，那判断内容是否相同
            override fun areContentsTheSame(oldItem: Student, newItem: Student): Boolean = oldItem == newItem

            //通过id 判断是否是同一个item
            override fun areItemsTheSame(oldItem: Student, newItem: Student): Boolean = oldItem.id == newItem.id
        }
    }
}