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

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	private PetDAO petDAO;
	
	@Override
	public void init() throws ServletException {
		petDAO = new PetDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		List<Pet> pets = petDAO.findAll();
		
		req.setAttribute("pets", pets);
		req.getRequestDispatcher("/views/home.jsp").forward(req, res);
	}
}
