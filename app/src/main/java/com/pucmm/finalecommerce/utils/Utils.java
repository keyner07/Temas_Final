package com.pucmm.finalecommerce.utils;

public class Utils {
    public static final String DB_NAME = "TEST.DB";
    public static final int DB_VERSION = 1;

    public static final String  TABLE_NAME_USER = "USER";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_USER_CONTACT = "contact";
    public static final String COLUMN_USER_EMAIL="email";
    public static final String COLUMN_USER_PASSWORD= "password";
    public static final String COLUMN_USER_URL="url";

    public static final String ENTITY_USER = "CREATE TABLE "+ TABLE_NAME_USER+
            " ("+ COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_NAME+" TEXT NOT NULL, "+
            COLUMN_USER_CONTACT+" TEXT NOT NULL, "+
            COLUMN_USER_EMAIL+" TEXT NOT NULL UNIQUE, "+
            COLUMN_USER_URL+" TEXT NOT NULL, "+
            COLUMN_USER_PASSWORD+ " TEXT NOT NULL) ";

    public static final String TABLE_NAME_CATEGORY = "CATEGORY";
    public static final String COLUMN_CATEGORY_IMAGE = "url";
    public static final String ENTITY_CATEGORY="CREATE TABLE "+ TABLE_NAME_CATEGORY+
            " ("+ COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_NAME+" TEXT NOT NULL, "+
            COLUMN_CATEGORY_IMAGE+ " TEXT NOT NULL) ";

    public static final String TABLE_NAME_PRODUCT="PRODUCT";
    public static final String COLUMN_PRODUCT_DESCRIPTION="description";
    public static final String COLUMN_PRODUCT_QUANTITY="quantity";
    public static final String COLUMN_PRODUCT_PRICE="price";
    public static final String COLUMN_PRODUCT_CATEGORY_ID="idCategory";
    public static final String ENTITY_PRODUCT = "CREATE TABLE "+ TABLE_NAME_PRODUCT+
            " ("+ COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_NAME+" TEXT NOT NULL, "+
            COLUMN_PRODUCT_DESCRIPTION+" TEXT NOT NULL, "+
            COLUMN_PRODUCT_PRICE+" INTEGER NOT NULL, "+
            COLUMN_PRODUCT_QUANTITY+" INTEGER NOT NULL, "+
            COLUMN_PRODUCT_CATEGORY_ID+" INTEGER NOT NULL) ";

    public static final String TABLE_NAME_IMAGE="IMAGE";
    public static final String COLUMN_IMAGE_URL = "url";
    public static final String COLUMN_IMAGE_ID_PRODUCT = "idProduct";
    public static final String ENTITY_IMAGE = "CREATE TABLE "+TABLE_NAME_IMAGE+
            " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_IMAGE_URL+" TEXT NOT NULL, "+
            COLUMN_IMAGE_ID_PRODUCT+ " INTEGER UNIQUE NOT NULL) ";

    public static final String TABLE_NAME_CART="CART";
    public static final String COLUMN_CART_PRODUCT_ID="idProduct";
    public static final String COLUMN_CART_PRODUCT_QUANTITY="quantity";
    public static final String COLUMN_CART_USER_ID="idUser";
    public static final String ENTITY_CART="CREATE TABLE "+ TABLE_NAME_CART+
            " ("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COLUMN_CART_PRODUCT_ID+" INTEGER NOT NULL, "+
            COLUMN_CART_PRODUCT_QUANTITY+" INTEGER NOT NULL, "+
            COLUMN_CART_USER_ID+" INTEGER NOT NULL) ";
}
