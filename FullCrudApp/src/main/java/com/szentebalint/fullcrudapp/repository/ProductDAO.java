package com.szentebalint.fullcrudapp.repository;

import com.szentebalint.fullcrudapp.entity.Product;

import java.util.List;

public interface ProductDAO {

    void  addProduct(Product product);

    void addProductByArray(Product[] products);

    Product getProduct(int productId);

    List<Product> getAllProducts();

    void updateProductById(int id, String field, String value);

    void deleteProduct(int productId);

    void deleteAllProducts();

}
