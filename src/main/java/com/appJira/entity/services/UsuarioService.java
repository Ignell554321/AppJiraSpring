package com.appJira.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appJira.dao.UsuarioDAO;
import com.appJira.entity.Usuario;


public interface UsuarioService {

	
	Usuario registrar(Usuario usuario); 
	Usuario buscar(Integer id); 
	List<Usuario> listar();
	void eliminar(int usuario);
	
	
	
	
}
