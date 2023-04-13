package br.sc.senai.escola.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EnderecoDTO {

    @NotNull
    private String rua;

    @NotNull @Positive
    private Integer numero;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String bairro;

    @NotNull @Positive @Size(min = 8, max = 8)
    private Long cep;
}
