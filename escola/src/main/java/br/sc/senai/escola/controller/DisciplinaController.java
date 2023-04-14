package br.sc.senai.escola.controller;

import br.sc.senai.escola.model.dto.DisciplinaDTO;
import br.sc.senai.escola.model.entities.Disciplina;
import br.sc.senai.escola.service.DisciplinaService;
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
@RequestMapping("/disciplina")
public class DisciplinaController {

    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Disciplina> disciplinaOptional = disciplinaService.findById(id);
        if(disciplinaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaOptional.get());
    }

    @PostMapping
    public ResponseEntity<Disciplina> save(@RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.save(disciplina));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody @Valid DisciplinaDTO disciplinaDTO) {
        if(!disciplinaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada!");
        }

        Disciplina disciplina = new Disciplina();
        BeanUtils.copyProperties(disciplinaDTO, disciplina);
        disciplina.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.save(disciplina));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if(!disciplinaService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disciplina não encontrada!");
        }
        disciplinaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso!");
    }
}
