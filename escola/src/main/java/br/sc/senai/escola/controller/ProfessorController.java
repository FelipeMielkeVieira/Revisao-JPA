package br.sc.senai.escola.controller;

import br.sc.senai.escola.model.dto.ProfessorDTO;
import br.sc.senai.escola.model.entities.Professor;
import br.sc.senai.escola.service.ProfessorService;
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
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Professor> professorOptional = professorService.findById(id);
        if(professorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(professorOptional.get());
    }

    @PostMapping
    public ResponseEntity<Professor> save(@RequestBody @Valid ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.save(professor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody @Valid ProfessorDTO professorDTO) {
        if(!professorService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
        }

        Professor professor = new Professor();
        BeanUtils.copyProperties(professorDTO, professor);
        professor.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(professorService.save(professor));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if(!professorService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
        }
        professorService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso!");
    }
}
