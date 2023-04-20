package br.sc.senai.hospital.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/teste")
public class TesteController {

    @GetMapping
    public ResponseEntity<Integer> retornaNumero() {
        return ResponseEntity.status(HttpStatus.OK).body(2);
    }
}
