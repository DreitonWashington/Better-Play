package com.coralsoft.useCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import com.coralsoft.connection.SingleConnectionDB;
import com.coralsoft.domain.entity.Category;
import com.coralsoft.domain.exception.CategoryNotFoundException;
import com.coralsoft.domain.repository.CategoryRepository;

public class CategoryUseCase implements CategoryRepository{
	
	Connection connection = SingleConnectionDB.getConnection();
	//DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME.ofPattern("yyyy-MM-dd HH:mm:ssz").withZone(ZoneId.systemDefault());

	@Override
	public List<Category> findAll() throws Exception {
		
		List<Category> listCategories = new ArrayList<>();
		String sql = "select * from category";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);

		while(result.next()) {
			Category category = new Category();
			category.setId(result.getLong("id"));
			category.setName(result.getString("name"));
			category.setDescription(result.getString("description"));
			category.setActive(result.getBoolean("isActive"));
			
			if(result.getObject("createdAt") != null) {
				Object o = result.getObject("createdAt");
				LocalDateTime date = (LocalDateTime) o;
				Instant instant = Instant.from(date.atZone(ZoneId.systemDefault()));
				
				category.setCreatedAt(instant);
				listCategories.add(category);				
			}else {
				listCategories.add(category);
			}
		}
		
		return listCategories;
	}

	@Override
	public Category findById(Long id) {
		
		Category category = new Category();
		String sql = "select * from category where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				category.setId(result.getLong("id"));
				category.setName(result.getString("name"));
				category.setDescription(result.getString("description"));
				category.setActive(result.getBoolean("isActive"));
			
				if(result.getObject("createdAt") != null) {
					Object o = result.getObject("createdAt");
					LocalDateTime date = (LocalDateTime) o;
					Instant instant = Instant.from(date.atZone(ZoneId.systemDefault()));
					
					category.setCreatedAt(instant);					
				}
			}else {
				throw new CategoryNotFoundException(id);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public Category save(Category category) {
		
		String sql = "insert into category (name, description, isActive, createdAt) values (? , ?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, category.getName());
			statement.setString(2, category.getDescription());
			statement.setBoolean(3, category.getIsActive());
			statement.setObject(4, category.getCreatedAt());
			
			statement.executeUpdate();
			
			ResultSet result = statement.getGeneratedKeys();
			if(result.next()) {
				category.setId(result.getLong(1));
			}
			
			category = this.findById(category.getId());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return category;
	}

	@Override
	public Category update(Category category) {
		
		Category categoryNow = new Category();
		String sql = "update category set name = ?, description = ? where id = ?";
		
		try{
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			categoryNow = this.findById(category.getId());
			categoryNow.setName(category.getName());
			if(category.getDescription() != null) categoryNow.setDescription(category.getDescription());
			
			statement.setString(1, categoryNow.getName());
			statement.setString(2, categoryNow.getDescription());
			statement.setLong(3, categoryNow.getId());
			
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			
			if(result.next()) {
				categoryNow = this.findById(result.getLong(1));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return categoryNow;
	}

	@Override
	public void delete(Long id) {
			
		String sql = "delete from category where id = ?";
		
		try {
			this.findById(id);
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
