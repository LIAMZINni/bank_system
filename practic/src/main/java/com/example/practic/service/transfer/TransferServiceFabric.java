package com.example.practic.service.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceFabric {
    @Autowired
    private TransferByCardService cardTransferService;

    @Autowired
    private TransferByPhoneNumber phoneTransferService;

    @Autowired
    private TransferByOwnAccountService ownAccountTransferService;

    public TransferService getTransferService(String transferType) {
        switch (transferType) {
            case "card":
                return cardTransferService;
            case "phone":
                return phoneTransferService;
            case "ownAccount":
                return ownAccountTransferService;
            default:
                throw new IllegalArgumentException("Неизвестный тип перевода: " + transferType);
        }
    }
}
