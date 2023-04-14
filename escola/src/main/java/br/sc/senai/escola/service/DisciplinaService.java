package br.sc.senai.escola.service;

import br.sc.senai.escola.model.entities.Disciplina;
import br.sc.senai.escola.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findById(Long id) {
        return disciplinaRepository.findById(id);
    }

    public Boolean existsById(Long id) {
        return disciplinaRepository.existsById(id);
    }

    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void deleteById(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
