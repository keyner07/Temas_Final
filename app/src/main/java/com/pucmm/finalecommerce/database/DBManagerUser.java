package com.pucmm.finalecommerce.database;

import android.content.Context;

import com.pucmm.finalecommerce.objects.User;
import com.pucmm.finalecommerce.utils.Utils;

public class DBManagerUser extends DBManager {
    public DBManagerUser(Context context) {
        super(context);
    }

    public void insert_user(User user){
        database.insert(Utils.TABLE_NAME_USER, null,user.insert());
    }
}
