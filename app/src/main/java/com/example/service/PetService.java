package com.example.service;

import java.util.List;

import com.example.dao.PetDAO;
import com.example.model.Pet;

public class PetService {
	private PetDAO petDAO;

    public PetService() {

        this.petDAO = new PetDAO();
    }

    public List<Pet> findAll() {

        return petDAO.findAll();
    }
}
