package com.coralsoft.domain.repository;

import java.util.List;

import com.coralsoft.domain.entity.Genre;

public interface GenreRepository {
	
	public List<Genre> findAll() throws Exception;
	public Genre findById(Long id);
	public Genre save(Genre genre);
	public Genre update(Genre genre);
	public void delete(Long id);
}
