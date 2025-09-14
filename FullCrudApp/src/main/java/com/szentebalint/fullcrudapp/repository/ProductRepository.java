package com.szentebalint.fullcrudapp.repository;

import com.szentebalint.fullcrudapp.entity.Product;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product,  Integer> {

}
