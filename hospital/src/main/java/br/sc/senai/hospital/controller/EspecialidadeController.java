package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Especialidade;
import br.sc.senai.hospital.repository.EspecialidadeRepository;
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
@RequestMapping("/especialidade")
public class EspecialidadeController {

    private EspecialidadeRepository especialidadeRepository;

    @GetMapping
    public ResponseEntity<List<Especialidade>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Especialidade> save(@RequestBody Especialidade especialidade) {
        return ResponseEntity.status(HttpStatus.OK).body(especialidadeRepository.save(especialidade));
    }
}
