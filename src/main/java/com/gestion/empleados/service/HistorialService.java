package com.gestion.empleados.service;

import java.util.List;

import com.gestion.empleados.model.Historial;

public interface HistorialService {
	List<Historial> getAllHistoriales();
    Historial getHistorialById(Integer historialId);
    void saveHistorial(Historial historial);
    void updateHistorial(Historial historial);
    void deleteHistorial(Integer historialId);
}
