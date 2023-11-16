package com.appJira.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appJira.entity.Estado;
import com.appJira.entity.Proyecto;
import com.appJira.entity.Sprint;

public interface SprintDAO extends JpaRepository<Sprint, Integer>{

	Sprint findByEstadoAndProyecto(Estado estado,Proyecto proyecto);
	
}
