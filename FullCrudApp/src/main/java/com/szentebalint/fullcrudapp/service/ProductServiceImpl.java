package com.szentebalint.fullcrudapp.service;

import com.szentebalint.fullcrudapp.repository.ProductDAO;
import com.szentebalint.fullcrudapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int productId) {
        return productDAO.getProduct(productId);
    }
}
