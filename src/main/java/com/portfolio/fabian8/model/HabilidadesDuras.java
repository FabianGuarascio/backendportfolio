package com.portfolio.fabian8.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "habilidades_duras")
public class HabilidadesDuras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Column(name = "habilidad")
    @Getter @Setter
    private String habilidad;

    @Column(name = "dominio")
    @Getter @Setter
    private String dominio;


}
