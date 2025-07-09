package com.example.practic.service.transfer;

import com.example.practic.dto.TransferDto;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {
    void transfer(TransferDto transferDto);
}