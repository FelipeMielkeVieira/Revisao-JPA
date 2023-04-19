package br.sc.senai.hospital.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "diagnostico")
@Data
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000)
    private String diagnostico;

    @OneToOne
    private Consulta consulta;

    @OneToMany
    private List<Doenca> listaDeDoencas;
}
