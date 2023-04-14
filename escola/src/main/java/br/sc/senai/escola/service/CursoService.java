package br.sc.senai.escola.service;

import br.sc.senai.escola.model.entities.Curso;
import br.sc.senai.escola.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    public Boolean existsById(Long id) {
        return cursoRepository.existsById(id);
    }

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
