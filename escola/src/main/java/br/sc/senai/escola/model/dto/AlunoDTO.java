package br.sc.senai.escola.model.dto;

import br.sc.senai.escola.model.entities.Endereco;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AlunoDTO {

    @NotNull
    private String nome;

    @NotNull @Email
    private String email;

    @NotNull
    private String telefone;

    @NotNull
    private Endereco endereco;
}
