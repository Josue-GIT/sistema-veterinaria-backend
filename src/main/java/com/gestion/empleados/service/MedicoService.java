package com.gestion.empleados.service;

import java.util.List;

import com.gestion.empleados.model.Medico;

public interface MedicoService {
	List<Medico> getAllMedicos();
    Medico getMedicoById(Integer medicoid);
    void saveMedico(Medico medico);
    void updateMedico(Medico medico);
    void deleteMedico(Integer medicoid);
}
