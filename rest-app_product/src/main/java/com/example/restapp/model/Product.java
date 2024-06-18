package com.example.restapp.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "type_of_liquor")
    private String type_of_liquor;

    @Column(name = "product_Name")
    private String product_Name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

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
