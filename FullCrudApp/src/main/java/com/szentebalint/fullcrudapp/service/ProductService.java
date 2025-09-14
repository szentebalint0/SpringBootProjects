package com.szentebalint.fullcrudapp.service;

import com.szentebalint.fullcrudapp.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> findAll();

    Product getProductById(int productId);

    Product save(Product product);

    Product patch(Product product, Map<String, Object> patchPayload);

    void deleteById(int id);

}
