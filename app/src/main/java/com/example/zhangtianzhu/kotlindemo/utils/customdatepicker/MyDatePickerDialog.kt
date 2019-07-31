package com.example.zhangtianzhu.kotlindemo.utils.customdatepicker

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import com.example.zhangtianzhu.kotlindemo.R

class MyDatePickerDialog(context: Context, theme: Int, private val title: String, year: Int, month: Int, day: Int, dateSet: OnSetDateListener) : AlertDialog(context, theme), DatePicker.OnDateChangedListener {
    private val YEAR = "year"
    private val MONTH = "month"
    private val DAY = "day"
    private var onDateSet = dateSet
    private var bottomClickListener: OnBottomClickListener? = null

    private var mDatePicker: DatePicker
    private var mView: View = LayoutInflater.from(context).inflate(R.layout.date_picker_dialog, null)

    init {
        mDatePicker = mView.findViewById(R.id.date_picker)
        mDatePicker.init(year, month, day, this)
        click()
    }

    private fun click() {
        mView.findViewById<TextView>(R.id.tv_sure).setOnClickListener {
            if (bottomClickListener != null) {
                bottomClickListener!!.onSure()
            }
        }
        mView.findViewById<TextView>(R.id.tv_cancel).setOnClickListener {
            if (bottomClickListener != null) {
                bottomClickListener!!.onCancel()
            }
        }
    }

    fun setBottomClickListener(bottomClickListener: OnBottomClickListener) {
        this.bottomClickListener = bottomClickListener
    }

    fun dateSet() {
        mDatePicker.clearFocus()
        onDateSet.onDateSet(mDatePicker, mDatePicker.year, mDatePicker.month, mDatePicker.dayOfMonth)
        this.dismiss()
    }

    interface OnSetDateListener {
        fun onDateSet(dataPicker: DatePicker, year: Int, month: Int, day: Int)
    }

    interface OnBottomClickListener {
        fun onCancel()
        fun onSure()
    }

    override fun onDateChanged(datePicker: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        mDatePicker.init(year, monthOfYear, dayOfMonth, this)
    }

    fun showDatePicker() {
        mView.findViewById<TextView>(R.id.tv_date_picker).text = title
        this.show()
        this.setContentView(mView)
    }

    override fun onSaveInstanceState(): Bundle {
        val bundle = super.onSaveInstanceState()
        bundle.putInt(YEAR, mDatePicker.year)
        bundle.putInt(MONTH, mDatePicker.month)
        bundle.putInt(DAY, mDatePicker.dayOfMonth)
        return bundle
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val year = savedInstanceState.getInt(YEAR)
        val month = savedInstanceState.getInt(MONTH)
        val day = savedInstanceState.getInt(DAY)
        mDatePicker.init(year, month, day, this)
    }

}