package com.gestion.empleados.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.gestion.empleados.util.RoleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RoleEntity implements Serializable
{
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@Column
	private String role=RoleType.USER.name();
	
	@ManyToMany(mappedBy="itemsRole", fetch=FetchType.EAGER)
	private Set<UserEntity> itemsUser=new HashSet<>();
	
	public RoleEntity() {
		
	}

	public RoleEntity(Integer roleId, String role) {
		super();
		this.roleId = roleId;
		this.role = role;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
