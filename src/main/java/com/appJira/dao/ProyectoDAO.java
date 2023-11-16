package com.appJira.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appJira.entity.Proyecto;

public interface ProyectoDAO extends JpaRepository<Proyecto, Integer>{

}
