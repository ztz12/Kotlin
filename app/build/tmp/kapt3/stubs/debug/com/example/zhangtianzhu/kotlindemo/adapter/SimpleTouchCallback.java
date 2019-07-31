package com.example.zhangtianzhu.kotlindemo.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016JF\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J&\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u001a\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/adapter/SimpleTouchCallback;", "Landroid/support/v7/widget/helper/ItemTouchHelper$Callback;", "recyclerAdapter", "Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter;", "(Lcom/example/zhangtianzhu/kotlindemo/adapter/RecyclerAdapter;)V", "clearView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "viewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "getMovementFlags", "", "isItemViewSwipeEnabled", "", "isLongPressDragEnabled", "onChildDraw", "c", "Landroid/graphics/Canvas;", "dX", "", "dY", "actionState", "isCurrentlyActive", "onMove", "target", "onSwiped", "direction", "app_debug"})
public final class SimpleTouchCallback extends android.support.v7.widget.helper.ItemTouchHelper.Callback {
    private final com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter recyclerAdapter = null;
    
    @java.lang.Override()
    public int getMovementFlags(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        return 0;
    }
    
    @java.lang.Override()
    public boolean isLongPressDragEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isItemViewSwipeEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public boolean onMove(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder, @org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView.ViewHolder target) {
        return false;
    }
    
    @java.lang.Override()
    public void onSwiped(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int direction) {
    }
    
    @java.lang.Override()
    public void clearView(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
    }
    
    @java.lang.Override()
    public void onChildDraw(@org.jetbrains.annotations.Nullable()
    android.graphics.Canvas c, @org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    android.support.v7.widget.RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    }
    
    public SimpleTouchCallback(@org.jetbrains.annotations.NotNull()
    com.example.zhangtianzhu.kotlindemo.adapter.RecyclerAdapter recyclerAdapter) {
        super();
    }
}