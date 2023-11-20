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

import com.gestion.empleados.model.Cita;
import com.gestion.empleados.model.Medico;
import com.gestion.empleados.service.CitaService;
import com.gestion.empleados.service.MedicoService;

@RestController
@RequestMapping("/citas")
@CrossOrigin("*")
public class CitaController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> getAllCitas() {
        return citaService.getAllCitas();
    }

    @GetMapping("/{citaid}")
    public ResponseEntity<Cita> getCitaById(@PathVariable int citaid) {
        Cita cita = citaService.getCitaById(citaid);
        return ResponseEntity.ok(cita);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCita(@RequestBody Cita cita) {
        Medico medico = medicoService.getMedicoById(cita.getMedico().getMedicoid());

        if (medico == null) {
            return new ResponseEntity<>("Médico no encontrado", HttpStatus.BAD_REQUEST);
        }

        cita.setMedico(medico);

        citaService.saveCita(cita);

        return new ResponseEntity<>("Cita registrada correctamente", HttpStatus.OK);
    }

    @PutMapping("/editar/{citaid}")
    public ResponseEntity<Void> updateCita(@PathVariable int citaid, @RequestBody Cita cita) {
        if (citaid != cita.getCitaid()) {
            return ResponseEntity.badRequest().build();
        }
        citaService.updateCita(cita);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{citaid}")
    public ResponseEntity<Void> deleteCita(@PathVariable int citaid) {
        citaService.deleteCita(citaid);
        return ResponseEntity.ok().build();
    }
}
