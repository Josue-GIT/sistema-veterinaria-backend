package com.gestion.empleados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.model.RoleEntity;
import com.gestion.empleados.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleRepository repository;
	
	public RoleServiceImpl() {
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public RoleEntity findById(Integer roleId) {
		return repository.findById(roleId).orElse(null);
	}
}
