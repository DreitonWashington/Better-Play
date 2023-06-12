package com.coralsoft.domain.repository;

import java.util.List;

import com.coralsoft.domain.entity.Category;

public interface CategoryRepository {
	
	public List<Category> findAll() throws Exception;
	public Category findById(Long id);
	public Category save(Category category);
	public Category update(Category category);
	public void delete(Long id);
}
