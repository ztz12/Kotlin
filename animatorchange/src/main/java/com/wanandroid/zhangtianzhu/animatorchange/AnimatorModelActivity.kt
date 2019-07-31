package com.wanandroid.zhangtianzhu.animatorchange

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.wanandroid.zhangtianzhu.animatorchange.activity.DialActivity
import com.wanandroid.zhangtianzhu.animatorchange.activity.ShoppingActivity
import kotlinx.android.synthetic.main.activity_animator_model.*
import org.jetbrains.anko.startActivity

@Route(path = "/animation/model")
class AnimatorModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_model)
        jump()
    }

    private fun jump(){
        btn_buy.setOnClickListener(onClickListener)
        btnDial.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener {
        when(it.id){
            R.id.btn_buy -> startActivity<ShoppingActivity>()
            R.id.btnDial -> startActivity<DialActivity>()
        }
    }
}
