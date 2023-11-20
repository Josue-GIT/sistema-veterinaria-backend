package com.gestion.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

}
