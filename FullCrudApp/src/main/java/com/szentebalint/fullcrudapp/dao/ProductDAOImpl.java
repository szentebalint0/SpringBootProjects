package com.szentebalint.fullcrudapp.dao;

import com.szentebalint.fullcrudapp.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {

        entityManager.persist(product);
        System.out.println("Product added successfully with id of: " + product.getProductId());

    }
}
