package com.mandiri.tokomandiri.service;

import com.mandiri.tokomandiri.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product getProductById(String product_id);
    List<Product> getAllProducts();
    Product updateProduct(Product product);
    void deleteProduct(String id);
}
