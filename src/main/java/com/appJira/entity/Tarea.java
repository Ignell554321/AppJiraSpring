package com.appJira.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	//private String tiempoEmpleadoReal;
	//private String tiempoEmpleadoPlanificado;
	private String prioridad;
	
	@ManyToOne
    @JoinColumn(name = "estado_id")
	private Estado estado;
	
	@OneToMany(mappedBy = "tarea")
	@JsonIgnoreProperties("tarea")
    private List<Subtarea> subtareas=new ArrayList<Subtarea>();
	
	@ManyToOne
	@JoinColumn(name = "sprint_id")
	@JsonIgnoreProperties("tareas")
	private Sprint sprint;
	
	
	public Sprint getSprint() {
		return sprint;
	}
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
	public List<Subtarea> getSubtareas() {
		return subtareas;
	}
	public void setSubtareas(List<Subtarea> subtareas) {
		this.subtareas = subtareas;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/*public String getTiempoEmpleadoReal() {
		return tiempoEmpleadoReal;
	}
	public void setTiempoEmpleadoReal(String tiempoEmpleadoReal) {
		this.tiempoEmpleadoReal = tiempoEmpleadoReal;
	}
	public String getTiempoEmpleadoPlanificado() {
		return tiempoEmpleadoPlanificado;
	}
	public void setTiempoEmpleadoPlanificado(String tiempoEmpleadoPlanificado) {
		this.tiempoEmpleadoPlanificado = tiempoEmpleadoPlanificado;
	}*/
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
