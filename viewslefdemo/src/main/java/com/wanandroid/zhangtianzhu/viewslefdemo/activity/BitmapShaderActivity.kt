package com.wanandroid.zhangtianzhu.viewslefdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R
import kotlinx.android.synthetic.main.activity_bitmap_shader.*

class BitmapShaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap_shader)
        bitmapShader.setType(2)
        changePic()
    }

    private fun changePic(){
        btn_circle.setOnClickListener(onClickListener)
        btn_rect.setOnClickListener(onClickListener)
        btn_radius.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when(it.id){
            R.id.btn_circle -> bitmapShader.setType(2)
            R.id.btn_radius -> bitmapShader.setType(1)
            R.id.btn_rect ->bitmapShader.setType(0)
        }
    }
}
