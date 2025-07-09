package com.example.practic.service.transfer;

import com.example.practic.dto.TransferDto;
import com.example.practic.model.Account;
import com.example.practic.model.TypeTransaction;
import org.springframework.stereotype.Service;

@Service
public class TransferByOwnAccountService extends AbstractTransferService{

    @Override
    protected Account findReceiverAccount(TransferDto transferDto) {
        return accountRepository.findById(transferDto.getReceiverAccountId()).orElseThrow(() -> new RuntimeException("Счет получателя не найден"));
    }

    @Override
    protected TypeTransaction getTransactionType() {
        return TypeTransaction.BETWEEN_OWN_ACCOUNTS;
    }
}
