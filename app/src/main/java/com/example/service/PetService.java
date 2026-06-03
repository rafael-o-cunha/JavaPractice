package com.example.service;

import java.util.List;

import com.example.dao.PetDAO;
import com.example.model.Pet;
import com.example.util.PetFiltro;

public class PetService {
	private PetDAO petDAO;

    public PetService() {

        this.petDAO = new PetDAO();
    }

    public List<Pet> findAll() {
    	PetFiltro filtro = new PetFiltro();
    	filtro.setDeleted(false);
        
    	return petDAO.findAll(filtro);
    }
    
    public Pet findById(Long id) {
    	
    	return petDAO.findById(id);
    }
}
