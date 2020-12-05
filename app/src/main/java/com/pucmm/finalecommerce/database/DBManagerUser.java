package com.pucmm.finalecommerce.database;

import android.content.Context;
import android.database.Cursor;

import com.pucmm.finalecommerce.objects.User;
import com.pucmm.finalecommerce.utils.Utils;

public class DBManagerUser extends DBManager {
    public DBManagerUser(Context context) {
        super(context);
    }

    public boolean insert_user(User user){
        return database.insert(Utils.TABLE_NAME_USER, null,user.insert()) != -1;
    }
    public boolean check_user(String email,String password){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_USER+" WHERE "+Utils.COLUMN_USER_EMAIL+" = ? AND "+ Utils.COLUMN_USER_PASSWORD+" = ?", new String[]{email, password});
        return cursor.getCount() > 0;
    }

    public User findUserById(long id){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_USER+" WHERE "+Utils.COLUMN_ID+" = ?", new String[]{String.valueOf(id)});
        long uid = cursor.getLong(cursor.getColumnIndexOrThrow(Utils.COLUMN_ID));
        String email = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_USER_EMAIL));
        String name = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_NAME));
        String url = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_USER_URL));
        String contact = cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_USER_CONTACT));
        return new User(uid,name,contact,email,url);
    }

    public String findPasswordByEmail(String email){
        Cursor cursor = this.database.rawQuery("SELECT * FROM "+Utils.TABLE_NAME_USER+" WHERE "+Utils.COLUMN_USER_EMAIL+" = ?", new String[]{email});
        if(cursor.getCount() > 0)
            return cursor.getString(cursor.getColumnIndexOrThrow(Utils.COLUMN_USER_PASSWORD));
        return "No fue encontrado ese usuario";
    }
}
