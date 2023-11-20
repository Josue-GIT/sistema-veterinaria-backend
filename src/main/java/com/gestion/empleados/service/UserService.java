package com.gestion.empleados.service;

import java.util.List;
import com.gestion.empleados.model.UserEntity;

public interface UserService {
	List<UserEntity> getAllUsers();
	public abstract void insert(UserEntity userEntity);
	public abstract UserEntity findByUsername(String username);
	void deleteUser(Integer userId);
	UserEntity findById(Integer userId);

}
