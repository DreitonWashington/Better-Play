package com.coralsoft.useCase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.coralsoft.connection.SingleConnectionDB;
import com.coralsoft.domain.entity.User;
import com.coralsoft.domain.exception.UserNotFoundException;
import com.coralsoft.domain.repository.UserRepository;

public class UserUseCase implements UserRepository{

	Connection connection = SingleConnectionDB.getConnection();
	
	@Override
	public boolean authenticate(User user) {
		
		String sql = "select * from users where email = ? and password = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> findAll() throws Exception {

		List<User> users = new ArrayList<>();
		String sql = "select * from users";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				User user = new User();
				user.setId(result.getLong("id"));
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));

				users.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findById(Long id) {

		User user = new User();
		String sql = "select * from users where id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();

			if(result.next()) {
				user.setId(result.getLong("id"));
				user.setEmail(result.getString("email"));
				user.setPassword(result.getString("password"));
			}else {
				throw new UserNotFoundException(id);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User save(User user) {

		String sql = "insert into users (email,password) values (?,?)";

		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			String encodePassword = Base64.getEncoder().encodeToString((user.getPassword()).getBytes());
			statement.setString(1, user.getEmail());
			statement.setString(2, encodePassword);
			statement.executeUpdate();

			ResultSet result = statement.getGeneratedKeys();
			if(result.next()) {
				user.setId(result.getLong(1));
			}
			user = this.findById(user.getId());

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User update(User user) {

		User userNow = new User();
		String sql = "update users set email = ?, password = ? where id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			String encodePassword = Base64.getEncoder().encodeToString((user.getPassword()).getBytes());
			userNow = this.findById(user.getId());

			statement.setString(1, user.getEmail());
			statement.setString(2, encodePassword);
			statement.setLong(3, userNow.getId());
			statement.executeUpdate();

			ResultSet result = statement.getGeneratedKeys();
			if(result.next()) user = this.findById(result.getLong(1));

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Long id) {

		String sql = "delete from users where id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
