package com.mandiri.tokomandiri.controller;

import com.mandiri.tokomandiri.entity.Product;
import com.mandiri.tokomandiri.repository.ProductRepository;
import com.mandiri.tokomandiri.service.ProductService;
import com.mandiri.tokomandiri.utils.constant.ApiUrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiUrlConstant.PRODUCT_PATH)
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable("id") String productId, @RequestBody Product updatedProduct) {
        // Process the update using productService
        // ... (tambahkan logika untuk validasi, pembaruan, dan penanganan pengecualian jika perlu)
        return productService.updateProduct(updatedProduct);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
         productService.deleteProduct(id);
    }



}


