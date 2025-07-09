//package com.example.practic;
//
//import com.example.practic.model.Account;
//import com.example.practic.repozitory.AccountRepository;
//import com.example.practic.service.transfer.TransferService;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//
//@SpringBootTest
//public class transferMoneyIntegration {
//    @MockBean
//    AccountRepository accountRepository;
//    @Autowired
//    TransferService transferService;
//
//    @Test
//    public void testTransactionIntegration(){
//        Account sender=new Account( 1L,"xyi", new BigDecimal(1000));
//        Account receiver =new Account(2L,"penis",new BigDecimal(228));
//       when(accountRepository.findById(sender.getId())).thenReturn(Optional.of(sender));
//       when(accountRepository.findById(receiver.getId())).thenReturn(Optional.of(receiver));
//       transferService.transferMoney(sender.getId(),receiver.getId(),new BigDecimal(100));
//       verify(accountRepository).save(ArgumentMatchers.refEq(new Account(sender.getId(),sender.getName(),new BigDecimal(900))));
//       verify(accountRepository).save(ArgumentMatchers.refEq(new Account(receiver.getId(),receiver.getName(),new BigDecimal(328))));
//
//
//    }
//
//
//
//}
