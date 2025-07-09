package com.example.practic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long userId;
    private String username;

    private String password;
    @NotBlank(message = "cant be null")
    private String firstName;
    @NotBlank(message = "cant be null")
    private String lastName;
    @Email
    private String email;
    @NotNull(message = "number cant be null")
    @Size(min = 10,max = 11,message = "error")
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Column(name = "last_login")
    private Timestamp lastLogin;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Account> accounts=new ArrayList<>();

//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
//    private Account account;

    public User(String username, String password, String firstName, String lastName, String email, String phoneNumber, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public User(String username, String password, String firstName, String lastName, String email, String phoneNumber, Account account) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        accounts.add(account);
    }

}
