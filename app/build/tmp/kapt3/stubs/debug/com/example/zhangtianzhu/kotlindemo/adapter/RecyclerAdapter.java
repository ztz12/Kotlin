package com.example.zhangtianzhu.kotlindemo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0003\u001f !B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\fH\u0016J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000eR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$ViewHolder;", "Lcom/example/zhangtianzhu/kotlindemo/adapter/ItemToucherAdapter;", "list", "", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Ljava/util/List;Landroid/support/v7/widget/RecyclerView;)V", "hashMap", "Ljava/util/HashMap;", "", "mTextChanged", "Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$onTextChaged;", "ItemDissmiss", "", "firstPosition", "ItemMove", "toPosition", "changeFocus", "position", "holder", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setTextChanged", "textChanged", "TextChanged", "ViewHolder", "onTextChaged", "app_debug"})
public final class RecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.ViewHolder> implements com.example.zhangtianzhu.kotlindemo.adapter.ItemToucherAdapter {
    private final java.util.HashMap<java.lang.Integer, java.lang.String> hashMap = null;
    private com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.onTextChaged mTextChanged;
    private final java.util.List<java.lang.String> list = null;
    private final android.support.v7.widget.RecyclerView recyclerView = null;
    
    @java.lang.Override()
    public void ItemMove(int firstPosition, int toPosition) {
    }
    
    @java.lang.Override()
    public void ItemDissmiss(int firstPosition) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.ViewHolder holder, int position) {
    }
    
    private final void changeFocus(int position, com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.ViewHolder holder) {
    }
    
    public final void setTextChanged(@org.jetbrains.annotations.NotNull()
    com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.onTextChaged textChanged) {
    }
    
    public RecyclerAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> list, @org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView recyclerView) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J*\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J*\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$TextChanged;", "Landroid/text/TextWatcher;", "position", "", "list", "", "", "holder", "Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$ViewHolder;", "(Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter;ILjava/util/List;Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$ViewHolder;)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "app_debug"})
    public final class TextChanged implements android.text.TextWatcher {
        private final int position = 0;
        private final java.util.List<java.lang.String> list = null;
        private final com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.ViewHolder holder = null;
        
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
        java.util.List<java.lang.String> list, @org.jetbrains.annotations.NotNull()
        com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter.ViewHolder holder) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "et", "Landroid/widget/EditText;", "getEt", "()Landroid/widget/EditText;", "app_debug"})
    public static final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.EditText et = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getEt() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter$onTextChaged;", "", "textChanged", "", "position", "", "text", "", "app_debug"})
    public static abstract interface onTextChaged {
        
        public abstract void textChanged(int position, @org.jetbrains.annotations.NotNull()
        java.lang.String text);
    }
}