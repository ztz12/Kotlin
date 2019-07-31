package com.example.zhangtianzhu.kotlindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.DatePicker
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.utils.ToastUtils
import com.example.zhangtianzhu.kotlindemo.utils.customdatepicker.MyDatePickerDialog
import kotlinx.android.synthetic.main.activity_date_picker.*
import java.util.*

class DatePickerActivity : AppCompatActivity() {
    private var year = 0
    private var month = 0
    private var day = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_picker)
        show_datePicker_one.setOnClickListener {
            showOneDatePicker()
        }
        show_datePicker_two.setOnClickListener {
            showTwoDatePicker()
        }
        getTime()
    }

    private fun getTime() {
        val now = Calendar.getInstance()
        year = now.get(Calendar.YEAR)
        month = now.get(Calendar.MONTH)
        day = now.get(Calendar.DAY_OF_MONTH)
    }

    private fun showOneDatePicker() {
        val myDatePickerDialog = MyDatePickerDialog(this, R.drawable.date_picker_drawable, "开始时间", year, month, day, onDateSetListenerOne)
        val display = windowManager.defaultDisplay
        val lp: WindowManager.LayoutParams = myDatePickerDialog.window.attributes
        lp.width = (display.width * 0.36).toInt()
        lp.height = (display.height * 0.64).toInt()
        lp.gravity = Gravity.START or Gravity.BOTTOM
        lp.x = show_datePicker_one.left
        lp.y = show_datePicker_one.top + show_datePicker_one.height * 5 / 4
        myDatePickerDialog.window.attributes = lp
        myDatePickerDialog.showDatePicker()
        myDatePickerDialog.setBottomClickListener(object : MyDatePickerDialog.OnBottomClickListener {
            override fun onCancel() {
                myDatePickerDialog.cancel()
            }

            override fun onSure() {
                myDatePickerDialog.dateSet()
            }

        })
    }

    private fun showTwoDatePicker() {
        val myDatePickerDialog = MyDatePickerDialog(this, R.drawable.date_picker_drawable, "结束时间", year, month, day, onDateSetListenerTwo)
        val display = windowManager.defaultDisplay
        val lp: WindowManager.LayoutParams = myDatePickerDialog.window.attributes
        lp.width = (display.width * 0.36).toInt()
        lp.height = (display.height * 0.64).toInt()
        lp.gravity = Gravity.END or Gravity.BOTTOM
        lp.x = display.width - show_datePicker_two.right
        lp.y = show_datePicker_two.top + show_datePicker_two.height * 5 / 4
        myDatePickerDialog.window.attributes = lp
        myDatePickerDialog.showDatePicker()
        myDatePickerDialog.setBottomClickListener(object : MyDatePickerDialog.OnBottomClickListener {
            override fun onCancel() {
                myDatePickerDialog.cancel()
            }

            override fun onSure() {
                myDatePickerDialog.dateSet()
            }

        })
    }

    private val onDateSetListenerOne = object : MyDatePickerDialog.OnSetDateListener {
        override fun onDateSet(dataPicker: DatePicker, year: Int, month: Int, day: Int) {
            val monthT = month + 1
            ToastUtils.showToast("$year-$monthT-$day")
            tv_date_one.text = "$year-$monthT-$day"
        }
    }

    private val onDateSetListenerTwo = object : MyDatePickerDialog.OnSetDateListener {
        override fun onDateSet(dataPicker: DatePicker, year: Int, month: Int, day: Int) {
            val monthT = month + 1
            ToastUtils.showToast("$year-$monthT-$day")
            tv_date_two.text = "$year-$monthT-$day"
        }
    }
}
