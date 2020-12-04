package com.pucmm.finalecommerce.objects;

import android.content.ContentValues;

import com.pucmm.finalecommerce.utils.Utils;

public class User {
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_USER_CONTACT = "contact";
    public static final String COLUMN_USER_EMAIL="email";
    public static final String COLUMN_USER_PASSWORD= "password";
    private String _id;
    private String name;
    private String contact;
    private String email;
    private String password;
    private String url;

    public User(String name, String email, String password, String contact, String url){
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.url = url;
    }

    public User(String name, String contact, String email, String password, String url,String _id) {
        this._id = _id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.url = url;
    }

    public ContentValues insert(){
        ContentValues values = new ContentValues();
        values.put(Utils.COLUMN_USER_CONTACT, this.contact);
        values.put(Utils.COLUMN_USER_EMAIL, this.email);
        values.put(Utils.COLUMN_USER_PASSWORD, this.password);
        values.put(Utils.COLUMN_NAME, this.name);
        values.put(Utils.COLUMN_USER_URL, this.url);
        return values;
    }
}
