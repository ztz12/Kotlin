package com.example.zhangtianzhu.kotlindemo.widget;

import java.lang.System;

/**
 * 此方法解决scrollView与listView或者两个listview互相嵌套嵌套只显示一行item的问题，但是在使用EditeText作为item，并调用他的addTextChangedListener方法时
 * 方法会被多次调用，添加并保存上一个item内容也无法保存，，所以不能在该情况下使用MyListView
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/widget/MyListView;", "Landroid/widget/ListView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "app_debug"})
public class MyListView extends android.widget.ListView {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    public MyListView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.util.AttributeSet attributeSet) {
        super(null);
    }
}