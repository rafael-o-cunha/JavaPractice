package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.PetDAO;
import com.example.model.Pet;
import com.example.service.PetService;

@WebServlet("/")
public class HomeServlet extends HttpServlet{

	private PetService petService;
	
	@Override
	public void init() throws ServletException {
		petService = new PetService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Pet> pets = petService.findAll();
		
		req.setAttribute("pets", pets);
		req.getRequestDispatcher("/views/home.jsp").forward(req, res);
	}
}
