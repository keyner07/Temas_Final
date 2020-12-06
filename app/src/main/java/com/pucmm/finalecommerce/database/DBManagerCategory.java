package com.pucmm.finalecommerce.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.pucmm.finalecommerce.objects.Category;
import com.pucmm.finalecommerce.objects.User;
import com.pucmm.finalecommerce.utils.Utils;

import java.util.ArrayList;

public class DBManagerCategory extends DBManager {
    public DBManagerCategory(Context context) {
        super(context);
    }

    public boolean insert_category(String name, String url){
        ContentValues values = new ContentValues();
        values.put(Utils.COLUMN_CATEGORY_IMAGE, url);
        values.put(Utils.COLUMN_NAME, name);
        return this.database.insert(Utils.TABLE_NAME_CATEGORY,null,values) != 1;
    }

    public ArrayList<Category> getCategories(){
        String[] columns = new String[]{Utils.COLUMN_NAME,Utils.COLUMN_CATEGORY_IMAGE};
        Cursor cursor = this.database.query(Utils.TABLE_NAME_CATEGORY, columns, null, null, null, null, null);
        return getCategory(cursor);
    }

    private ArrayList<Category> getCategory(Cursor cursor) {
        ArrayList<Category> categories = new ArrayList<>();
            if(cursor != null && cursor.getCount() > 0)
                cursor.moveToFirst();
        assert cursor != null;
        for(int i = 0; i< cursor.getCount(); i++){
                Category category = new Category(cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID)), cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_NAME)), cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_CATEGORY_IMAGE)));
                categories.add(category);
                cursor.moveToNext();
            }
            return categories;
    }

    public boolean delete(long i) {
        return database.delete(Utils.TABLE_NAME_CATEGORY,Utils.COLUMN_ID + "="+ i,null) == 1;
    }
    public String getNameCategoryById(long id){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_CATEGORY+" WHERE "+Utils.COLUMN_ID+" = ?", new String[]{String.valueOf(id)});
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_NAME));
        }
        return "sin-asignar";
    }
}
