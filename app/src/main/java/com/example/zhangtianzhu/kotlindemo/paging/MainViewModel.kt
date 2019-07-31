package com.example.zhangtianzhu.kotlindemo.paging

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.zhangtianzhu.kotlindemo.bean.Student
import com.example.zhangtianzhu.kotlindemo.bean.StudentDb

//使用ViewModel的子类AndroidViewHolder防止，viewModel持有activity引用，
// 导致activity无法销毁，AndroidViewModel持有的是整个应用application
class MainViewModel(app:Application):AndroidViewModel(app) {
    val dao = StudentDb.get(app).studentDao()

    //参数一：DataSource数据源，数据改变会驱动列表更新
    //参数二：PageList是从数据源加载数据，控制第一个加载多少数据，以后每次加载多少数据，并将更新反应到UI上
    //PageListAdapter 继承RecyclerViewAdapter 适配器，通过分析数据是否改变，处理UI界面展示逻辑，增加删除替换等
    val allStudent = LivePagedListBuilder(dao.getAllStudent(),PagedList.Config.Builder()
            .setPageSize(PAGE_SIZE)//设置分页加载数量
            .setEnablePlaceholders(ENABLE_PLACEHOLDERS)//是否启用占位符
            .setInitialLoadSizeHint(PAGE_SIZE)//设置初始化加载数量
            .build()).build()

    fun insert(name: String){
        dao.addStudent(Student(id = 0,name = name))
    }

    fun delete(name: String){
        dao.deleteStudent(Student(id = 0,name = name))
    }

    companion object {
        private const val PAGE_SIZE = 15

        private const val ENABLE_PLACEHOLDERS = false
    }
}