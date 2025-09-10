package com.szentebalint.fullcrudapp.webshopcontroller;

import com.szentebalint.fullcrudapp.dao.ProductDAO;
import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.webshopcontroller.exceptions.ProductError;
import com.szentebalint.fullcrudapp.webshopcontroller.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler
    public ResponseEntity<ProductError> handleException(ProductNotFoundException exc) {

        ProductError error = new ProductError();
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<ProductError> handleAll(Exception exc) {

        ProductError error = new ProductError();
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
    
}
