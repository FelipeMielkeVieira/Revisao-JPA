package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Doenca;
import br.sc.senai.hospital.repository.DoencaRepository;
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
@RequestMapping("/doenca")
public class DoencaController {

    private DoencaRepository doencaRepository;

    @GetMapping
    public ResponseEntity<List<Doenca>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(doencaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Doenca> save(@RequestBody Doenca doenca) {
        return ResponseEntity.status(HttpStatus.OK).body(doencaRepository.save(doenca));
    }
}
