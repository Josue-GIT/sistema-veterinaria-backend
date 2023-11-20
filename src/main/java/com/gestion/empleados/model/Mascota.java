package com.gestion.empleados.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Mascota")
public class Mascota implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer mascotaid;
	@Column
	private String nombre;
	@Column
	private String especie;
	@Column
	private String sexo;
	@Column
	private String edad;
	
	@ManyToOne
    @JoinColumn(name="usuario_id", nullable = false)
	@JsonIgnoreProperties("itemsMascota")
    private UserEntity userEntity;
	
	@OneToMany(mappedBy = "mascota")
	@JsonIgnore
	private Collection<Historial> itemsHistorial=new ArrayList<>();
	
	public Mascota() {
	}
	

	public Mascota(Integer mascotaid, String nombre, String especie, String sexo, String edad, 
			UserEntity userEntity, Collection<Historial> itemsHistorial) {
		super();
		this.mascotaid = mascotaid;
		this.nombre = nombre;
		this.especie = especie;
		this.sexo = sexo;
		this.edad = edad;
		this.userEntity = userEntity;
		this.itemsHistorial = itemsHistorial;
	}



	

	public Collection<Historial> getItemsHistorial() {
		return itemsHistorial;
	}





	public void setItemsHistorial(Collection<Historial> itemsHistorial) {
		this.itemsHistorial = itemsHistorial;
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}



	public Integer getMascotaid() {
		return mascotaid;
	}

	public void setMascotaid(Integer mascotaid) {
		this.mascotaid = mascotaid;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}


	
	
}
