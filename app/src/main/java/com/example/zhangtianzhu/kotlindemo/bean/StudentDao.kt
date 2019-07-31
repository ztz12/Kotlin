package com.example.zhangtianzhu.kotlindemo.bean

import android.arch.paging.DataSource
import android.arch.persistence.room.*

@Dao
interface StudentDao{
    @Query("SELECT * FROM Student ORDER BY name COLLATE NOCASE ASC")
    fun getAllStudent():DataSource.Factory<Int,Student>

    @Query("SELECT * FROM Student WHERE name = :name")
    fun selectStudentName(name:String):Student

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addStudent(student: Student)

    @Insert
    fun addListStudent(student: List<Student>)

    @Delete
    fun deleteStudent(student: Student)
}