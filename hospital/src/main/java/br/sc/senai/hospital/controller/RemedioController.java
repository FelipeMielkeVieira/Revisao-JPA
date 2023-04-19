package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Remedio;
import br.sc.senai.hospital.repository.RemedioRepository;
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
@RequestMapping("/remedio")
public class RemedioController {

    private RemedioRepository remedioRepository;

    @GetMapping
    public ResponseEntity<List<Remedio>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(remedioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Remedio> save(@RequestBody Remedio remedio) {
        return ResponseEntity.status(HttpStatus.OK).body(remedioRepository.save(remedio));
    }
}
