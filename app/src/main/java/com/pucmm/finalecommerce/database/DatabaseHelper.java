package com.pucmm.finalecommerce.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.pucmm.finalecommerce.utils.Utils;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, Utils.DB_NAME, null, Utils.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utils.ENTITY_USER);
        sqLiteDatabase.execSQL(Utils.ENTITY_CART);
        sqLiteDatabase.execSQL(Utils.ENTITY_CATEGORY);
        sqLiteDatabase.execSQL(Utils.ENTITY_IMAGE);
        sqLiteDatabase.execSQL(Utils.ENTITY_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utils.TABLE_NAME_CART);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utils.TABLE_NAME_IMAGE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utils.TABLE_NAME_PRODUCT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utils.TABLE_NAME_CATEGORY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ Utils.TABLE_NAME_USER);
        onCreate(sqLiteDatabase);
    }
}
