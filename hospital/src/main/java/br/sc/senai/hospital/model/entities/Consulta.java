package br.sc.senai.hospital.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "consulta")
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL)
    private Diagnostico diagnostico;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Ambiente ambiente;

    @ManyToMany
    private List<Remedio> listaDeRemedios;

    @OneToOne(mappedBy = "consulta", cascade = CascadeType.ALL)
    private Atestado atestado;
}
