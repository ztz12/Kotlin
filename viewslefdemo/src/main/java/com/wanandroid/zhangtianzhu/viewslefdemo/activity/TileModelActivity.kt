package com.wanandroid.zhangtianzhu.viewslefdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wanandroid.zhangtianzhu.viewslefdemo.R
import kotlinx.android.synthetic.main.activity_tile_model.*

class TileModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tile_model)
        changeTileModel()
    }

    private fun changeTileModel() {
        btn_clamp.setOnClickListener(onClickListener)
        btn_mirror.setOnClickListener(onClickListener)
        btn_repeat.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.btn_clamp -> tileModel.setModel(0)
            R.id.btn_mirror -> tileModel.setModel(1)
            R.id.btn_repeat -> tileModel.setModel(2)
        }
    }
}
