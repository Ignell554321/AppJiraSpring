package com.appJira.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appJira.entity.Estado;
import com.appJira.entity.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	List<Usuario> findAllByEstado(Estado estado);
	
	
}
