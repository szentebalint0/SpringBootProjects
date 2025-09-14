package com.szentebalint.fullcrudapp.controller;

import com.szentebalint.fullcrudapp.controller.exceptions.BadRequestBodyException;
import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.service.ProductService;
import com.szentebalint.fullcrudapp.controller.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebshopController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{productId}")
    public Product getAllProducts(@PathVariable("productId") int productId) {
        if (productService.getProductById(productId) == null) {
            throw new ProductNotFoundException("Product not found with id of " + productId);
        }
        return productService.getProductById(productId);

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("products/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("productId") int productId) {
        if (productService.getProductById(productId) == null) {
            throw new ProductNotFoundException("Product not found with id of " + productId);
        }
        return productService.save(product);
    }

    @PatchMapping("products/{productId}")
    public Product patchProduct(@RequestBody Map<String, Object> patchPayload, @PathVariable("productId") int productId) {

        if (productService.getProductById(productId) == null) {

            throw new ProductNotFoundException("Product not found with id " + productId);
        }

        Product product = productService.getProductById(productId);

        if (patchPayload.containsKey("id")) {

            throw new BadRequestBodyException("ID is not allowed in request body - " + productId);
        }

        return productService.patch(product, patchPayload);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        if (productService.getProductById(productId) == null) {
            throw new ProductNotFoundException("Product not found with id of " + productId);
        }
        productService.deleteById(productId);
    }


}
