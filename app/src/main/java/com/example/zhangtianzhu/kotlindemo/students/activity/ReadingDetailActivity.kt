package com.example.zhangtianzhu.kotlindemo.students.activity

import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.students.base.BaseActivity
import com.example.zhangtianzhu.kotlindemo.students.fragment.ReadingFragment

class ReadingDetailActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_reading_detail
    }

    override fun initData() {
        val transition = supportFragmentManager.beginTransaction()
        val fragment = ReadingFragment()
        transition.replace(R.id.fl_reading,fragment).commit()
    }

    override fun initView() {
    }


}
