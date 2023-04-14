package br.sc.senai.escola.service;

import br.sc.senai.escola.model.entities.Turma;
import br.sc.senai.escola.repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Optional<Turma> findById(Long id) {
        return turmaRepository.findById(id);
    }

    public Boolean existsById(Long id) {
        return turmaRepository.existsById(id);
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public void deleteById(Long id) {
        turmaRepository.deleteById(id);
    }
}
