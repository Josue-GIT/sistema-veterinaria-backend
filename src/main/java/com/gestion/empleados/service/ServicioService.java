package com.gestion.empleados.service;

import java.util.List;
import com.gestion.empleados.model.Medico;
import com.gestion.empleados.model.Servicio;

public interface ServicioService {
	List<Servicio> getAllServicios();
    Servicio getServicioById(Integer servicioid);
    void saveServicio(Servicio servicio);
    void updateServicio(Servicio servicio);
    void deleteServicio(Integer servicioid);
}
