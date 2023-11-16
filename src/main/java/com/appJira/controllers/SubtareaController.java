package com.appJira.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appJira.entity.Subtarea;
import com.appJira.entity.services.ISubtareService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/appJira/subtarea")
public class SubtareaController {

	@Autowired
	private ISubtareService subtareaService;
	
	@PostMapping("/guardar")
	public ResponseEntity<?> create(@Valid @RequestBody Subtarea subtarea, BindingResult result) {
		
		Map<String, Object> response = new HashMap<>();
		Subtarea tareaNew=null;
		try {

			tareaNew=subtareaService.registrar(subtarea);
		
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La subtarea ha sido creado con éxito!");
		response.put("usuario", tareaNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
