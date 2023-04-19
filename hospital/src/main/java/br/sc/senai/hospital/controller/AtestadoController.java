package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Atestado;
import br.sc.senai.hospital.repository.AtestadoRepository;
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
@RequestMapping("/atestado")
public class AtestadoController {

    private AtestadoRepository atestadoRepository;

    @GetMapping
    public ResponseEntity<List<Atestado>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(atestadoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Atestado> save(@RequestBody Atestado atestado) {
        return ResponseEntity.status(HttpStatus.OK).body(atestadoRepository.save(atestado));
    }
}
