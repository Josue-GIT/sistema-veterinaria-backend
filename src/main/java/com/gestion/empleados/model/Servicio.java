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
@Table(name="servicios")
public class Servicio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int servicioid;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	
	@OneToMany(mappedBy = "servicio")
	private Collection<Historial> itemsHistorial=new ArrayList<>();
	
	public Servicio() {
	}

	

	public Servicio(int servicioid, String nombre, String descripcion) {
		super();
		this.servicioid = servicioid;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}




	public int getServicioid() {
		return servicioid;
	}



	public void setServicioid(int servicioid) {
		this.servicioid = servicioid;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
