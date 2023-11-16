package com.appJira.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appJira.entity.Proyecto;
import com.appJira.entity.services.IProyectoService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/appJira/proyecto")
public class ProyectoController {

	@Autowired
	private IProyectoService proyectoService;
	
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarProyectos() {
		
		return new ResponseEntity<List<Proyecto>>(proyectoService.listar(), HttpStatus.OK);  
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> create(@Valid @RequestBody Proyecto proyecto, BindingResult result) {
		
		Map<String, Object> response = new HashMap<>();
		Proyecto proyectoNew=null;
		try {
			proyectoNew=proyectoService.registrar(proyecto);
		
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El proyecto ha sido creado con éxito!");
		response.put("proyecto", proyectoNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
}
