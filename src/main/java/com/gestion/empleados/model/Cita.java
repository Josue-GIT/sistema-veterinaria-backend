package com.gestion.empleados.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="citas")
public class Cita {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer citaid;
	@Column
	private String motivo;
	@Column
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name="cita_id", nullable=false)
	private Medico medico;
	
	public Cita() {
	}

	public Cita(Integer citaid, String motivo, String fecha) {
		super();
		this.citaid = citaid;
		this.motivo = motivo;
		this.fecha = fecha;
	}


	public Integer getCitaid() {
		return citaid;
	}

	public void setCitaid(Integer citaid) {
		this.citaid = citaid;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
}
