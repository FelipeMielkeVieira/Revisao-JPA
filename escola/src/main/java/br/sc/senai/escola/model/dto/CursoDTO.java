package br.sc.senai.escola.model.dto;

import br.sc.senai.escola.model.entities.Disciplina;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class CursoDTO {

    @NotNull
    private String nome;

    private List<Disciplina> listaDeDisciplinas;
}
