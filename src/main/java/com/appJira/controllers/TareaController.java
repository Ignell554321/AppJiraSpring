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
import com.appJira.entity.Tarea;
import com.appJira.entity.Usuario;
import com.appJira.entity.services.ITareaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/appJira/tarea")
public class TareaController {
	
	@Autowired
	private ITareaService tareaService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarTarea() {
		
		return new ResponseEntity<List<Tarea>>(tareaService.listar(), HttpStatus.OK);  
	}
	
	
	@PostMapping("/guardar")
	public ResponseEntity<?> create(@Valid @RequestBody Tarea tarea, BindingResult result) {
		
		Map<String, Object> response = new HashMap<>();
		Tarea tareaNew=null;
		try {

			tareaNew=tareaService.registrar(tarea);
		
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La tarea ha sido creado con éxito!");
		response.put("usuario", tareaNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

}
