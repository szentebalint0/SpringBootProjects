package com.szentebalint.fullcrudapp.repository;

import com.szentebalint.fullcrudapp.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addProduct(Product product) {

        entityManager.persist(product);
        System.out.println("Product added successfully with id of: " + product.getProductId());

    }

    @Override
    public void addProductByArray(Product[] products) {

        for  (Product product : products) {
            entityManager.persist(product);
        }

    }

    @Override
    public Product getProduct(int productId) {
        return  entityManager.find(Product.class, productId);
    }

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    @Override
    public void updateProductById(int id, String field, String value) {

        Product temp = this.getProduct(id);

        switch (field) {
            case "name" ->  temp.setProductName(value);
            case "manufacturer" ->  temp.setManufacturer(value);
            case "price" ->  temp.setPrice(Double.parseDouble(value));
            default -> {
                System.out.println("Invalid field");
                return;
            }
        }

        entityManager.merge(temp);

        System.out.println("Product updated successfully with id of: " + temp.getProductId());
    }

    @Override
    public void deleteProduct(int productId) {

        entityManager.remove(getProduct(productId));
        System.out.println("Product deleted successfully with id of: " + productId);

    }

    @Override
    public void deleteAllProducts() {

        entityManager.createQuery("DELETE FROM Product").executeUpdate();

        System.out.println("All products deleted successfully");

    }

}
