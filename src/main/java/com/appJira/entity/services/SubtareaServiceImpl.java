package com.appJira.entity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appJira.dao.SubTareaDAO;
import com.appJira.entity.Subtarea;
@Service
public class SubtareaServiceImpl implements ISubtareService {

	@Autowired
	private SubTareaDAO subtareaDAO;
	@Override
	public Subtarea registrar(Subtarea subtarea) {
		
		return subtareaDAO.save(subtarea);
	}

}
