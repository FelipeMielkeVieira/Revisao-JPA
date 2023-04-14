package br.sc.senai.escola.controller;

import br.sc.senai.escola.model.dto.AlunoDTO;
import br.sc.senai.escola.model.entities.Aluno;
import br.sc.senai.escola.service.AlunoService;
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
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = alunoService.findById(id);
        if(alunoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoOptional.get());
    }

    @PostMapping
    public ResponseEntity<Aluno> save(@RequestBody @Valid AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id,
                                         @RequestBody @Valid AlunoDTO alunoDTO) {
        if(!alunoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }

        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(alunoDTO, aluno);
        aluno.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(aluno));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
        if(!alunoService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
        alunoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
    }
}
