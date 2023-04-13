package br.sc.senai.escola.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "curso")
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany
    @JoinColumn(name = "id_curso")
    private List<Disciplina> listaDeDisciplinas;
}
