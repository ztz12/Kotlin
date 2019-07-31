package com.example.zhangtianzhu.kotlindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.utils.datepicker.CustomDatePicker
import com.example.zhangtianzhu.kotlindemo.utils.datepicker.DateFormatUtils
import kotlinx.android.synthetic.main.activity_calendar.*

class CalendarActivity : AppCompatActivity() {

    private var mDatePicker:CustomDatePicker? = null
    private var mTimerPicker:CustomDatePicker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
        initDatePicker()
        initTimePicker()
        tv_date.setOnClickListener {
            mDatePicker?.show(tv_date.text.toString())
        }

        tv_time.setOnClickListener {
            mTimerPicker?.show(tv_time.text.toString())
        }
    }

    fun initDatePicker(){
        val beginTime = DateFormatUtils.str2Long("1999-01-01",false)
        val endTime = System.currentTimeMillis()
        tv_date.text = DateFormatUtils.long2Str(endTime,false)
        mDatePicker = CustomDatePicker(this, CustomDatePicker.Callback {
            timestamp -> tv_date.text = DateFormatUtils.long2Str(timestamp, false)
        }, beginTime, endTime)
        // 不允许点击屏幕或物理返回键关闭
        mDatePicker!!.setCancelable(true)
        // 不显示时和分
        mDatePicker!!.setCanShowPreciseTime(false)
        // 不允许循环滚动
        mDatePicker!!.setScrollLoop(false)
        // 不允许滚动动画
        mDatePicker!!.setCanShowAnim(false)
    }

    fun initTimePicker(){
        val beginTime = "2000-01-01 18:00"
        val endTime = DateFormatUtils.long2Str(System.currentTimeMillis(), true)

        tv_time.text = endTime

        // 通过日期字符串初始化日期，格式请用：yyyy-MM-dd HH:mm
        mTimerPicker = CustomDatePicker(this, CustomDatePicker.Callback {
            timestamp -> tv_time.text = DateFormatUtils.long2Str(timestamp, true)
        }, beginTime, endTime)
        // 允许点击屏幕或物理返回键关闭
        mTimerPicker!!.setCancelable(true)
        // 显示时和分
        mTimerPicker!!.setCanShowPreciseTime(false)
        // 允许循环滚动
        mTimerPicker!!.setScrollLoop(false)
        // 允许滚动动画
        mTimerPicker!!.setCanShowAnim(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDatePicker?.onDestroy()
    }
}
