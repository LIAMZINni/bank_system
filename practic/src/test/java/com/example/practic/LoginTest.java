//package com.example.practic;
//
//import com.example.practic.controllers.LoginController;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.ui.Model;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.verify;
//
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//public class LoginTest {
//    @Mock
//    LoginProcessor loginProcessor;
//    @Mock
//    Model model;
//    @InjectMocks
//    LoginController loginController;
//    @Test
//    @DisplayName("login test success")
//    public void testLoginSuccess(){
//    given(loginProcessor.logIn("name","pas")).willReturn(true);
//    String result= loginController.loginPost("name","pas",model);
//    assertEquals("redirect:/product",result);
//    verify(model).addAttribute("message","You are loggin in");
//
//    }
//    @Test
//    @DisplayName("login test error")
//    public void testLoginError(){
//        given(loginProcessor.logIn("name","pas")).willReturn(false);
//        String result=loginController.loginPost("name","pas",model);
//        assertEquals("login.html",result);
//        verify(model).addAttribute("message","error");
//
//    }
//
//
//}
