package com.wanandroid.zhangtianzhu.viewslefdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.wanandroid.zhangtianzhu.viewslefdemo.R
import kotlinx.android.synthetic.main.activity_client.*
import org.jetbrains.anko.startActivity

@Route(path = "/com/shader")
class ClientActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        jump()
    }

    private fun jump() {
        btn_radar.setOnClickListener(onClickListener)
        btn_mode.setOnClickListener(onClickListener)
        btn_shader.setOnClickListener(onClickListener)
        btn_gradient.setOnClickListener(onClickListener)
        btn_running_text.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.btn_radar -> startActivity<PaintRadarActivity>()
            R.id.btn_mode -> startActivity<TileModelActivity>()
            R.id.btn_shader -> startActivity<BitmapShaderActivity>()
            R.id.btn_gradient -> startActivity<GradientActivity>()
            R.id.btn_running_text -> startActivity<RunningLinearGradientActivity>()
        }
    }
}
