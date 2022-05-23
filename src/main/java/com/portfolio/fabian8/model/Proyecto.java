package com.portfolio.fabian8.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "proyectos")
@ToString @EqualsAndHashCode
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter
    private Long id;

    @Getter @Setter @Column(name = "titulo")
    private String titulo ;

    @Getter @Setter @Column(name = "sub_titulo")
    private String sub_titulo ;

    @Getter @Setter @Column(name = "descripcion")
    private String descripcion ;

    @Getter @Setter @Column(name = "url_imagen")
    private String url_imagen ;

    @Getter @Setter @Column(name = "url_proyecto")
    private String url_proyecto ;

}
