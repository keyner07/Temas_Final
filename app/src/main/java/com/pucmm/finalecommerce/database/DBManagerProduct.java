package com.pucmm.finalecommerce.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.pucmm.finalecommerce.objects.Product;
import com.pucmm.finalecommerce.utils.Utils;

import java.util.ArrayList;

public class DBManagerProduct extends DBManager {
    public DBManagerProduct(Context context) {
        super(context);
    }
    public Product findProductById(long id){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_PRODUCT+" WHERE "+Utils.COLUMN_ID+" = ?", new String[]{String.valueOf(id)});
        long uid = cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_NAME));
        String description = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_DESCRIPTION));
        DBManagerImage dbManagerImage = new DBManagerImage(this.context);
        ArrayList<String> image = dbManagerImage.getImages(uid);
        int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_QUANTITY));
        int price = cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_PRICE));
        return new Product(uid,name,description,image,quantity,price);
    }
    public long findProductByName(String name){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_PRODUCT+" WHERE "+Utils.COLUMN_NAME+" = ?", new String[]{name});
        return cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID));
    }
    public boolean insert_product(String name,String description, int price, String[] images){
        ContentValues values = new ContentValues();
        values.put(Utils.COLUMN_NAME, name);
        values.put(Utils.COLUMN_PRODUCT_DESCRIPTION, description);
        values.put(Utils.COLUMN_PRODUCT_PRICE, price);
        values.put(Utils.COLUMN_PRODUCT_QUANTITY, 500);
        boolean result = database.insert(Utils.TABLE_NAME_PRODUCT, null,values) != -1;
        long idProduct = findProductByName(name);
        if(result){
            DBManagerImage image = new DBManagerImage(this.context);
            image.insert_images(images,idProduct);
            return true;
        }
        return false;
    }
}
