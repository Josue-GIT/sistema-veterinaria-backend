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

import com.gestion.empleados.model.Historial;
import com.gestion.empleados.model.Mascota;
import com.gestion.empleados.model.Medico;
import com.gestion.empleados.model.Servicio;
import com.gestion.empleados.service.HistorialService;
import com.gestion.empleados.service.MascotaService;
import com.gestion.empleados.service.MedicoService;
import com.gestion.empleados.service.ServicioService;

@RestController
@RequestMapping("/historiales")
@CrossOrigin("*")
public class HistorialController {
    
    @Autowired
    private MascotaService mascotaService;
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private MedicoService medicoService;

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<Historial> getAllHistoriales() {
        return historialService.getAllHistoriales();
    }

    @GetMapping("/{historialid}")
    public ResponseEntity<Historial> getHistorialById(@PathVariable int historialid) {
        Historial historial = historialService.getHistorialById(historialid);
        return ResponseEntity.ok(historial);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarHistorial(@RequestBody Historial historial) {
        
    	 Mascota mascota = mascotaService.getMascotaById(historial.getMascota().getMascotaid());
         Servicio servicio = servicioService.getServicioById(historial.getServicio().getServicioid());
         Medico medico = medicoService.getMedicoById(historial.getMedico().getMedicoid());


        // Verificar la existencia de la mascota, servicio y médico
        if (mascota == null) {
            return new ResponseEntity<>("Mascota no encontrada", HttpStatus.BAD_REQUEST);
        }
        if (servicio == null) {
            return new ResponseEntity<>("Servicio no encontrado", HttpStatus.BAD_REQUEST);
        }
        if (medico == null) {
            return new ResponseEntity<>("Medico no encontrado", HttpStatus.BAD_REQUEST);
        }

        // Establecer mascota, servicio y médico en el historial
        historial.setMascota(mascota);
        historial.setServicio(servicio);
        historial.setMedico(medico);

        historialService.saveHistorial(historial);
        return new ResponseEntity<>("Historial registrado correctamente", HttpStatus.OK);
    }

    @PutMapping("/editar/{historialid}")
    public ResponseEntity<Void> updateHistorial(@PathVariable int historialid, @RequestBody Historial historial) {
        if (historialid != historial.getHistorialid()) {
            return ResponseEntity.badRequest().build();
        }
        historialService.updateHistorial(historial);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{historialid}")
    public ResponseEntity<Void> deleteHistorial(@PathVariable int historialid) {
        historialService.deleteHistorial(historialid);
        return ResponseEntity.ok().build();
    }
}