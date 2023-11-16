package com.appJira.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import com.appJira.dao.ResponsableDAO;
import com.appJira.dao.UsuarioDAO;
import com.appJira.entity.Estado;
import com.appJira.entity.Usuario;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private ResponsableDAO responsableDAO;
	
	
	@Override
	public Usuario registrar(Usuario usuario) {
		
		usuario.setResponsable(responsableDAO.save(usuario.getResponsable()));
		return usuarioDAO.save(usuario);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		//return usuarioDAO.findAll();
		Estado e=new Estado();
		e.setId(2);
		return usuarioDAO.findAllByEstado(e);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscar(Integer id) {
		// TODO Auto-generated method stub
		return  usuarioDAO.findById(id).get();
	}

	@Override
	@Transactional
	public void eliminar(int id) {

		
		Usuario u=new Usuario();
		Estado e=new Estado();
		e.setId(9);
		u.setId(id);
		u.setEstado(e);
		usuarioDAO.save(u);
		
		
	
		
	}

}
