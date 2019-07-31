package com.example.zhangtianzhu.kotlindemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class KotlinInit {
    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static Handler handler;

    public static void init(Context c){
        context = c;
        handler = new Handler(Looper.getMainLooper());
    }

    /**
     * 获取全局Context
     */
    public static Context getContext(){
        return context;
    }

    public static Handler getHandler(){
        return handler;
    }
}
