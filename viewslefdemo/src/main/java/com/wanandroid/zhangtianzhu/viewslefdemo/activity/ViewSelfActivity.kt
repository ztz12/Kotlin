package com.wanandroid.zhangtianzhu.viewslefdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.wanandroid.zhangtianzhu.viewslefdemo.R
import kotlinx.android.synthetic.main.activity_view_self.*
import java.util.*

@Route(path = "/com/viewSelf")
class ViewSelfActivity : AppCompatActivity() {

    private val INFO = ArrayList<String>()

    private var mDataCount = 10

    private val mRandom = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_self)
        init()
        btn_change.setOnClickListener {
            createData()
        }

        sb_data_count.progress = mDataCount / 2
        tv_data_count.text = String.format("数据量 $mDataCount")
        sb_data_count.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                mDataCount = progress * 2
                tv_data_count.text = String.format("数据量 $mDataCount")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }

    private fun createData() {
        flowLayout.removeAllViews()
        for (i in 0 until mDataCount) {
            val index = mRandom.nextInt(INFO.size)
            //使用局部变量保存当前内容
            val itemContent = INFO[index]
            val tv: TextView = layoutInflater.inflate(R.layout.item_single_tag, flowLayout, false) as TextView
            tv.text = itemContent
            tv.setOnClickListener {
                Toast.makeText(this, "text: $itemContent", Toast.LENGTH_SHORT).show()
            }
            flowLayout.addView(tv)
        }
        flowLayout.invalidate()
    }

    private fun init() {
        INFO.add("Hello World!")
        INFO.add("猛猛的小盆友")
        INFO.add("掘")
        INFO.add("金金金")
        INFO.add("PHP是最好的语言")
        INFO.add("大Android")
        INFO.add("IOS")
        INFO.add("JAVA")
        INFO.add("Python")
        INFO.add("这是一个很长很长很长很长很长很长很长很长超级无敌长的句子")
    }
}
