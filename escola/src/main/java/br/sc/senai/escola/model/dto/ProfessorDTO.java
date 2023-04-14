package br.sc.senai.escola.model.dto;

import br.sc.senai.escola.model.entities.Disciplina;
import br.sc.senai.escola.model.entities.Endereco;
import br.sc.senai.escola.model.entities.Escola;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class ProfessorDTO {

    @NotNull
    private String nome;

    @NotNull @Email
    private String email;

    @NotNull
    private String telefone;

    private Escola escola;

    private List<Disciplina> listaDeDisciplinas;

    private Endereco endereco;
}
