package com.gestion.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.empleados.model.Medico;
import com.gestion.empleados.repository.MedicoRepository;

@Service
public class MedicoServiceImpl implements MedicoService{
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Override
	public List<Medico> getAllMedicos() {
		return medicoRepository.findAll();
	}

	@Override
	public Medico getMedicoById(Integer medicoid) {
		return medicoRepository.findById(medicoid).orElse(null);
	}

	@Override
	public void saveMedico(Medico medico) {
		medicoRepository.save(medico);
	}

	@Override
	public void updateMedico(Medico medico) {
		medicoRepository.save(medico);
	}

	@Override
	public void deleteMedico(Integer medicoid) {
		medicoRepository.deleteById(medicoid);
	}

}
