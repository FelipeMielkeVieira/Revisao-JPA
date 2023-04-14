package br.sc.senai.escola.repository;

import br.sc.senai.escola.model.entities.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
}
