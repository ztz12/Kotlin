package com.example.zhangtianzhu.kotlindemo.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014\u00a8\u0006\t"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/ui/AnimatorActivityTwo;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "app_debug"})
public final class AnimatorActivityTwo extends android.support.v7.app.AppCompatActivity {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 在onPause中，setResult方法无法执行
     */
    @java.lang.Override()
    protected void onPause() {
    }
    
    /**
     * 在onBackPress方法中调用setResult方法该方法必须在super.onBackPress之前调用或者，在点击事件中调用setResult方法再finish该界面
     */
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public AnimatorActivityTwo() {
        super();
    }
}