package com.appJira.entity.services;

import java.util.List;

import com.appJira.entity.Sprint;

public interface ISprintService {
	
	Sprint registrar(Sprint usuario); 
	Sprint buscar(Integer id); 
	List<Sprint> listar();
	void eliminar(Integer id);
	Sprint obtenerSprintActivo(Integer id);

}
