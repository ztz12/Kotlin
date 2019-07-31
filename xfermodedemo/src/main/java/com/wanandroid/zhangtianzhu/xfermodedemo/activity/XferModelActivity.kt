package com.wanandroid.zhangtianzhu.xfermodedemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.wanandroid.zhangtianzhu.xfermodedemo.R
import kotlinx.android.synthetic.main.activity_xfer_model.*
import org.jetbrains.anko.startActivity

@Route(path = "/xfer/model")
class XferModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xfer_model)
        jump()
    }

    private fun jump() {
        btn_google.setOnClickListener(onClickListener)
        btn_scratch.setOnClickListener(onClickListener)
        btn_heartBeat.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.btn_google -> {
                startActivity<GoogleXferActivity>()
            }
            R.id.btn_scratch -> {
                startActivity<ScratchActivity>()
            }
            R.id.btn_heartBeat -> {
                startActivity<HeartBeatActivity>()
            }
        }
    }
}
