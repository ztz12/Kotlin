package com.example.zhangtianzhu.kotlindemo.students.fragment

import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.students.activity.IntensiveReadActivity
import com.example.zhangtianzhu.kotlindemo.students.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_reading.*
import org.jetbrains.anko.support.v4.startActivity

class ReadingFragment :BaseFragment(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_reading
    }

    override fun initData() {
        practice_detail.setOnClickListener {
            startActivity<IntensiveReadActivity>()
        }
    }

    override fun initViews() {
    }
}