package com.example.zhangtianzhu.kotlindemo.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.zhangtianzhu.kotlindemo.R
import com.example.zhangtianzhu.kotlindemo.paging.MainViewModel
import com.example.zhangtianzhu.kotlindemo.paging.StudentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(application) as T
        }).get(MainViewModel::class.java)
    }

    private val mAdapter:StudentAdapter by lazy { StudentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)
        recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        viewModel.allStudent.observe(this, Observer { mAdapter.submitList(it) })
    }
}
