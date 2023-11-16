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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appJira.entity.Estado;
import com.appJira.entity.Usuario;
import com.appJira.entity.services.UsuarioService;

import org.springframework.transaction.annotation.Transactional;
import jakarta.validation.Valid;


@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/appJira/usuario")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listarUsuario() {
		
		return new ResponseEntity<List<Usuario>>(usuarioService.listar(), HttpStatus.OK);  
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<?> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		
		Map<String, Object> response = new HashMap<>();
		Usuario usuarioNew=null;
		try {

			usuarioNew=usuarioService.registrar(usuario);
		
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El usuario ha sido creado con éxito!");
		response.put("usuario", usuarioNew);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/buscar/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<?> buscar( @PathVariable Integer id) {

		Map<String, Object> response = new HashMap<>();
		Usuario usuario=null;
		
		try {
			
			usuario=usuarioService.buscar(id);
		
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar( @PathVariable Integer id) {

		Map<String, Object> response = new HashMap<>();
		
		try {
			
				usuarioService.eliminar(id);
			

		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		response.put("mensaje", "Usaurio eliminado correctamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
