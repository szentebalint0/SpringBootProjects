package com.szentebalint.fullcrudapp.service;

import com.szentebalint.fullcrudapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product getProductById(int productId);

    Product save(Product product);

    Product patchProduct(Product product);

    void deleteById(int id);

}
