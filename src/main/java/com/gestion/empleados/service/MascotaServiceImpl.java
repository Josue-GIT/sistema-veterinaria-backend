package com.gestion.empleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestion.empleados.model.Mascota;
import com.gestion.empleados.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService{
	@Autowired
    private MascotaRepository mascotaRepository; 
	
    @Override
    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota getMascotaById(Integer mascotaid) {
        return mascotaRepository.findById(mascotaid).orElse(null);
    }

    @Override
    @Transactional
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    @Transactional
    public void updateMascota(Mascota mascota) {
        // Implementa la lógica de actualización según tus necesidades
        mascotaRepository.save(mascota);
    }

    @Override
    @Transactional
    public void deleteMascota(Integer mascotaid) {
        mascotaRepository.deleteById(mascotaid);
    }
}
