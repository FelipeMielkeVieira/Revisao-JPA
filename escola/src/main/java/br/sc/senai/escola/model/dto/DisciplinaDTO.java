package br.sc.senai.escola.model.dto;

import br.sc.senai.escola.model.entities.Professor;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class DisciplinaDTO {

    @NotNull
    private String nome;

    private List<Professor> listaDeProfessores;
}
