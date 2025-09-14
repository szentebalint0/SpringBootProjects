package com.szentebalint.fullcrudapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.szentebalint.fullcrudapp.controller.exceptions.ProductNotFoundException;
import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ObjectMapper objectMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,  ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
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
    public Product patch(Product product, Map<String, Object> patchPayload) {

        Product patchedProduct = apply(patchPayload, product);

        return productRepository.save(patchedProduct);
    }

    @Override
    public void deleteById(int id) {

        productRepository.deleteById(id);
    }

    // applying partial updates with object mapping
    private Product apply(Map<String, Object> patchPayload, Product product) {

        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);

        ObjectNode productNode  = objectMapper.convertValue(product, ObjectNode.class);

        productNode.setAll(patchNode);

        return objectMapper.convertValue(productNode, Product.class);

    }
}
