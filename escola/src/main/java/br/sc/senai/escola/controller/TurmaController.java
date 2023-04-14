package br.sc.senai.escola.controller;

import br.sc.senai.escola.model.dto.TurmaDTO;
import br.sc.senai.escola.model.entities.Turma;
import br.sc.senai.escola.service.TurmaService;
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
@RequestMapping("/turma")
public class TurmaController {

    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Turma> turmaOptional = turmaService.findById(id);
        if(turmaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(turmaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody @Valid TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.save(turma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody @Valid TurmaDTO turmaDTO) {
        if(!turmaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada!");
        }

        Turma turma = new Turma();
        BeanUtils.copyProperties(turmaDTO, turma);
        turma.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(turmaService.save(turma));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if(!turmaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma não encontrada!");
        }
        turmaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Turma deletada com sucesso!");
    }
}
