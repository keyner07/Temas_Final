package com.pucmm.finalecommerce.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    protected DatabaseHelper helper;
    protected SQLiteDatabase database;
    protected Context context;

    public DBManager(Context context){
        this.context = context;
    }
    public DBManager open() throws SQLException {
        this.helper = new DatabaseHelper(this.context);
        this.database = helper.getWritableDatabase();
        return this;
    }
    public void close() {
        helper.close();
    }

}
