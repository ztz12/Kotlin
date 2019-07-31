package com.example.zhangtianzhu.kotlindemo.adapter

import android.app.Activity
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import com.example.zhangtianzhu.kotlindemo.R

class ListAdapter(private val activity: Activity, private val list: MutableList<String>) : BaseAdapter() {
    private val hashMap = HashMap<Int,String>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.item_lv, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }
        holder.et.setText(list[position])
        if(hashMap[position]!=null){
            holder.et.setText(hashMap[position])
        }
        holder.et.addTextChangedListener(TextChanged(position, holder,list))
        return view
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    fun remove(position: Int){
        list.removeAt(position)
        this.notifyDataSetChanged()
    }

    fun insert(info:String,position: Int){
        list.add(position,info)
        this.notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

   inner class TextChanged constructor(private val position: Int, private val holder: ViewHolder, private val list: MutableList<String>) : TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            hashMap[position] = s.toString()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            list[position] = holder.et.text.toString()
        }

    }

    class ViewHolder(view: View) {
        var tv: TextView = view.findViewById(R.id.tv_lv)
        var et:EditText = view.findViewById(R.id.et_lv)
    }

}