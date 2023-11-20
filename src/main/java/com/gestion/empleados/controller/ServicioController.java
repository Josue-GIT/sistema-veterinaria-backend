package com.gestion.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.model.Servicio;
import com.gestion.empleados.service.ServicioService;

@RestController
@RequestMapping("/servicios")
@CrossOrigin("*")
public class ServicioController {
	@Autowired
	private ServicioService servicioService;

	public ServicioController(ServicioService servicioService) {
	    this.servicioService = servicioService;
	}

	@GetMapping
	public List<Servicio> getAllServicios() {
	    return servicioService.getAllServicios();
	}

	@GetMapping("/{servicioid}")
	public ResponseEntity<Servicio> getServicioById(@PathVariable int servicioid) {
	    Servicio servicio = servicioService.getServicioById(servicioid);
	    return ResponseEntity.ok(servicio);
	}

	@PostMapping("/registrar")
	public ResponseEntity<String> registrarServicio(@RequestBody Servicio servicio) {
	    servicioService.saveServicio(servicio);
	    return new ResponseEntity<>("Servicio registrado correctamente", HttpStatus.OK);
	}

	@PutMapping("/editar/{servicioid}")
	public ResponseEntity<Void> updateServicio(@PathVariable int servicioid, @RequestBody Servicio servicio) {
	    if (servicioid != servicio.getServicioid()) {
	        return ResponseEntity.badRequest().build();
	    }
	    servicioService.updateServicio(servicio);
	    return ResponseEntity.ok().build();
	}
}
