package com.coralsoft.domain.repository;

import java.util.List;

import com.coralsoft.domain.entity.User;

public interface UserRepository {

	public List<User> findAll() throws Exception;
	public User findById(Long id);
	public User save(User user);
	public User update(User user);
	public void delete(Long id);
}
