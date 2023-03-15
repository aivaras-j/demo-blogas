package com.example.demoblogas.blogSecurity.User;


import com.example.demoblogas.blogSecurity.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @NonNull
    @Column(nullable = false, length = 100)
    private String password;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Role role;

}
