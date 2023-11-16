package com.appJira.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subtarea")
public class Subtarea implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "responsable_id", nullable = false)
	private Usuario responsable;
	@ManyToOne
	@JoinColumn(name = "apoyo_id")
	private Usuario apoyo;
	private String tiempoEmpleadoReal;
	private String tiempoEmpleadoPlanificado;
	private String prioridad;
	
	
	@ManyToOne
    @JoinColumn(name = "estado_id")
	private Estado estado;
	
	@ManyToOne
    @JoinColumn(name="tarea_id")
	//@JsonIgnore
	//@JsonIgnoreProperties("subtareas")
    private Tarea tarea;
	
	
	
	public String getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tarea getTarea() {
		return tarea;
	}
	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
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
	public Usuario getResponsable() {
		return responsable;
	}
	public void setResponsable(Usuario responsable) {
		this.responsable = responsable;
	}
	public Usuario getApoyo() {
		return apoyo;
	}
	public void setApoyo(Usuario apoyo) {
		this.apoyo = apoyo;
	}
	public String getTiempoEmpleadoReal() {
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
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
