package com.pucmm.finalecommerce.objects;

import com.pucmm.finalecommerce.database.DBManagerImage;
import com.pucmm.finalecommerce.utils.Utils;

import java.util.ArrayList;

public class Product {
    private long uid;
    private String name;
    private String description;
    private ArrayList<String> images;
    private String image;
    private int quantity;
    private int price;
    private int idCategory;

    public Product(long uid, String name, String description, ArrayList<String> images, int quantity, int price, int idCategory) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.images = images;
        this.quantity = quantity;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Product(long uid, String name, String description, String image, int quantity, int price, int idCategory) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.image = image;
        this.quantity = quantity;
        this.price = price;
        this.idCategory = idCategory;
    }

    public String getImage() {
        return image;
    }

    public long getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
