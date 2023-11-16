package com.appJira.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appJira.dao.SubTareaDAO;
import com.appJira.dao.TareaDAO;
import com.appJira.entity.Tarea;

@Service
public class TareaServiceImpl implements ITareaService {

	@Autowired
	private TareaDAO tareaDAO;
	@Autowired
	private SubTareaDAO subTareaDAO;
	
	@Override
	public Tarea registrar(Tarea tarea) {
		
		tarea.getSubtareas().forEach( t ->{
			subTareaDAO.save(t);
		});		

		return tareaDAO.save(tarea);
	}

	@Override
	public Tarea buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> listar() {
		// TODO Auto-generated method stub
		return tareaDAO.findAll();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub

	}

}
