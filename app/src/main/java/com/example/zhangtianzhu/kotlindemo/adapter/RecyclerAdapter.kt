package com.example.zhangtianzhu.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.zhangtianzhu.kotlindemo.R
import java.util.*
import kotlin.collections.HashMap

class RecyclerAdapter(private val list: MutableList<String>, private val recyclerView: RecyclerView) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(), ItemToucherAdapter {
    private val hashMap = HashMap<Int, String>()
    private var mTextChanged: onTextChaged? = null
    override fun ItemMove(firstPosition: Int, toPosition: Int) {
        Collections.swap(list, firstPosition, toPosition)
        notifyItemMoved(firstPosition, toPosition)
    }

    override fun ItemDissmiss(firstPosition: Int) {
        list.removeAt(firstPosition)
        notifyItemRemoved(firstPosition)
        notifyItemRangeChanged(firstPosition, list.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (hashMap[position] != null) {
            holder.et.setText(hashMap[position])
            holder.et.addTextChangedListener(TextChanged(position, list, holder))
        }
        holder.et.tag = "et$position"
        changeFocus(list.size - 1, holder)
//        holder.et.setText(list[position])
////        //多个EditText焦点错乱
//        holder.et.setOnFocusChangeListener { v, hasFocus ->
//            if(hasFocus){
//                holder.et.addTextChangedListener(TextChanged(position, list,holder))
//            }else{
//                holder.et.removeTextChangedListener(TextChanged(position, list, holder))
//            }
//        }
    }

    private fun changeFocus(position: Int, holder: ViewHolder) {
        if (holder.et.findViewWithTag<EditText>("et$position") != null) {
            val et: EditText = holder.et.findViewWithTag("et$position")
            et.isFocusable = true
            et.isFocusableInTouchMode = true
        }
    }

    inner class TextChanged constructor(private val position: Int, private val list: MutableList<String>, private val holder: ViewHolder) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            hashMap[position] = s.toString()
            mTextChanged?.textChanged(position, s.toString())
//            if(holder.et.hasFocus()) {
//                mTextChanged?.textChanged(position, s.toString())
//            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            list[position] = s.toString()
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val et = view.findViewById<EditText>(R.id.et_lv)!!
    }

    fun setTextChanged(textChanged: onTextChaged) {
        mTextChanged = textChanged
    }

    interface onTextChaged {
        fun textChanged(position: Int, text: String)
    }
}