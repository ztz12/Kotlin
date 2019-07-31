package com.example.zhangtianzhu.kotlindemo.students.activity

import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.students.base.BaseActivity
import kotlinx.android.synthetic.main.activity_reading.*
import org.jetbrains.anko.startActivity

class ReadingActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_reading
    }

    override fun initData() {
    }

    override fun initView() {
        practice.setOnClickListener {
            startActivity<ReadingDetailActivity>()
        }
    }

}
