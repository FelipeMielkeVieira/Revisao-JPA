package br.sc.senai.hospital.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "endereco")
@Data
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String pais;

    @Column(length = 50)
    private String estado;

    @Column(length = 100, nullable = false)
    private String rua;

    @Column
    private Integer numero;
}
