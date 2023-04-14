package br.sc.senai.escola.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "turma")
@Data
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "escola_id")
    private Escola escola;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Aluno> listaDeAlunos;
}
