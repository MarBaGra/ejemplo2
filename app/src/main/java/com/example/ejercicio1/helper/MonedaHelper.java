package com.example.ejercicio1.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ejercicio1.modelos.DataItem;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.query.In;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class MonedaHelper extends OrmLiteSqliteOpenHelper {


    Dao<DataItem, Integer> daoMoneda;

    public MonedaHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            TableUtils.createTable(connectionSource, DataItem.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }

    public Dao<DataItem, Integer> getDaoMoneda(){
        try {
            daoMoneda = getDao(DataItem.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return daoMoneda;

    }

}
