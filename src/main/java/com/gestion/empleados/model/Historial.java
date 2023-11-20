package com.gestion.empleados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="historiales")
public class Historial implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer historialid;
	@Column
	private String diagnostico;
	@Column
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name="servicio_id", nullable=false)
	private Servicio servicio;
	
	@ManyToOne
	@JoinColumn(name="mascota_id", nullable=false)
	private Mascota mascota;
	
	@ManyToOne
	@JoinColumn(name="medico_id", nullable=false)
	private Medico medico;
	
	
	public Historial() {
	}
	
	public Historial(Integer historialid, String diagnostico, String fecha, Servicio servicio, Mascota mascota,
			Medico medico) {
		super();
		this.historialid = historialid;
		this.diagnostico = diagnostico;
		this.fecha = fecha;
		this.servicio = servicio;
		this.mascota = mascota;
		this.medico = medico;
	}

	
	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}






	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}






	public Integer getHistorialid() {
		return historialid;
	}

	public void setHistorialid(Integer historialid) {
		this.historialid = historialid;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}
