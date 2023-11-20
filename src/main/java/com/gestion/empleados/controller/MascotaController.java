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

import com.gestion.empleados.model.Mascota;
import com.gestion.empleados.model.UserEntity;
import com.gestion.empleados.service.MascotaService;
import com.gestion.empleados.service.UserService;

@RestController
@RequestMapping("/mascotas")
@CrossOrigin("*")
public class MascotaController {
	@Autowired
    private UserService userService;
	
	@Autowired
	private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaService.getAllMascotas();
    }

    @GetMapping("/{mascotaid}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable int mascotaid) {
        Mascota mascota = mascotaService.getMascotaById(mascotaid);
        return ResponseEntity.ok(mascota);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarMascota(@RequestBody Mascota mascota) {
        // Obtener el UserEntity por su ID usando la interfaz UserService
        UserEntity userEntity = userService.findById(mascota.getUserEntity().getUserId());

        // Verificar si el usuario existe
        if (userEntity == null) {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
        }

        // Establecer el UserEntity en la Mascota
        mascota.setUserEntity(userEntity);

        // Guardar la Mascota
        mascotaService.saveMascota(mascota);

        return new ResponseEntity<>("Mascota registrada correctamente", HttpStatus.OK);
    }

    @PutMapping("/editar/{mascotaid}")
    public ResponseEntity<Void> updateMascota(@PathVariable int mascotaid, @RequestBody Mascota mascota) {
        // Asegúrate de que el ID en el cuerpo de la solicitud coincida con el ID en la URL
        if (mascotaid != mascota.getMascotaid()) {
            return ResponseEntity.badRequest().build();
        }
        mascotaService.updateMascota(mascota);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/eliminar/{mascotaid}")
    public ResponseEntity<Void> deleteMascota(@PathVariable int mascotaid) {
        mascotaService.deleteMascota(mascotaid);
        return ResponseEntity.ok().build();
    }
}
