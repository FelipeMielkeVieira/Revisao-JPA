package br.sc.senai.hospital.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "remedio")
@Data
public class Remedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;
}
