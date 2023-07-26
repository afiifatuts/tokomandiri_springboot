package com.mandiri.tokomandiri.service.impl;

import com.mandiri.tokomandiri.entity.Product;
import com.mandiri.tokomandiri.repository.ProductRepository;
import com.mandiri.tokomandiri.service.ProductService;
import com.mandiri.tokomandiri.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Autowired //->Dependency Injection
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product getProductById(String product_id) {
        return productRepository.findById(product_id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        if(productRepository.findById(product.getId()).isPresent()){
            return productRepository.save(product);
        }else {
            throw new DataNotFoundException("Product with ID " + product.getId() + " not found in the database.");
        }
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
