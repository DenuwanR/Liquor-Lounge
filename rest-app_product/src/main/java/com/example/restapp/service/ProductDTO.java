package com.example.restapp.service;

// ProductDTO.java
public class ProductDTO {

    private String type_of_liquor;
    private String product_Name;
    private String description;
    private int price;

    public String getType_of_liquor() {
        return type_of_liquor;
    }

    public void setType_of_liquor(String type_of_liquor) {
        this.type_of_liquor = type_of_liquor;
    }

    public String getProduct_Name() {
        return product_Name;
    }

    public void setProduct_Name(String product_Name) {
        this.product_Name = product_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
