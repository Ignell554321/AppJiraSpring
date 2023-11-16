package com.appJira.entity.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appJira.dao.SprintDAO;
import com.appJira.entity.Estado;
import com.appJira.entity.Proyecto;
import com.appJira.entity.Sprint;

@Service
public class SprintServiceImpl implements ISprintService {

	@Autowired
	private SprintDAO sprintDAO;
	
	@Override
	public Sprint registrar(Sprint sprint) {
		// TODO Auto-generated method stub
		return sprintDAO.save(sprint);
	}

	@Override
	public Sprint buscar(Integer id) {
		// TODO Auto-generated method stub
		return sprintDAO.findById(id).get();
	}

	@Override
	public List<Sprint> listar() {
		// TODO Auto-generated method stub
		return sprintDAO.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		sprintDAO.deleteById(id);

	}

	@Override
	public Sprint obtenerSprintActivo(Integer id) {
		// TODO Auto-generated method stub
		Estado e=new Estado();
		e.setId(1);
		Proyecto p=new Proyecto();
		p.setId(id);
		return sprintDAO.findByEstadoAndProyecto(e,p);
	}

}
