package com.example.zhangtianzhu.kotlindemo.bean;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\'J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\'J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\nH\'J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/example/zhangtianzhu/kotlindemo/bean/StudentDao;", "", "addListStudent", "", "student", "", "Lcom/example/zhangtianzhu/kotlindemo/bean/Student;", "addStudent", "deleteStudent", "getAllStudent", "Landroid/arch/paging/DataSource$Factory;", "", "selectStudentName", "name", "", "app_debug"})
public abstract interface StudentDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM Student ORDER BY name COLLATE NOCASE ASC")
    public abstract android.arch.paging.DataSource.Factory<java.lang.Integer, com.example.zhangtianzhu.kotlindemo.bean.Student> getAllStudent();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM Student WHERE name = :name")
    public abstract com.example.zhangtianzhu.kotlindemo.bean.Student selectStudentName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @android.arch.persistence.room.Insert(onConflict = android.arch.persistence.room.OnConflictStrategy.REPLACE)
    public abstract void addStudent(@org.jetbrains.annotations.NotNull()
    com.example.zhangtianzhu.kotlindemo.bean.Student student);
    
    @android.arch.persistence.room.Insert()
    public abstract void addListStudent(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.zhangtianzhu.kotlindemo.bean.Student> student);
    
    @android.arch.persistence.room.Delete()
    public abstract void deleteStudent(@org.jetbrains.annotations.NotNull()
    com.example.zhangtianzhu.kotlindemo.bean.Student student);
}