package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Diagnostico;
import br.sc.senai.hospital.repository.DiagnosticoRepository;
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
@RequestMapping("/diagnostico")
public class DiagnosticoController {

    private DiagnosticoRepository diagnosticoRepository;

    @GetMapping
    public ResponseEntity<List<Diagnostico>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(diagnosticoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Diagnostico> save(@RequestBody Diagnostico diagnostico) {
        return ResponseEntity.status(HttpStatus.OK).body(diagnosticoRepository.save(diagnostico));
    }
}
