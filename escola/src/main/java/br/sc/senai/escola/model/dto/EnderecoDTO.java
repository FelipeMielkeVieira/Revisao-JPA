package br.sc.senai.escola.model.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
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

    @NotNull @Positive @Min(10000000) @Max(99999999)
    private Long cep;
}
