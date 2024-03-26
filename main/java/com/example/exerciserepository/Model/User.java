package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class User {

    //User class: ID , name , username , password, email ,role, age

    //ID :
   //Cannot be null
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotEmpty(message = "id can not null")
    private  Integer id;

    //name :
    //Cannot be null
    //Length more than 4

    @NotEmpty(message = "Name can not null")
    @Size(min = 4,message = "Name length more than 4")
    @Column(columnDefinition = "varchar(30) not null ")
    private String name;

   // username :
   //Cannot be null
   //Length more than 4
   //must be unique

    @NotEmpty(message = "username can not null")
    @Size(min = 4,message = "username length more than 4")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String username;


    // password :
   // Cannot be null
    @NotEmpty(message = "password can not null")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

   //email :
   //Cannot be null
   // must be valid email
   // must be unique
    @NotEmpty(message = "email can not null")
    @Email(message = "email must be valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    //role :
   //Cannot be null
   //must be user or admin only
    @NotEmpty(message = "role can not null")
    @Pattern(regexp = "^(user|admin)$")
    @Column(columnDefinition = "varchar(5) not null check(role='user' or role='admin')")
    private String role;

    // age
    // Cannot be null
   // must be integer
    @NotNull(message ="age cannot be null")
    @Positive
    @Column(columnDefinition = "int  not null ")
    private Integer age;



}
