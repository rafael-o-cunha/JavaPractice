package com.example.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Pet;
import com.example.util.ConnectionFactory;
import com.example.util.PetFiltro;
import com.example.util.SqlLogger;

public class PetDAO {
	
	private String getSqlBase(PetFiltro filtro) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" from tb_pets ");
		sql.append(" where 1 = 1 ");
		sql.append(" and deleted = ").append(filtro.getDeleted()).append(" ");
		
		if(filtro.getId() != null) {
				
		}		// converter filtro para filter, organizar dao, completar filtro e rota de consulta
		
		if(filtro.getName() != null) {
			
		}
		
		if(filtro.getSpecies() != null) {
			
		}
		
		if(filtro.getBreed() != null) {
			
		}
		
		if(filtro.getAge() != null) {
			
		}
		
		if(filtro.getColor() != null) {
			
		}
		
		if(filtro.getWeight() != null) {
			
		}
		
		if(filtro.getVaccinated() != null) {
			
		}
		
		if(filtro.getBirthDate() != null) {
			
		}
		
		if(filtro.getNotes() != null) {
			
		}
		
		if(filtro.getNotes() != null) {
			
		}
		
		if(filtro.getCreatedAt() != null) {
			
		}
		
		if(filtro.getUpdatedAt() != null) {
			
		}
		
		return sql.toString();
	}
	
	public String getHomeProjecao() {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" 	id, ");
		sql.append(" 	name, ");
		sql.append(" 	species, ");
		sql.append(" 	age, ");
		sql.append(" 	vaccinated ");
		
		return sql.toString();
	}
	
	public Pet getHomeResultSet(ResultSet rs) throws SQLException {
		Pet pet = new Pet();
		
		pet.setId(rs.getLong("id"));
		pet.setName(rs.getString("name"));
		pet.setSpecies(rs.getString("species"));
		pet.setAge(rs.getInt("age"));
		pet.setVaccinated(rs.getBoolean("vaccinated"));
		
		return pet;
	}

	public List<Pet> findAll(PetFiltro filtro) {
	
		List<Pet> pets = new ArrayList<>();
	
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select ");
		sql.append(this.getHomeProjecao());
		sql.append(this.getSqlBase(filtro));
		sql.append(" order by id DESC ");
		
		long start = SqlLogger.initLog(sql.toString());
		try (
				Connection conn = ConnectionFactory.getDataSource().getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql.toString());
				ResultSet rs = stmt.executeQuery();
			) {
			
			while(rs.next()) {
				Pet pet = this.getHomeResultSet(rs);
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

	public Pet findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
