package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Atestado;
import br.sc.senai.hospital.model.entities.Consulta;
import br.sc.senai.hospital.model.entities.Diagnostico;
import br.sc.senai.hospital.repository.AtestadoRepository;
import br.sc.senai.hospital.repository.ConsultaRepository;
import br.sc.senai.hospital.repository.DiagnosticoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/consulta")
public class ConsultaController {

    private ConsultaRepository consultaRepository;
    private DiagnosticoRepository diagnosticoRepository;
    private AtestadoRepository atestadoRepository;

    @GetMapping
    public ResponseEntity<List<Consulta>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Consulta> save(@RequestBody Consulta consulta) {
        Consulta consultaSalva = consultaRepository.save(consulta);

        Diagnostico diagnostico = consultaSalva.getDiagnostico();
        diagnostico.setConsulta(consultaSalva);
        diagnosticoRepository.save(diagnostico);

        Atestado atestado = consultaSalva.getAtestado();
        atestado.setConsulta(consultaSalva);
        atestadoRepository.save(atestado);

        return ResponseEntity.status(HttpStatus.OK).body(consultaSalva);
    }
}
