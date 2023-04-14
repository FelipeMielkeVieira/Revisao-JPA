package br.sc.senai.escola.controller;

import br.sc.senai.escola.model.dto.EscolaDTO;
import br.sc.senai.escola.model.entities.Escola;
import br.sc.senai.escola.service.EscolaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/escola")
public class EscolaController {

    private EscolaService escolaService;

    @GetMapping
    public ResponseEntity<List<Escola>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Escola> escolaOptional = escolaService.findById(id);
        if(escolaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Escola não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(escolaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Escola> save(@RequestBody @Valid EscolaDTO escolaDTO) {
        Escola escola = new Escola();
        BeanUtils.copyProperties(escolaDTO, escola);
        return ResponseEntity.status(HttpStatus.CREATED).body(escolaService.save(escola));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody @Valid EscolaDTO escolaDTO) {
        if(!escolaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Escola não encontrada!");
        }

        Escola escola = new Escola();
        BeanUtils.copyProperties(escolaDTO, escola);
        escola.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(escolaService.save(escola));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if(!escolaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Escola não encontrada!");
        }
        escolaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Escola deletada com sucesso!");
    }
}
