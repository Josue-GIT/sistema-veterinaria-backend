package com.gestion.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.model.Servicio;
import com.gestion.empleados.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Override
	public List<Servicio> getAllServicios() {
		return servicioRepository.findAll();
	}

	@Override
	public Servicio getServicioById(Integer servicioid) {
		return servicioRepository.findById(servicioid).orElse(null);
	}

	@Override
	public void saveServicio(Servicio servicio) {
		servicioRepository.save(servicio);
	}

	@Override
	public void updateServicio(Servicio servicio) {
		servicioRepository.save(servicio);
	}

	@Override
	public void deleteServicio(Integer servicioid) {
		servicioRepository.deleteById(servicioid);
	}


}
