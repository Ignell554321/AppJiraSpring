package com.appJira.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appJira.entity.Sprint;
import com.appJira.entity.services.ISprintService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/appJira/sprint")
public class SprintController {
	
	@Autowired
	private ISprintService sprintService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarSprints() {
		
		return new ResponseEntity<List<Sprint>>(sprintService.listar(), HttpStatus.OK);  
	}

	@GetMapping("/obtAct/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<?> obtenerSprintActivo( @PathVariable Integer id) {

		Map<String, Object> response = new HashMap<>();
		Sprint sprint=null;
		
		try {
			
			sprint=sprintService.obtenerSprintActivo(id);
		
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Sprint>(sprint, HttpStatus.OK);
	}
	
}
