package br.sc.senai.escola.controller;

import br.sc.senai.escola.model.dto.CursoDTO;
import br.sc.senai.escola.model.entities.Curso;
import br.sc.senai.escola.service.CursoService;
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
@RequestMapping("/curso")
public class CursoController {

    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Curso> cursoOptional = cursoService.findById(id);
        if(cursoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cursoOptional.get());
    }

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody @Valid CursoDTO cursoDTO) {
        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody @Valid CursoDTO cursoDTO) {
        if(!cursoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }

        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoDTO, curso);
        curso.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.save(curso));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if(!cursoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
        }
        cursoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso!");
    }
}
