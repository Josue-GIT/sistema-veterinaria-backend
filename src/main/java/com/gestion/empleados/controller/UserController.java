package com.gestion.empleados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.empleados.model.UserEntity;
import com.gestion.empleados.service.UserService;
import org.springframework.security.crypto.bcrypt.BCrypt;
@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
		@Autowired
	    private UserService userService;

	    @GetMapping
	    public ResponseEntity<List<UserEntity>> getAllUsers() {
	        List<UserEntity> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }


	    @PostMapping("/registrar")
	    public ResponseEntity<String> registrarUsuario(@RequestBody UserEntity user) {
	        userService.insert(user);
	        return new ResponseEntity<>("Usuario registrado correctamente", HttpStatus.CREATED);
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody UserEntity user) {
	        UserEntity storedUser = userService.findByUsername(user.getUsername());

	        if (storedUser != null && BCrypt.checkpw(user.getPassword(), storedUser.getPassword())) {
	            // Contraseña válida, procede con el inicio de sesión
	            return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
	        } else {
	            // Contraseña incorrecta
	            return new ResponseEntity<>("Credenciales incorrectas", HttpStatus.UNAUTHORIZED);
	        }
	    }

	    @DeleteMapping("/{userId}")
	    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
	        userService.deleteUser(userId);
	        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
	    }
}
