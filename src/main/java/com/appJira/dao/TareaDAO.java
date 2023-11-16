package com.appJira.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appJira.entity.Tarea;

public interface TareaDAO extends JpaRepository<Tarea, Integer> {

}
