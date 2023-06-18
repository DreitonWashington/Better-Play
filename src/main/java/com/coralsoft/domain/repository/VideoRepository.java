package com.coralsoft.domain.repository;

import java.util.List;

import com.coralsoft.domain.entity.Video;

public interface VideoRepository {

	public List<Video> findAll() throws Exception;
	public Video findById(Long id);
	public Video save(Video video);
	public Video update(Video video);
	public void delete(Long id);
}
