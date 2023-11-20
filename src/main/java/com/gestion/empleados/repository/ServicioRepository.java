package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

}
