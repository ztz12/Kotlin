package com.wanandroid.zhangtianzhu.viewslefdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R
import kotlinx.android.synthetic.main.activity_gradient.*

class GradientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gradient)
        changeHeart()
    }

    private fun changeHeart(){
        btn_linear.setOnClickListener(onClickListener)
        btn_radial.setOnClickListener(onClickListener)
        btn_sweep.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when(it.id){
            R.id.btn_linear -> gradient.setModel(0)
            R.id.btn_radial -> gradient.setModel(1)
            R.id.btn_sweep -> gradient.setModel(2)
        }
    }
}
