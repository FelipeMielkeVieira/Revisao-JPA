package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Medico;
import br.sc.senai.hospital.repository.MedicoRepository;
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
@RequestMapping("/medico")
public class MedicoController {

    private MedicoRepository medicoRepository;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medico));
    }
}
