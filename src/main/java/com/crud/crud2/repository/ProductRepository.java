package com.crud.crud2.repository;

import com.crud.crud2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Integer>{


    Product findByName(String name);
}
