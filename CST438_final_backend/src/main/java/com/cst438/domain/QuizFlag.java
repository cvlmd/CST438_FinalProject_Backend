package com.cst438.domain;


import javax.persistence.*;

@Entity
@Table(name = "flags")
public class QuizFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String imageUrl;

    // Assume more fields, standard getters and setters
}
