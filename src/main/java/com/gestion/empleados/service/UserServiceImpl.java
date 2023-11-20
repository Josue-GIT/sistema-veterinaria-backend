package com.gestion.empleados.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.model.RoleEntity;
import com.gestion.empleados.model.UserEntity;
import com.gestion.empleados.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private RoleService roleService;
	
	@Autowired
	private UserRepository repository;
	
	public UserServiceImpl() {
	}
	@Override
    @Transactional
    public void insert(UserEntity userEntity) {
        // Lógica de inserción de usuario
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String passwordCrypt = bCrypt.encode(userEntity.getPassword());

        // Guardando el password cifrado
        userEntity.setPassword(passwordCrypt);
        
        // Agregando el rol por defecto si no se proporciona en la solicitud
        if (userEntity.getItemsRole() == null || userEntity.getItemsRole().isEmpty()) {
            Set<RoleEntity> roles = new HashSet<>();
            roles.add(roleService.findById(1)); // ID del rol USER
            userEntity.setItemsRole(roles);
        }

        repository.save(userEntity);
    }
	@Override
    public UserEntity findById(Integer userId) {
        Optional<UserEntity> userOptional = repository.findById(userId);
        return userOptional.orElse(null);
    }

	@Override
	@Transactional(readOnly=true)
	public UserEntity findByUsername(String username) {
		return repository.findByUsername(username);
	}
	

	@Override
	public List<UserEntity> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public void deleteUser(Integer userId) {
		repository.deleteById(userId);
	}
}
