package com.gestion.empleados.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestion.empleados.util.StateType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(unique=true, nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private String direccion;
	@Column
	private String celular;
	@Column
	private String email;
	@Column
	private String sexo;
	@Column
	private String url;
	@Column
	@OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("userEntity")
	private Collection<Mascota> itemsMascota = new ArrayList<>();
	
	private String state=StateType.ACTIVE.name();
	
	public boolean checkCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="users_roles",
				joinColumns=@JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<RoleEntity> itemsRole = new HashSet<>();
	
	public UserEntity() {
		
	}

	public UserEntity(Integer userId, String username, String password, String nombre, String apellidos,
			String direccion, String celular, String email, String sexo, String state, String url) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.sexo = sexo;
		this.state = state;
		this.url = url;
	}
	
	
	
	
	public String getState() {
		return state;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public Collection<Mascota> getItemsMascota() {
		return itemsMascota;
	}



	public void setItemsMascota(Collection<Mascota> itemsMascota) {
		this.itemsMascota = itemsMascota;
	}



	public void addRole(RoleEntity role) {
		itemsRole.add(role);
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	

	public void setState(String state) {
		this.state = state;
	}

	public Set<RoleEntity> getItemsRole() {
		return itemsRole;
	}

	public void setItemsRole(Set<RoleEntity> itemsRole) {
		this.itemsRole = itemsRole;
	}
	
}
