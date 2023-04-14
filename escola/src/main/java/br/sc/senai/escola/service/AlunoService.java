package br.sc.senai.escola.service;

import br.sc.senai.escola.model.entities.Aluno;
import br.sc.senai.escola.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Boolean existsById(Long id) {
        return alunoRepository.existsById(id);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }
}
