package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Endereco;
import br.sc.senai.hospital.repository.EnderecoRepository;
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
@RequestMapping("/endereco")
public class EnderecoController {

    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoRepository.save(endereco));
    }
}
