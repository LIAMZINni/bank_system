package com.example.practic.repozitory;

import com.example.practic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepozitory extends JpaRepository<Product,Integer> {

}
