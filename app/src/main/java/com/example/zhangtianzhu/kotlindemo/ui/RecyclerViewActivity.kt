package com.example.zhangtianzhu.kotlindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter
import com.example.zhangtianzhu.kotlindemo.adapter.SimpleTouchCallback
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private val linearLayoutManager : LinearLayoutManager by lazy { LinearLayoutManager(this) }

    private lateinit var mAdapter:RecyclerAdapter

    private lateinit var list: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        list = ArrayList()
        mAdapter = RecyclerAdapter(list,rl)
        rl.run {
            adapter = mAdapter
            layoutManager = linearLayoutManager
            itemAnimator = DefaultItemAnimator()
        }
        val callback:ItemTouchHelper.Callback = SimpleTouchCallback(mAdapter)
        val helper = ItemTouchHelper(callback)
        //与recyclerView建立关联
        helper.attachToRecyclerView(rl)
//        mAdapter.setTextChanged(object :RecyclerAdapter.onTextChaged{
//            override fun textChanged(position: Int, text: String) {
//                list[position] = text
//            }
//        })
        btn_rl.setOnClickListener {
            list.add("")
            mAdapter.notifyDataSetChanged()
        }
    }
}
