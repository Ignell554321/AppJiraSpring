package com.appJira.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appJira.dao.EquipoDAO;
import com.appJira.dao.ProyectoDAO;
import com.appJira.dao.UsuarioDAO;
import com.appJira.entity.Proyecto;
import com.appJira.entity.Usuario;

@Service
public class ProyectoServiceImpl implements IProyectoService{
	
	@Autowired
	private ProyectoDAO proyectoDAO;
	@Autowired
	private EquipoDAO equipoDAO;
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Proyecto registrar(Proyecto proyecto) {
		// TODO Auto-generated method stub
		
		/*proyecto.getEquipo().getUsuarios().forEach(u->{
			System.out.println(u.getId());//+" "+ u.getResponsable().getNombres()+" "+u.getResponsable().getApellidos());
		});*/

		//proyecto.getEquipo().getUsuarios().add(usuarioDAO.findById(1).get());
		equipoDAO.save(proyecto.getEquipo());
		return proyectoDAO.save(proyecto);
	}

	@Override
	public Proyecto buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Proyecto> listar() {
		// TODO Auto-generated method stub
		return proyectoDAO.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
