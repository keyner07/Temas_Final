package com.pucmm.finalecommerce.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.pucmm.finalecommerce.utils.Utils;

import java.util.ArrayList;

public class DBManagerImage extends DBManager {
    public DBManagerImage(Context context) {
        super(context);
    }

    public boolean insert_images(String[] urls, long idProduct){
        for (String url : urls) {
            ContentValues values = new ContentValues();
            values.put(Utils.COLUMN_IMAGE_URL, url);
            values.put(Utils.COLUMN_IMAGE_ID_PRODUCT, idProduct);
            this.database.insert(Utils.TABLE_NAME_IMAGE, null, values);
        }
        return true;
    }

    public String getImage(long idProduct){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_IMAGE+" WHERE "+Utils.COLUMN_IMAGE_ID_PRODUCT+" = ?", new String[]{String.valueOf(idProduct)});
        String url = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_IMAGE_URL));
        return url;
    }

    public ArrayList<String> getImages(long idProduct){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+ Utils.TABLE_NAME_IMAGE+" WHERE "+Utils.COLUMN_IMAGE_ID_PRODUCT+" = ?", new String[]{String.valueOf(idProduct)});
        ArrayList<String> results = new ArrayList<>();
        for(int i=0; i<cursor.getCount();i++){
            String url = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_IMAGE_URL));
            results.add(url);
            cursor.moveToNext();
        }
        return results;
    }
}
