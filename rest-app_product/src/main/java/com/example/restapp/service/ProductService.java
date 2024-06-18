package com.example.restapp.service;

import com.example.restapp.model.Product;
import com.example.restapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Implement this method to save the product data to the database
    public void addProduct(ProductDTO productDTO) {
        // Convert ProductDTO to Product entity
        Product product = new Product();
        product.setType_of_liquor(productDTO.getType_of_liquor());
        product.setProduct_Name(productDTO.getProduct_Name());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());

        // Save the product to the database
        productRepository.save(product);
    }
}
