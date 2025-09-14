package com.szentebalint.fullcrudapp.service;

import com.szentebalint.fullcrudapp.controller.exceptions.ProductNotFoundException;
import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {

        Optional<Product> optional = productRepository.findById(productId);

        if (optional.isPresent()) {
            return optional.get();
        }
        else{
            throw new ProductNotFoundException("Product not found with id " + productId);
        }
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Product patchProduct(Product product) {
        return null;
    }

    @Override
    public void deleteById(int id) {

        productRepository.deleteById(id);
    }
}
