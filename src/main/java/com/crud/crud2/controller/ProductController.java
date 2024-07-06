package com.crud.crud2.controller;


import com.crud.crud2.entity.Product;
import com.crud.crud2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ProductController {

    @Autowired
    private ProductService service;


    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
    return  service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return  service.saveProducts(products);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProduct(){
        List<Product> list = service.getProduct();
         if(list.size() <= 0){
             return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
       return  ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/productById/{id}")
    public ResponseEntity<Product> findProductByID(@PathVariable int id){
        Product product =service.getProductById(id);
        //Checking the product lenghth1
        if(product ==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(product));
      }
    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }
     @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }




}
