package br.sc.senai.hospital.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "atestado")
@Data
public class Atestado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer dias;

    @OneToOne
    @JsonIgnore
    private Consulta consulta;
}
