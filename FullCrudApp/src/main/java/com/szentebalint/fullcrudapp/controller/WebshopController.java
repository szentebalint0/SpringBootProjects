package com.szentebalint.fullcrudapp.controller;

import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.service.ProductService;
import com.szentebalint.fullcrudapp.controller.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebshopController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{productId}")
    public Product getAllProducts(@PathVariable("productId") int productId) {
        if (productService.getProductById(productId) == null) {
            throw new ProductNotFoundException("Product not found with id of " + productId);
        }
        return productService.getProductById(productId);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
}
