package br.sc.senai.escola.model.dto;

import br.sc.senai.escola.model.entities.Curso;
import br.sc.senai.escola.model.entities.Endereco;
import br.sc.senai.escola.model.entities.Professor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class EscolaDTO {

    @NotNull
    private String nome;

    @NotNull
    private Endereco endereco;

    @NotNull @Email
    private String email;

    private List<Professor> listaDeProfessores;

    private List<Curso> listaDeCursos;
}
