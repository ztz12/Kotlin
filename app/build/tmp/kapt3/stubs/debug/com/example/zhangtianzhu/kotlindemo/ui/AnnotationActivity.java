package com.example.zhangtianzhu.kotlindemo.ui;

import java.lang.System;

/**
 * Android 通过一些注解Annotation来提示开发者代码编写是否恰当，但对于那些不懂注解方法的开发者，会造成误解
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0003J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\rH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/ui/AnnotationActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setText", "showInfo", "msg", "", "stringRes", "id", "", "app_debug"})
public final class AnnotationActivity extends android.support.v7.app.AppCompatActivity {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showInfo(@android.support.annotation.NonNull()
    java.lang.String msg) {
    }
    
    private final void stringRes(@android.support.annotation.StringRes()
    int id) {
    }
    
    @android.support.annotation.UiThread()
    private final void setText() {
    }
    
    public AnnotationActivity() {
        super();
    }
}