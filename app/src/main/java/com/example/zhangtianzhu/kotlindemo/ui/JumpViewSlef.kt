package com.example.zhangtianzhu.kotlindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.example.zhangtianzhu.kotlindemo.R
import kotlinx.android.synthetic.main.activity_jump_view_slef.*

class JumpViewSlef : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jump_view_slef)
        jump()
    }

    private fun jump(){
        btn_flow.setOnClickListener(onClickListener)
        btn_shader.setOnClickListener(onClickListener)
        btn_xfermodel.setOnClickListener(onClickListener)
        btn_animation.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        //在不同的模块下，路由跳转得使用不同的一级目录
        when(it.id){
            R.id.btn_flow ->{
                ARouter.getInstance().build("/com/viewSelf").navigation()
            }
            R.id.btn_shader ->{
                ARouter.getInstance().build("/com/shader").navigation()
            }
            R.id.btn_xfermodel ->{
                ARouter.getInstance().build("/xfer/model").navigation()
            }
            R.id.btn_animation ->{
                ARouter.getInstance().build("/animation/model").navigation()
            }
        }
    }
}
