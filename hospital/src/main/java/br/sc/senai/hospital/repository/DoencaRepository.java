package br.sc.senai.hospital.repository;

import br.sc.senai.hospital.model.entities.Doenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoencaRepository extends JpaRepository<Doenca, Long> {
}
