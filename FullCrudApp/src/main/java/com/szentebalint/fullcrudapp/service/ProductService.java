package com.szentebalint.fullcrudapp.service;

import com.szentebalint.fullcrudapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(int productId);

    Product updateProduct(int id, String field, String value);

    void deleteProduct(int id);

}
