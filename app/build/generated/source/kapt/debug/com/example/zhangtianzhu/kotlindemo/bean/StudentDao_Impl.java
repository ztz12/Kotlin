package com.example.zhangtianzhu.kotlindemo.bean;

import android.arch.paging.DataSource;
import android.arch.paging.DataSource.Factory;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.paging.LimitOffsetDataSource;
import android.database.Cursor;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfStudent;

  private final EntityInsertionAdapter __insertionAdapterOfStudent_1;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfStudent;

  public StudentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudent = new EntityInsertionAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Student`(`id`,`name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__insertionAdapterOfStudent_1 = new EntityInsertionAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Student`(`id`,`name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__deletionAdapterOfStudent = new EntityDeletionOrUpdateAdapter<Student>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Student` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Student value) {
        stmt.bindLong(1, value.getId());
      }
    };
  }

  @Override
  public void addStudent(Student student) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfStudent.insert(student);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void addListStudent(List<Student> student) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfStudent_1.insert(student);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteStudent(Student student) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfStudent.handle(student);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public DataSource.Factory<Integer, Student> getAllStudent() {
    final String _sql = "SELECT * FROM Student ORDER BY name COLLATE NOCASE ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, Student>() {
      @Override
      public LimitOffsetDataSource<Student> create() {
        return new LimitOffsetDataSource<Student>(__db, _statement, false , "Student") {
          @Override
          protected List<Student> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = cursor.getColumnIndexOrThrow("id");
            final int _cursorIndexOfName = cursor.getColumnIndexOrThrow("name");
            final List<Student> _res = new ArrayList<Student>(cursor.getCount());
            while(cursor.moveToNext()) {
              final Student _item;
              final int _tmpId;
              _tmpId = cursor.getInt(_cursorIndexOfId);
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              _item = new Student(_tmpId,_tmpName);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public Student selectStudentName(String name) {
    final String _sql = "SELECT * FROM Student WHERE name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final Student _result;
      if(_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _result = new Student(_tmpId,_tmpName);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
