package com.appJira.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "equipo")
public class Equipo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToMany()
	@JoinTable(name="equipo_usuarios", joinColumns= @JoinColumn(name="equipo_id"),
	inverseJoinColumns=@JoinColumn(name="usuario_id"))
	//uniqueConstraints= {@UniqueConstraint(columnNames= {"equipo_id", "usuario_id"})})
	private List<Usuario> usuarios= new ArrayList<Usuario>();
	
	
	@ManyToOne
    @JoinColumn(name = "estado_id")
	private Estado estado;

	public int getId() {
		return id;
	}
	
	public void addusuario(Usuario usuario) {
		usuarios.add(usuario);
		//usuarios.getDepartments().add(this);
    }

	public void setId(int id) {
		this.id = id;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuario) {
		this.usuarios = usuario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
