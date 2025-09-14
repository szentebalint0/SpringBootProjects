package com.szentebalint.fullcrudapp.repository;

import com.szentebalint.fullcrudapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,  Integer> {

}
