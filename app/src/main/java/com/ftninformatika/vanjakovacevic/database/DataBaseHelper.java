package com.ftninformatika.vanjakovacevic.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ftninformatika.vanjakovacevic.model.Group;
import com.ftninformatika.vanjakovacevic.model.Todo;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "database_name.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Group, Integer> groupDao;
    private Dao<Todo, Integer> todoDao;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTableIfNotExists(connectionSource, Group.class);
            Log.d(TAG, "onCreate: SUCCESS on Create Table 1!");
            TableUtils.createTableIfNotExists(connectionSource, Todo.class);
            Log.d(TAG, "onCreate: SUCCESS on Create Table 2!");
        } catch (SQLException e) {
            Log.e(TAG, "onCreate: ERROR on Create Table " + e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

        try {
            TableUtils.dropTable(connectionSource, Group.class, true);
            TableUtils.dropTable(connectionSource, Todo.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dao<Group, Integer> getGroupDao() throws SQLException {

        if (groupDao == null) {
            groupDao = getDao(Group.class);
        }
        return groupDao;
    }

    public Dao<Todo, Integer> getTodoDao() throws SQLException {

        if(todoDao == null) {
            todoDao = getDao(Todo.class);
        }
        return todoDao;
    }


    @Override
    public void close() {
        groupDao = null;
        todoDao = null;
        super.close();
    }
}
