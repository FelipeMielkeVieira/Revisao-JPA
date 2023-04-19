package br.sc.senai.hospital.controller;

import br.sc.senai.hospital.model.entities.Ambiente;
import br.sc.senai.hospital.model.entities.Hospital;
import br.sc.senai.hospital.repository.AmbienteRepository;
import br.sc.senai.hospital.repository.HospitalRepository;
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
@RequestMapping("/hospital")
public class HospitalController {

    private HospitalRepository hospitalRepository;
    private AmbienteRepository ambienteRepository;

    @GetMapping
    public ResponseEntity<List<Hospital>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(hospitalRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Hospital> save(@RequestBody Hospital hospital) {
        Hospital hospitalSalvo = hospitalRepository.save(hospital);

        for (Ambiente ambiente : hospitalSalvo.getListaDeAmbientes()) {
            ambiente.setHospital(hospitalSalvo);
            ambienteRepository.save(ambiente);
        }
        return ResponseEntity.status(HttpStatus.OK).body(hospitalSalvo);
    }
}
