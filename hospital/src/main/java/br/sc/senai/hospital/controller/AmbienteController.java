package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Ambiente;
import br.sc.senai.hospital.repository.AmbienteRepository;
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
@RequestMapping("/ambiente")
public class AmbienteController {

    private AmbienteRepository ambienteRepository;

    @GetMapping
    public ResponseEntity<List<Ambiente>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ambienteRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Ambiente> save(@RequestBody Ambiente ambiente) {
        return ResponseEntity.status(HttpStatus.OK).body(ambienteRepository.save(ambiente));
    }
}
