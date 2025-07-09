package com.example.practic.service;

import com.example.practic.model.Product;
import com.example.practic.repozitory.ProductRepozitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepozitory productRepozitory;





    public  void addProduct(Product product){
        productRepozitory.save(product);


    }
    public List<Product> getProducts(){

        return productRepozitory.findAll();
    }
}
