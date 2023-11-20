package com.gestion.empleados.service;

import java.util.List;

import com.gestion.empleados.model.Mascota;

public interface MascotaService {
	List<Mascota> getAllMascotas();
    Mascota getMascotaById(Integer mascotaid);
    void saveMascota(Mascota mascota);
    void updateMascota(Mascota mascota);
    void deleteMascota(Integer mascotaid);
}
