package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Paciente;
import br.sc.senai.hospital.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/paciente")
public class PacienteController {

    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.save(paciente));
    }
}
