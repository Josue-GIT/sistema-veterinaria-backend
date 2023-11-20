package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{

}
