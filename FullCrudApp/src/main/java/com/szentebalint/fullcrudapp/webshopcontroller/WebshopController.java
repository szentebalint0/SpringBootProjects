package com.szentebalint.fullcrudapp.webshopcontroller;

import com.szentebalint.fullcrudapp.dao.ProductDAO;
import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.webshopcontroller.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebshopController {

    private ProductDAO productDAO;

    @Autowired
    public WebshopController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/products/{productId}")
    public Product getAllProducts(@PathVariable("productId") int productId) {
        if (productDAO.getProduct(productId) == null) {
            throw new ProductNotFoundException("Product not found with id of " + productId);
        }
        return productDAO.getProduct(productId);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
    
}
