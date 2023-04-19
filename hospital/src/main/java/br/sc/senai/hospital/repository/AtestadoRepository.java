package br.sc.senai.hospital.repository;

import br.sc.senai.hospital.model.entities.Atestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtestadoRepository extends JpaRepository<Atestado, Long> {
}
