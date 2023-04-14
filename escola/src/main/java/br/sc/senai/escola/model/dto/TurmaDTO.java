package br.sc.senai.escola.model.dto;

import br.sc.senai.escola.model.entities.Aluno;
import br.sc.senai.escola.model.entities.Escola;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class TurmaDTO {

    @NotNull
    private String nome;

    private Escola escola;

    private List<Aluno> listaDeAlunos;
}
