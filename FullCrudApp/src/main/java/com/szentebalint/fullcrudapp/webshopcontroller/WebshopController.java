package com.szentebalint.fullcrudapp.webshopcontroller;

import com.szentebalint.fullcrudapp.dao.ProductDAO;
import com.szentebalint.fullcrudapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/database")
public class WebshopController {

    private ProductDAO productDAO;

    @Autowired
    public WebshopController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/product/{productId}")
    public Product getAllProducts(@PathVariable("productId") int productId) {
        return productDAO.getProduct(productId);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }





}
