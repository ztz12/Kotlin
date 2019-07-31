package com.example.zhangtianzhu.kotlindemo.paging

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.bean.Student

class StudentViewHolder(parent:ViewGroup):RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)) {
    private val name = itemView.findViewById<TextView>(R.id.name)

    private var student:Student?=null

    fun bindStudent(student: Student?){
        this.student = student
        name.text = student?.name
    }
}