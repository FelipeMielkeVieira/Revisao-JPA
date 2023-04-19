package br.sc.senai.hospital.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "doenca")
@Data
public class Doenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "listaDeDoencas")
    @JsonIgnore
    private List<Paciente> listaDePacientes;
}
