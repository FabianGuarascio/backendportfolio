package com.portfolio.fabian8.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;



}
