package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.Historial;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Integer>{

}
