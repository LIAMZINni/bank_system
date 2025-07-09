package com.example.practic.controllers;

import com.example.practic.model.Product;
import com.example.practic.repozitory.ProductRepozitory;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Service
@RestController

public class RestProductService {
    @Autowired
    private ProductRepozitory productRepozitory;
    @RequestMapping("/rest")
    public List<Product> addProduct(@RequestBody Product product){
        productRepozitory.save(product);
        return reternProducts();

    }
    @GetMapping
    public List<Product> reternProducts(){
        return productRepozitory.findAll();
    }

}
