package com.example.zhangtianzhu.kotlindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.zhangtianzhu.kotlindemo.adapter.ListAdapter
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.utils.ToastUtils
import com.example.zhangtianzhu.kotlindemo.widget.DragSortListView.DragSortListView
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var list: MutableList<String>
    private lateinit var mAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
//        initData()
        val lv = findViewById<DragSortListView>(R.id.lv)
        lv.setDropListener(drop)
        lv.setRemoveListener(remove)
        list = ArrayList()
        //设置是否拖动
        lv.isDragEnabled = true
        mAdapter = ListAdapter(this, list)
        lv.adapter = mAdapter
        lv.setOnItemClickListener { parent, view, position, id ->
            ToastUtils.showToast("当前位置: $position")
        }
        var num = 9
        addNew.setOnClickListener {
            list.add("")
            mAdapter.notifyDataSetChanged()
            num++
        }
    }

    private val drop = DragSortListView.DropListener { from, to ->
        if(from!=to) {
//            val item:String = mAdapter.getItem(from).toString()
//            mAdapter.remove(from)
//            mAdapter.insert(item,to)
            val info = list[from]
            list.removeAt(from)
            list.add(to,info)
            mAdapter.notifyDataSetChanged()
        }
    }

    private val remove = DragSortListView.RemoveListener {
        list.removeAt(it)
        mAdapter.notifyDataSetChanged()
    }
    private fun initData(){
        list = ArrayList()
        val listArray = arrayListOf("1","2","3","4","5","6","7","8")
        listArray.forEach {
            list.add(it)
        }
    }
}
