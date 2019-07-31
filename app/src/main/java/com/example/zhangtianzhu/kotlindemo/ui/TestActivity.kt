package com.example.zhangtianzhu.kotlindemo.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.test.*
import com.example.zhangtianzhu.kotlindemo.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_test.*
import org.jetbrains.anko.startActivity

class TestActivity : AppCompatActivity() {

    private val tag = TestActivity::class.java.name
    private  var handler: Handler? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        test()
        click.setOnClickListener(onClickListener)
    }

    private fun test(){
        val thread = object :Thread(){
            override fun run() {
                Looper.prepare()
                handler = @SuppressLint("HandlerLeak")
                object : Handler(){
                    override fun handleMessage(msg: Message) {
                        when(msg.what){
                            1 -> ToastUtils.showToastOnUi("flutter")
                        }
                    }
                }
                Looper.loop()
            }
        }
        thread.start()
    }

    private fun testSeal(exer:Exer):Double = when(exer){
        is Const -> exer.number
        is Sum -> exer.expOne + exer.expTwo
        //NaN 表示非数字
        is NoNumber -> Double.NaN
    }

    private val onClickListener = View.OnClickListener {
        when (it.id) {
            R.id.click -> {
//                startActivity<AnimatorActivityTwo>()
//                val swapIndex = mutableListOf(2, 3, 1)
//                swapIndex.swap(0, 1)
//                swapIndex.forEach {
//                    Log.i(tag, it.toString())
//                }
                sendMsg()
            }
        }
    }

    @Throws(Exception::class)
    private fun sendMsg(){
        val thread = object : Thread(){
            override fun run() {
                Thread.sleep(1000)
                handler?.sendEmptyMessage(1)
            }
        }
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacks(null)
    }
}
