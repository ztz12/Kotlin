package com.example.zhangtianzhu.kotlindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.StringRes
import android.support.annotation.UiThread
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_annotation.*
import org.jetbrains.anko.doAsync

/**
 *Android 通过一些注解Annotation来提示开发者代码编写是否恰当，但对于那些不懂注解方法的开发者，会造成误解
 */
class AnnotationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_annotation)
        btn.setOnClickListener {
            showInfo("Hi My New Year")
        }
//        stringRes(R.mipmap.arrow_up)
    }

    private fun showInfo(@NonNull msg:String){
        ToastUtils.showToastOnUi(msg)
    }
    //@StringRes 表示返回值应该是一个字符串类型的资源，@ColorInt 表示当前值应该是颜色类型的值类似ARGB,而不是颜色类型的资源，而
    //@ColorRes 是表示颜色类型的资源
    private fun stringRes(@StringRes id:Int){

    }

    //使用该注解表示需要运行在UI线程
    @UiThread
    private fun setText(){
        btn.text = "111"
    }
}
