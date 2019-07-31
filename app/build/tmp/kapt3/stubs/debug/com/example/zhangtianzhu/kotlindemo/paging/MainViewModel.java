package com.example.zhangtianzhu.kotlindemo.paging;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R;\u0010\u0005\u001a,\u0012(\u0012&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/paging/MainViewModel;", "Landroid/arch/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allStudent", "Landroid/arch/lifecycle/LiveData;", "Landroid/arch/paging/PagedList;", "Lcom/example/zhangtianzhu/kotlindemo/bean/Student;", "kotlin.jvm.PlatformType", "getAllStudent", "()Landroid/arch/lifecycle/LiveData;", "dao", "Lcom/example/zhangtianzhu/kotlindemo/bean/StudentDao;", "getDao", "()Lcom/example/zhangtianzhu/kotlindemo/bean/StudentDao;", "delete", "", "name", "", "insert", "Companion", "app_debug"})
public final class MainViewModel extends android.arch.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.zhangtianzhu.kotlindemo.bean.StudentDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final android.arch.lifecycle.LiveData<android.arch.paging.PagedList<com.example.zhangtianzhu.kotlindemo.bean.Student>> allStudent = null;
    private static final int PAGE_SIZE = 15;
    private static final boolean ENABLE_PLACEHOLDERS = false;
    public static final com.example.zhangtianzhu.kotlindemo.paging.MainViewModel.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.zhangtianzhu.kotlindemo.bean.StudentDao getDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.LiveData<android.arch.paging.PagedList<com.example.zhangtianzhu.kotlindemo.bean.Student>> getAllStudent() {
        return null;
    }
    
    public final void insert(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void delete(@org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/paging/MainViewModel$Companion;", "", "()V", "ENABLE_PLACEHOLDERS", "", "PAGE_SIZE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}