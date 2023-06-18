package com.coralsoft.domain.repository;

import java.util.List;

import com.coralsoft.domain.entity.Comment;

public interface CommentRepository {

	public List<Comment> findAll() throws Exception;
	public Comment findById(Long id);
	public Comment save(Comment comment);
	public Comment update(Comment comment);
	public void delete(Long id);
}
