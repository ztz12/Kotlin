package com.example.zhangtianzhu.kotlindemo.utils

import java.util.concurrent.Executors

private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

fun IO_Thread(f:()-> Unit){
    IO_EXECUTOR.execute(f)
}