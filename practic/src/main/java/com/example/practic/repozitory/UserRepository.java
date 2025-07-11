package com.example.practic.repozitory;

import com.example.practic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< User,Long> {
    User findByEmail(String email);

    User findByPhoneNumber(String receiverPhoneNumber);


}
