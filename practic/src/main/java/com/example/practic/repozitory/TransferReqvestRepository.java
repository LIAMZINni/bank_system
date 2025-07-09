package com.example.practic.repozitory;

import com.example.practic.model.TransferReqvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferReqvestRepository extends JpaRepository<TransferReqvest,Long> {
}
