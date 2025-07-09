package com.example.practic.repozitory;

import com.example.practic.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
    Card findByCardNumber(String receiverCardNumber);
}
