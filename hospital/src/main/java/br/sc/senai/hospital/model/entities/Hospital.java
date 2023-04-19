package br.sc.senai.hospital.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hospital")
@Data
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @OneToMany
    @JoinColumn(name = "hospital_id")
    private List<Medico> listaDeMedicos;

    @OneToMany
    @JoinColumn(name = "hospital_id")
    private List<Paciente> listaDePacientes;

    @OneToMany
    @JoinColumn(name = "hospital_id")
    private List<Consulta> listaDeConsultas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Ambiente> listaDeAmbientes;
}
