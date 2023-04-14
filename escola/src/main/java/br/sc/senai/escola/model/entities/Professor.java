package br.sc.senai.escola.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "professor")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 20)
    private String telefone;

    @ManyToOne
    @JsonIgnore
    private Escola escola;

    @ManyToMany(mappedBy = "listaDeProfessores")
    @JsonIgnore
    private List<Disciplina> listaDeDisciplinas;

    @ManyToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
