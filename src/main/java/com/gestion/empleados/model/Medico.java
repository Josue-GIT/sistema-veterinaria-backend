package com.gestion.empleados.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="medicos")
public class Medico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int medicoid;
	@Column
	private String nombre;
	@Column
	private String fechaNacimiento;
	@Column
	private String horario;

	@OneToMany(mappedBy = "medico")
	private Collection<Cita> itemsCita=new ArrayList<>();
	
	@OneToMany(mappedBy = "medico")
	private Collection<Historial> itemsHistorial=new ArrayList<>();
	
	public Medico() {
	}

	public Medico(int medicoid, String nombre, String fechaNacimiento, String horario) {
		super();
		this.medicoid = medicoid;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.horario = horario;
	}

	

	public int getMedicoid() {
		return medicoid;
	}

	public void setMedicoid(int medicoid) {
		this.medicoid = medicoid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
