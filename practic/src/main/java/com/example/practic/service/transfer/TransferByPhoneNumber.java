package com.example.practic.service.transfer;

import com.example.practic.dto.TransferDto;
import com.example.practic.model.Account;
import com.example.practic.model.TypeTransaction;
import com.example.practic.model.User;
import com.example.practic.repozitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferByPhoneNumber extends AbstractTransferService{

    @Autowired
    private UserRepository userRepository;

    @Override
    protected Account findReceiverAccount(TransferDto transferDto) {
        User receiverUser = userRepository.findByPhoneNumber(transferDto.getReceiverPhoneNumber());
                if(receiverUser==null){
                    throw  new RuntimeException("Пользователь с таким номером телефона не найден");
                }

//        return  receiverUser.getAccounts().stream()
//                .filter(account -> account.getId()==(transferDto.getReceiverAccountId()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Счет получателя не найден"));
//        return receiverUser.getAccounts().stream()
//                .filter(account -> transferDto.getReceiverAccountId() != null &&
//                        transferDto.getReceiverAccountId().equals(account.getId()))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Счет получателя не найден"));



        Long receiverAccountId = transferDto.getReceiverAccountId();
        // Поиск счета
        return receiverUser.getAccounts().stream()
                .filter(account -> receiverAccountId.equals(account.getId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Счет с ID " + receiverAccountId + " не найден у пользователя"));

    }

    @Override
    protected TypeTransaction getTransactionType() {
        return TypeTransaction.BY_PHONE_NUMBER;
    }
}
