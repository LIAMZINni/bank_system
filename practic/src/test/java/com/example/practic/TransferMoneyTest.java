//package com.example.practic;
//
//import com.example.practic.model.Account;
//import com.example.practic.repozitory.AccountRepository;
//import com.example.practic.service.transfer.TransferService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//public class TransferMoneyTest {
//    @Mock
//    AccountRepository accountRepository;
//    @InjectMocks
//    TransferService transferService;
//
//    @Test
//    @DisplayName("transfer money")
//    public void transferMoneyFlow(){
//
//
//
//        Account sender=new Account( 1L,"xyi", new BigDecimal(1000));
//        Account receiver =new Account(2L,"penis",new BigDecimal(228));
//
//        given(accountRepository.findById(sender.getId()))
//                .willReturn(Optional.of(sender));
//
//        given(accountRepository.findById(receiver.getId()))
//                .willReturn(Optional.of(receiver));
//
//        transferService.transferMoney(sender.getId(),receiver.getId(),new BigDecimal(20));
//        verify(accountRepository).save(ArgumentMatchers.refEq((new Account(sender.getId(),sender.getName(),new BigDecimal(980)))));
//        verify(accountRepository).save(ArgumentMatchers.refEq(new Account(receiver.getId(),receiver.getName(),new BigDecimal(248))));
//    }
//
//}
