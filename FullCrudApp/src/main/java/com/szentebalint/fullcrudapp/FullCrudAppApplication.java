package com.szentebalint.fullcrudapp;

import com.szentebalint.fullcrudapp.entity.Product;
import com.szentebalint.fullcrudapp.repository.ProductDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FullCrudAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullCrudAppApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(ProductDAO productDAO) {
//
//        return runner -> getAllProducts(productDAO);
//
//    }

    private void saveProduct(ProductDAO productDAO) {

        Product product = new Product("notebook", "lenovo", 359.99);
        productDAO.addProduct(product);

    }

    private void fillTable(ProductDAO productDAO) {

        Product p1  = new Product("Laptop", "Dell", 899.99);
        Product p2  = new Product("Smartphone", "Samsung", 699.99);
        Product p3  = new Product("Headphones", "Sony", 129.99);
        Product p4  = new Product("Monitor", "LG", 249.99);
        Product p5  = new Product("Keyboard", "Logitech", 59.99);
        Product p6  = new Product("Mouse", "Razer", 49.99);
        Product p7  = new Product("Smartwatch", "Apple", 399.99);
        Product p8  = new Product("Tablet", "Lenovo", 329.99);
        Product p9  = new Product("Printer", "HP", 199.99);
        Product p10 = new Product("Camera", "Canon", 599.99);
        Product p11 = new Product("Speaker", "JBL", 149.99);
        Product p12 = new Product("Router", "TP-Link", 89.99);
        Product p13 = new Product("SSD", "Samsung", 129.99);
        Product p14 = new Product("Hard Drive", "Seagate", 99.99);
        Product p15 = new Product("Graphics Card", "NVIDIA", 499.99);
        Product p16 = new Product("Processor", "Intel", 299.99);
        Product p17 = new Product("RAM", "Corsair", 159.99);
        Product p18 = new Product("Power Supply", "EVGA", 119.99);
        Product p19 = new Product("Motherboard", "ASUS", 249.99);
        Product p20 = new Product("Cooling Fan", "Noctua", 39.99);

        Product[] products = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,
                p11,p12,p13,p14,p15,p16,p17,p18,p19,p20};

        productDAO.addProductByArray(products);
    }

    private void getProduct(ProductDAO productDAO) {

        System.out.println(productDAO.getProduct(2));

    }

    private void getAllProducts(ProductDAO productDAO) {
        List<Product> products = productDAO.getAllProducts();

        for (Product product : products) {
            System.out.println(product);
        }
    }



    private void deleteProduct(ProductDAO productDAO) {
        productDAO.deleteProduct(2);
    }

    private void clearTable(ProductDAO productDAO) {
        productDAO.deleteAllProducts();
    }
}
