package com.hcld2.jwtdemo.entity;

import ch.qos.logback.core.net.SMTPAppenderBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
//@Setter
//@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;


    public User(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
    }


}
