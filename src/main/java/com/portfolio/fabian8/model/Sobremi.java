package com.portfolio.fabian8.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "sobremi")
public class Sobremi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Column(name = "sobremi")
    @Getter @Setter
    private String sobremi;
}
