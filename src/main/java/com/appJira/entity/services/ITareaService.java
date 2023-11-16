package com.appJira.entity.services;

import java.util.List;

import com.appJira.entity.Tarea;

public interface ITareaService {

	Tarea registrar(Tarea tarea); 
	Tarea buscar(Integer id); 
	List<Tarea> listar();
	void eliminar(Integer id);
	
}
