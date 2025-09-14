package com.szentebalint.fullcrudapp.service;

import com.szentebalint.fullcrudapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int productId);

    Product saveProduct(Product product);

    Product patchProduct(Product product);

    void deleteProduct(int id);

}
