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
import com.coralsoft.domain.entity.Genre;
import com.coralsoft.domain.exception.GenreNotFoundException;
import com.coralsoft.domain.repository.GenreRepository;

public class GenreUseCase implements GenreRepository{
	
	private Connection connection = SingleConnectionDB.getConnection();
	//private DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE_TIME.ofPattern("yyyy-MM-dd HH:mm:ssz").withZone(ZoneId.systemDefault());


	@Override
	public List<Genre> findAll() throws Exception{
		
		List<Genre> genres = new ArrayList<>();
		String sql = "select * from genre";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){
			Genre genre = new Genre();
			genre.setId(result.getLong("id"));
			genre.setName(result.getString("name"));
			genres.add(genre);
		}
		return genres;
	}
	
	@Override
	public Genre findById(Long id) {
		
		String sql = "select * from genre where id = ?";
		Genre genre = new Genre();
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				genre.setId(result.getLong("id"));
				genre.setName(result.getString("name"));
				genre.setDescription(result.getString("description"));
				genre.setActive(result.getBoolean("isActive"));
				
				Object o = result.getObject("createdAt");
				LocalDateTime localDateTime = (LocalDateTime) o;
				Instant i = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
				
				genre.setCreatedAt(i);
				//System.out.println(dtf.format(i));
				
			}else {
				throw new GenreNotFoundException(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genre;
	}
	
	@Override
	public Genre save(Genre genre) {
		
		String sql = "insert into genre (name,description,isActive,createdAt) values (?,?,?,?)";
		
		try {
			Connection conn = connection;
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			statement.setString(1, genre.getName());
			statement.setString(2, genre.getDescription());
			statement.setBoolean(3, genre.getIsActive());
			statement.setObject(4, genre.getCreatedAt());
			statement.executeUpdate();
			
			ResultSet result = statement.getGeneratedKeys();
			if(result.next()) {
				Long Id = result.getLong(1);
				genre = findById(Id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genre;
	}

	@Override
	public Genre update(Genre genre) {
		
		String sql = "update genre set name = ?, description = ? where id = ?";
		Genre genreNow = new Genre();
		
		try {
			genreNow = this.findById(genre.getId());
			genreNow.setName(genre.getName());
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, genreNow.getName());
			if(genre.getDescription() != null) {
				genreNow.setDescription(genre.getDescription());
				statement.setString(2, genreNow.getDescription());
			}else {
				statement.setString(2, genreNow.getDescription());
			}
			statement.setLong(3, genreNow.getId());
			
			statement.executeUpdate();
			
			genreNow = this.findById(genre.getId());
			
			
		}catch(GenreNotFoundException e) {
			 e.getMessage();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return genreNow;
	}
	
	@Override
	public void delete(Long id) {
		
		String sql = "delete from genre where id = ?";
		
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
