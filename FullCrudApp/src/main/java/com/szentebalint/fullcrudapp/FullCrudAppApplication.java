package com.szentebalint.fullcrudapp;

import com.szentebalint.fullcrudapp.dao.ProductDAO;
import com.szentebalint.fullcrudapp.dao.ProductDAOImpl;
import com.szentebalint.fullcrudapp.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FullCrudAppApplication {

    private final ProductDAOImpl productDAOImpl;

    public FullCrudAppApplication(ProductDAOImpl productDAOImpl) {
        this.productDAOImpl = productDAOImpl;
    }

    public static void main(String[] args) {
        SpringApplication.run(FullCrudAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ProductDAO productDAO) {

        return runner -> saveProduct(productDAO);

    }

    private void saveProduct(ProductDAO productDAO) {

        Product product = new Product("notebook", "lenovo", 359.99);
        productDAOImpl.addProduct(product);

    }


}
