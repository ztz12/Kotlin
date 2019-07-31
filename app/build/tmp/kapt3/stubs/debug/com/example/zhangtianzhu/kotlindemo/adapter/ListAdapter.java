package com.example.zhangtianzhu.kotlindemo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\nH\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/ListAdapter;", "Landroid/widget/BaseAdapter;", "activity", "Landroid/app/Activity;", "list", "", "", "(Landroid/app/Activity;Ljava/util/List;)V", "hashMap", "Ljava/util/HashMap;", "", "getCount", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "insert", "", "info", "remove", "TextChanged", "ViewHolder", "app_debug"})
public final class ListAdapter extends android.widget.BaseAdapter {
    private final java.util.HashMap<java.lang.Integer, java.lang.String> hashMap = null;
    private final android.app.Activity activity = null;
    private final java.util.List<java.lang.String> list = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object getItem(int position) {
        return null;
    }
    
    public final void remove(int position) {
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    java.lang.String info, int position) {
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    public ListAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J*\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/ListAdapter$TextChanged;", "Landroid/text/TextWatcher;", "position", "", "holder", "Lcom/example/zhangtianzhu/kotlindemo/adapter/ListAdapter$ViewHolder;", "list", "", "", "(Lcom/example/zhangtianzhu/kotlindemo/adapter/ListAdapter;ILcom/example/zhangtianzhu/kotlindemo/adapter/ListAdapter$ViewHolder;Ljava/util/List;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "app_debug"})
    public final class TextChanged implements android.text.TextWatcher {
        private final int position = 0;
        private final com.example.zhangtianzhu.kotlindemo.adapter.ListAdapter.ViewHolder holder = null;
        private final java.util.List<java.lang.String> list = null;
        
        @java.lang.Override()
        public void afterTextChanged(@org.jetbrains.annotations.Nullable()
        android.text.Editable s) {
        }
        
        @java.lang.Override()
        public void beforeTextChanged(@org.jetbrains.annotations.Nullable()
        java.lang.CharSequence s, int start, int count, int after) {
        }
        
        @java.lang.Override()
        public void onTextChanged(@org.jetbrains.annotations.Nullable()
        java.lang.CharSequence s, int start, int before, int count) {
        }
        
        public TextChanged(int position, @org.jetbrains.annotations.NotNull()
        com.example.zhangtianzhu.kotlindemo.adapter.ListAdapter.ViewHolder holder, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> list) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/ListAdapter$ViewHolder;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "et", "Landroid/widget/EditText;", "getEt", "()Landroid/widget/EditText;", "setEt", "(Landroid/widget/EditText;)V", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "setTv", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tv;
        @org.jetbrains.annotations.NotNull()
        private android.widget.EditText et;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTv() {
            return null;
        }
        
        public final void setTv(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getEt() {
            return null;
        }
        
        public final void setEt(@org.jetbrains.annotations.NotNull()
        android.widget.EditText p0) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super();
        }
    }
}