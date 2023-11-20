package com.gestion.empleados.service;

import java.util.List;
import com.gestion.empleados.model.Cita;

public interface CitaService {
	List<Cita> getAllCitas();
    Cita getCitaById(Integer citaid);
    void saveCita(Cita cita);
    void updateCita(Cita cita);
    void deleteCita(Integer citaid);
}
