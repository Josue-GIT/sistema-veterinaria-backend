package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer>{

}
