package br.sc.senai.escola.service;

import br.sc.senai.escola.model.entities.Endereco;
import br.sc.senai.escola.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService  {

    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Boolean existsById(Long id) {
        return enderecoRepository.existsById(id);
    }

    public Optional<Endereco> findById(Long id) {
        return enderecoRepository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }
}
