package com.pucmm.finalecommerce.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.pucmm.finalecommerce.objects.Category;
import com.pucmm.finalecommerce.objects.Product;
import com.pucmm.finalecommerce.utils.Utils;

import java.util.ArrayList;

public class DBManagerProduct extends DBManager {
    public DBManagerProduct(Context context) {
        super(context);
    }
    public Product findProductById(long id){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_PRODUCT+" WHERE "+Utils.COLUMN_ID+" = ?", new String[]{String.valueOf(id)});
        cursor.moveToFirst();
        long uid = cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_NAME));
        String description = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_DESCRIPTION));
        DBManagerImage dbManagerImage = new DBManagerImage(this.context);
        ArrayList<String> image = dbManagerImage.getImages(uid);
        int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_QUANTITY));
        int price = cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_PRICE));
        int idCategory = cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_CATEGORY_ID));
        return new Product(uid,name,description,image,quantity,price, idCategory);
    }
    public long findProductByName(String name){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_PRODUCT+" WHERE "+Utils.COLUMN_NAME+" = ?", new String[]{name});
        return cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID));
    }
    public boolean insert_product(String name,String description, int price, String[] images, int category_id){
        ContentValues values = new ContentValues();
        values.put(Utils.COLUMN_NAME, name);
        values.put(Utils.COLUMN_PRODUCT_DESCRIPTION, description);
        values.put(Utils.COLUMN_PRODUCT_PRICE, price);
        values.put(Utils.COLUMN_PRODUCT_QUANTITY, 500);
        values.put(Utils.COLUMN_PRODUCT_CATEGORY_ID, category_id);
        boolean result = database.insert(Utils.TABLE_NAME_PRODUCT, null,values) != -1;
        long idProduct = findProductByName(name);
        if(result){
            DBManagerImage image = new DBManagerImage(this.context);
            image.insert_images(images,idProduct);
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProducts() {
        String[] columns = new String[]{Utils.COLUMN_ID,Utils.COLUMN_NAME, Utils.COLUMN_PRODUCT_DESCRIPTION, Utils.COLUMN_PRODUCT_QUANTITY, Utils.COLUMN_PRODUCT_PRICE, Utils.COLUMN_PRODUCT_CATEGORY_ID};
        Cursor cursor = this.database.query(Utils.TABLE_NAME_PRODUCT,columns,null, null,null,null,null);
        return getAllProducts(cursor);
    }
    private ArrayList<Product> getAllProducts(Cursor cursor){
        ArrayList<Product> products = new ArrayList<>();
        DBManagerImage dbManagerImage = new DBManagerImage(this.context);
        if(cursor != null && cursor.getCount() > 0)
            cursor.moveToFirst();
        assert cursor != null;
        for(int i = 0; i< cursor.getCount(); i++){
            String image = dbManagerImage.getImage(cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID)));
            Product product = new Product(cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID)),cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_NAME)),cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_DESCRIPTION)),
                    image,cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_QUANTITY)),cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_PRICE)), cursor.getInt(cursor.getColumnIndexOrThrow(Utils.COLUMN_PRODUCT_CATEGORY_ID)));
            products.add(product);
            cursor.moveToNext();
        }
        return products;
    }

    public ArrayList<Product> findProductsByCategoryId(int categoryId){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_PRODUCT+" WHERE "+Utils.COLUMN_PRODUCT_CATEGORY_ID+" = ?",new String[]{String.valueOf(categoryId)});
        return getAllProducts(cursor);
    }
}
