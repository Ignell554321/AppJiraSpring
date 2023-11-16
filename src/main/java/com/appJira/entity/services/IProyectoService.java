package com.appJira.entity.services;

import java.util.List;

import com.appJira.entity.Proyecto;

public interface IProyectoService {

	Proyecto registrar(Proyecto usuario); 
	Proyecto buscar(Integer id); 
	List<Proyecto> listar();
	void eliminar(Integer id);
}
