package br.sc.senai.hospital.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ambiente")
@Data
public class Ambiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column
    private Integer numero;

    @ManyToOne
    @JsonIgnore
    private Hospital hospital;
}
