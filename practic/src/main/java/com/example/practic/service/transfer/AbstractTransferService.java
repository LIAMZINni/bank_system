package com.example.practic.service.transfer;

import com.example.practic.dto.TransferDto;
import com.example.practic.model.Account;
import com.example.practic.model.Currency;
import com.example.practic.model.Transaction;
import com.example.practic.model.TypeTransaction;
import com.example.practic.repozitory.AccountRepository;
import com.example.practic.repozitory.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public abstract class AbstractTransferService implements TransferService{
    @Autowired
    protected AccountRepository accountRepository;

    @Autowired
    protected TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void transfer(TransferDto transferDto) {
        // Валидация DTO
        validateTransferDto(transferDto);

        // Поиск счета отправителя
        Account senderAccount = findSenderAccount(transferDto.getSenderAccountId());

        // Поиск счета получателя (реализуется в дочерних классах)
        Account receiverAccount = findReceiverAccount(transferDto);

        // Проверка баланса
        validateBalance(senderAccount, transferDto.getAmount());

        // Выполнение перевода
        performTransfer(senderAccount, receiverAccount, transferDto.getAmount());

        // Запись транзакции
        recordTransaction(senderAccount, receiverAccount, transferDto, getTransactionType());
    }

    protected void validateTransferDto(TransferDto transferDto) {
        if (transferDto.getSenderAccountId() == null) {
            throw new RuntimeException("Не указан счет отправителя");
        }
        if (transferDto.getAmount() == null || transferDto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Неверная сумма перевода");
        }
    }

    protected Account findSenderAccount(Long senderAccountId) {
        return accountRepository.findById(senderAccountId)
                .orElseThrow(() -> new RuntimeException("Счет отправителя не найден"));
    }

    protected void validateBalance(Account senderAccount, BigDecimal amount) {
        if (senderAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Недостаточно средств на счете");
        }
    }

    protected void performTransfer(Account senderAccount, Account receiverAccount, BigDecimal amount) {
        senderAccount.setBalance(senderAccount.getBalance().subtract(amount));
        receiverAccount.setBalance(receiverAccount.getBalance().add(amount));
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }

    protected void recordTransaction(Account senderAccount, Account receiverAccount, TransferDto transferDto, TypeTransaction type) {
        Transaction transaction = new Transaction(
                senderAccount,
                receiverAccount,
                type,
                transferDto.getAmount(),
                Currency.RUB,
                transferDto.getDescription()
        );
        transactionRepository.save(transaction);
    }

    // Абстрактные методы, которые должны быть реализованы в дочерних классах
    protected abstract Account findReceiverAccount(TransferDto transferDto);
    protected abstract TypeTransaction getTransactionType();
}
