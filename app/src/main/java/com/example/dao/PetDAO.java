package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pet;
import com.example.util.ConnectionFactory;
import com.example.util.SqlLogger;

public class PetDAO {

	public List<Pet> findAll() {
	
		List<Pet> pets = new ArrayList<>();
	
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select ");
		sql.append(" 	id, ");
		sql.append(" 	name, ");
		sql.append(" 	species, ");
		sql.append(" 	age, ");
		sql.append(" 	vaccinated ");
		sql.append(" from tb_pets ");
		sql.append(" where deleted = false ");
		sql.append(" order by id DESC ");
		
		long start = SqlLogger.initLog(sql.toString());
		try (
				Connection conn = ConnectionFactory.getDataSource().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery();
			) {
			
			while(rs.next()) {
				Pet pet = new Pet();
				pet.setId(rs.getLong("id"));
				pet.setName(rs.getString("name"));
				pet.setSpecies(rs.getString("species"));
				pet.setAge(rs.getInt("age"));
				pet.setVaccinated(rs.getBoolean("vaccinated"));
				pets.add(pet);
			}
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
		    SqlLogger.finishLog(start);
		}
		
		return pets;
	}
	
}
