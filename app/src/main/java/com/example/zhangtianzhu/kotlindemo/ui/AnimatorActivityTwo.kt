package com.example.zhangtianzhu.kotlindemo.ui

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.zhangtianzhu.kotlindemo.R
import kotlinx.android.synthetic.main.activity_animator_two.*
import org.jetbrains.anko.startActivity

class AnimatorActivityTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator_two)
        btn_animator_two.setOnClickListener {
            val intent = Intent(this,AnimatorActivity::class.java)
            intent.putExtra("info","hello")
            setResult(Activity.RESULT_OK,intent)
            finish()
//            startActivity<TestActivity>()
        }
    }

    /**
     * 在onPause中，setResult方法无法执行
     */
    override fun onPause() {
        super.onPause()
    }

    /**
     * 在onBackPress方法中调用setResult方法该方法必须在super.onBackPress之前调用或者，在点击事件中调用setResult方法再finish该界面
     */
    override fun onBackPressed() {
        val intent = Intent(this,AnimatorActivity::class.java)
        intent.putExtra("info","hello")
        setResult(Activity.RESULT_OK,intent)
        super.onBackPressed()
    }
}
