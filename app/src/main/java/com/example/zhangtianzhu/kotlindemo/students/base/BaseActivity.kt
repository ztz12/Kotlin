package com.example.zhangtianzhu.kotlindemo.students.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init()
    }

    private fun init(){
        initView()
        initData()
    }
    protected abstract fun getLayoutId() :Int

    protected abstract fun initData()

    protected abstract fun initView()

}