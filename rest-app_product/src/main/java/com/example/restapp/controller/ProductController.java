

package com.example.restapp.controller;

import com.example.restapp.model.Product;
import com.example.restapp.repository.ProductRepository;
import com.example.restapp.service.ProductDTO;
import com.example.restapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> getFeedbacksForBottle(@PathVariable int id) {
        try {
            List<Product> feedbacks = productRepository.findById(id);
            return ResponseEntity.ok(feedbacks);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductDTO productDTO) {
        try {
            // Convert ProductDTO to Product entity
            Product product = new Product();
            product.setType_of_liquor(productDTO.getType_of_liquor());
            product.setProduct_Name(productDTO.getProduct_Name());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());

            // Save the product to the database
            productRepository.save(product);

            return ResponseEntity.ok("Product added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product");
        }
    }
}
