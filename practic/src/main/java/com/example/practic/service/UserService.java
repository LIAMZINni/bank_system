package com.example.practic.service;

import com.example.practic.dto.RegistrationUserDto;
import com.example.practic.model.Account;
import com.example.practic.model.Role;
import com.example.practic.model.User;
import com.example.practic.repozitory.RoleRepository;
import com.example.practic.repozitory.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Transactional
    public void saveUser(RegistrationUserDto userDto){
        Role role = roleRepository.findByRoleName("Role_User");
        User user=new User();
        Account account=new Account();
        account.setName(userDto.getFirstName()+"  "+userDto.getLastName());
        account.setBalance(null);

        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setRoles( Arrays.asList(role));
        user.setAccounts(List.of(account));

        account.setUser(user);

//        User user=new User(userDto.getUsername()
//                ,bCryptPasswordEncoder.encode(userDto.getPassword())
//                ,userDto.getFirstName(),userDto.getLastName()
//                ,userDto.getEmail(),userDto.getPhoneNumber(),
//        Arrays.asList(role));
//
//        Account account=new Account(user,userDto.getFirstName()+" "+userDto.getLastName(),new BigDecimal(0));
        userRepository.save(user);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
//        System.out.println(user.getEmail()+"   "+user.getPassword()+user.getRoles());
        if(user==null){
            throw new UsernameNotFoundException("Invalid password or login");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAurorization(user.getRoles()));

    }
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByEmail(authentication.getName());
    }



    private Collection<? extends GrantedAuthority> mapRolesToAurorization(Collection<Role> rols){
        return rols.stream().map(rols1->new SimpleGrantedAuthority(rols1.getRoleName())).collect(Collectors.toList());

    }
}
