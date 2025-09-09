package com.szentebalint.fullcrudapp.dao;

import com.szentebalint.fullcrudapp.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    @Override
    public void addProduct(Product product) {

        entityManager.persist(product);

    }
}
