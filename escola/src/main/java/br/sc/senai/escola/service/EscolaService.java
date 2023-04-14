package br.sc.senai.escola.service;

import br.sc.senai.escola.model.entities.Escola;
import br.sc.senai.escola.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EscolaService {

    private EscolaRepository escolaRepository;

    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public Optional<Escola> findById(Long id) {
        return escolaRepository.findById(id);
    }

    public Boolean existsById(Long id) {
        return escolaRepository.existsById(id);
    }

    public Escola save(Escola escola) {
        return escolaRepository.save(escola);
    }

    public void deleteById(Long id) {
        escolaRepository.deleteById(id);
    }
}
