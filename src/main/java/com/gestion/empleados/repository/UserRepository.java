package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	@Query(value = "select * from users where username=?", nativeQuery = true)
	public abstract UserEntity findByUsername(String username);
}
