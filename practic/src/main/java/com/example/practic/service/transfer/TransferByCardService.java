package com.example.practic.service.transfer;

import com.example.practic.dto.TransferDto;
import com.example.practic.model.*;
import com.example.practic.repozitory.AccountRepository;
import com.example.practic.repozitory.CardRepository;
import com.example.practic.repozitory.TransactionRepository;
import com.example.practic.repozitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferByCardService extends AbstractTransferService {
    @Autowired
    CardRepository cardRepository;
    @Override
    protected Account findReceiverAccount(TransferDto transferDto) {
        Card receiverCard=cardRepository.findByCardNumber(transferDto.getReceiverCardNumber());
        if(receiverCard==null){
            throw new RuntimeException("Карта получателя не найдена");
        }

        return receiverCard.getAccount();
    }

    @Override
    protected TypeTransaction getTransactionType() {
        return TypeTransaction.BY_CARD;
    }

//    @Autowired
//    AccountRepository accountRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    CardRepository cardRepository;
//
//    @Autowired
//    TransactionRepository transactionRepository;
//
//    @Override
//    @Transactional
//    public void transfer(TransferDto transferDto) {
//
//
//        Account senderAccount = accountRepository.findById(transferDto.getSenderAccountId())
//                .orElseThrow(() -> new RuntimeException("Счет отправителя не найден"));
//
//        // Находим карту получателя (если перевод по номеру карты)
//        Card receiverCard = cardRepository.findByCardNumber(transferDto.getReceiverCardNumber());
//        if (receiverCard == null) {
//            throw new RuntimeException("Карта получателя не найдена");
//        }
//
//        // Получаем счет получателя
//        Account receiverAccount = receiverCard.getAccount();
//
//        // Проверяем баланс отправителя
//        if (senderAccount.getBalance().compareTo(transferDto.getAmount()) < 0 ) {
//            throw new RuntimeException("Недостаточно средств на счете");
//        }
//
//        // Выполняем перевод
//        senderAccount.setBalance(senderAccount.getBalance().subtract(transferDto.getAmount()));
//        receiverAccount.setBalance(receiverAccount.getBalance().add(transferDto.getAmount()));
//
//        // Сохраняем изменения
//        accountRepository.save(senderAccount);
//        accountRepository.save(receiverAccount);
//        // Записываем транзакции
//
//        Transaction transaction =new Transaction(senderAccount,receiverAccount, TypeTransaction.BY_CARD,transferDto.getAmount(), Currency.RUB,transferDto.getDescription());
//        transactionRepository.save(transaction);
//
//    }


}
