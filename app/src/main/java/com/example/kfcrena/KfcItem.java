package com.example.kfcrena;

import java.io.Serializable;

public class KfcItem implements Serializable {
    public enum Type { PRODUCT, COUPON }

    private String name;
    private double price;
    private int imageRes;
    private String description;
    private String code; // Only for coupons
    private Type type;

    // Constructor for Product
    public KfcItem(String name, double price, int imageRes, String description) {
        this.name = name;
        this.price = price;
        this.imageRes = imageRes;
        this.description = description;
        this.type = Type.PRODUCT;
    }

    // Constructor for Coupon
    public KfcItem(String name, String description, int imageRes, String code) {
        this.name = name;
        this.description = description;
        this.imageRes = imageRes;
        this.code = code;
        this.type = Type.COUPON;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getImageRes() { return imageRes; }
    public String getDescription() { return description; }
    public String getCode() { return code; }
    public Type getType() { return type; }
}