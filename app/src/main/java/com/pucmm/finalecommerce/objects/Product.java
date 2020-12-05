package com.pucmm.finalecommerce.objects;

import com.pucmm.finalecommerce.database.DBManagerImage;
import com.pucmm.finalecommerce.utils.Utils;

import java.util.ArrayList;

public class Product {
    private long uid;
    private String name;
    private String description;
    private ArrayList<String> images;
    private int quantity;
    private int price;

    public Product(long uid, String name, String description, ArrayList<String> images, int quantity, int price) {
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.images = images;
        this.quantity = quantity;
        this.price = price;
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
