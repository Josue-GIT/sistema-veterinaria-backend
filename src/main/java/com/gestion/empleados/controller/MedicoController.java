package com.gestion.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.model.Medico;
import com.gestion.empleados.service.MedicoService;

@RestController
@RequestMapping("/medicos")
@CrossOrigin("*")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.getAllMedicos();
    }

    @GetMapping("/{medicoid}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable int medicoid) {
        Medico medico = medicoService.getMedicoById(medicoid);
        return ResponseEntity.ok(medico);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarMedico(@RequestBody Medico medico) {

        medicoService.saveMedico(medico);

        return new ResponseEntity<>("Medico registrado correctamente", HttpStatus.OK);
    }

    @PutMapping("/editar/{medicoid}")
    public ResponseEntity<Void> updateMedico(@PathVariable int medicoid, @RequestBody Medico medico) {
        // Asegúrate de que el ID en el cuerpo de la solicitud coincida con el ID en la URL
        if (medicoid != medico.getMedicoid()) {
            return ResponseEntity.badRequest().build();
        }
        medicoService.updateMedico(medico);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/eliminar/{medicoid}")
    public ResponseEntity<Void> deleteMedico(@PathVariable int medicoid) {
        medicoService.deleteMedico(medicoid);
        return ResponseEntity.ok().build();
    }
}
