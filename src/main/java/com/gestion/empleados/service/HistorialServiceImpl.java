package com.gestion.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.model.Historial;
import com.gestion.empleados.repository.HistorialRepository;

@Service
public class HistorialServiceImpl implements HistorialService{
	@Autowired
	private HistorialRepository historialRepository;

	@Override
	public List<Historial> getAllHistoriales() {
	    return historialRepository.findAll();
	}

	@Override
	public Historial getHistorialById(Integer historialId) {
	    return historialRepository.findById(historialId).orElse(null);
	}

	@Override
	public void saveHistorial(Historial historial) {
	    historialRepository.save(historial);
	}

	@Override
	public void updateHistorial(Historial historial) {
	    historialRepository.save(historial);
	}

	@Override
	public void deleteHistorial(Integer historialId) {
	    historialRepository.deleteById(historialId);
	}
}
