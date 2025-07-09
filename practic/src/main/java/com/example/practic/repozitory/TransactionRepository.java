package com.example.practic.repozitory;

import com.example.practic.model.Account;
import com.example.practic.model.Transaction;
import com.example.practic.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
//    @Query("SELECT t FROM Transaction t WHERE t.account.user.id = :userId ORDER BY t.timestamp DESC")
//    List<Transaction> findByUserId(@Param("userId") Long userId);

    List<Transaction> findByFromAccountUserOrToAccountUserOrderByCreatedAtDesc(User fromUser, User toUser);
}
