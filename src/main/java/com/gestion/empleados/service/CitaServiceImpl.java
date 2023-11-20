package com.gestion.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.model.Cita;
import com.gestion.empleados.repository.CitaRepository;

@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
    private CitaRepository citaRepository;
	
	@Override
	public List<Cita> getAllCitas() {
		return citaRepository.findAll();
	}

	@Override
	public Cita getCitaById(Integer citaid) {
		return citaRepository.findById(citaid).orElse(null);
	}

	@Override
	public void saveCita(Cita cita) {
		citaRepository.save(cita);
	}

	@Override
	public void updateCita(Cita cita) {
		citaRepository.save(cita);
	}

	@Override
	public void deleteCita(Integer citaid) {
		citaRepository.deleteById(citaid);
	}

}
