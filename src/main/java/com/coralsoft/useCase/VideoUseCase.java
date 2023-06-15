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
import com.coralsoft.domain.entity.Video;
import com.coralsoft.domain.enums.Censure;
import com.coralsoft.domain.exception.VideoNotFoundException;
import com.coralsoft.domain.repository.VideoRepository;
import com.coralsoft.domain.valueObject.Image;
import com.coralsoft.domain.valueObject.Media;

public class VideoUseCase implements VideoRepository{
	
	Connection connection = SingleConnectionDB.getConnection();

	@Override
	public List<Video> findAll() throws Exception {
		
		List<Video> listVideos = new ArrayList<>();
		String sql = "select * from videos";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Video video = new Video();
				Image image = new Image();
				Media media = new Media();
				
				video.setId(result.getLong("id"));
				video.setTitle(result.getString("title"));
				video.setDescription(result.getString("description"));
				video.setYearLaunched(result.getInt("year_launched"));
				video.setDuration(result.getInt("duration"));
				video.setRating(result.getInt("rating"));
				video.setCensure(censura(result.getString("censure")));
				video.setPublished(result.getBoolean("published"));
				
				image.setFilePath(result.getString("thumb_file"));
				video.setThumbFile(image);
				
				image.setFilePath(result.getString("thumb_half"));
				video.setThumbHalf(image);
				
				image.setFilePath(result.getString("banner_file"));
				video.setBannerFile(image);
				
				media.setFilePath(result.getString("trailer_file"));
				video.setTrailerFile(media);
				
				media.setFilePath(result.getString("video_file"));
				video.setVideoFile(media);
				
				Object o = result.getObject("createdAt");
				LocalDateTime date = (LocalDateTime) o;
				Instant instant = Instant.from(date.atZone(ZoneId.systemDefault()));
				
				video.setCreatedAt(instant);
				listVideos.add(video);
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return listVideos;
	}

	@Override
	public Video findById(Long id) {
	
		Video video = new Video();
		Image image = new Image();
		Media media = new Media();
		
		String sql = "select * from videos where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				video.setId(result.getLong("id"));
				video.setTitle(result.getString("name"));
				video.setDescription(result.getString("description"));
				video.setYearLaunched(result.getInt("year_launched"));
				video.setDuration(result.getInt("duration"));
				video.setRating(result.getInt("rating"));
				video.setCensure(censura(result.getString("censure")));
				video.setPublished(result.getBoolean("published"));
				
				if(result.getObject("createdAt") != null) {
					Object o = result.getObject("createdAt");
					LocalDateTime date = (LocalDateTime) o;
					Instant instant = Instant.from(date.atZone(ZoneId.systemDefault()));
					
					video.setCreatedAt(instant);					
				}
				
				image.setFilePath(result.getString("thumb_file"));
				video.setThumbFile(image);
				image.setFilePath(result.getString("thumb_half"));
				video.setThumbHalf(image);
				image.setFilePath(result.getString("banner_file"));
				video.setBannerFile(image);
				
				media.setFilePath(result.getString("trailer_file"));
				video.setTrailerFile(media);
				media.setFilePath(result.getString("video_file"));
				video.setVideoFile(media);
			}else {
				throw new VideoNotFoundException(id);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return video;
	}

	@Override
	public Video save(Video video) {
		
		String sql = "insert into videos (title, description, yearLaunched, duration, rating, censure,"
				+ "published, createdAt, thumbFile, thumbHalf, bannerFile,"
				+ "trailerFile, videoFile) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, video.getTitle());
			statement.setString(2, video.getDescription());
			statement.setInt(3, video.getYearLaunched());
			statement.setInt(4, video.getDuration());
			statement.setInt(5, video.getRating());
			statement.setString(6, video.getCensure().name());
			statement.setBoolean(7, video.isPublished());
			statement.setObject(8, video.getCreatedAt());
			statement.setString(9, video.getThumbFile().getFilePath());
			statement.setString(10, video.getThumbHalf().getFilePath());
			statement.setString(11, video.getBannerFile().getFilePath());
			statement.setString(12, video.getTrailerFile().getFilePath());
			statement.setString(13, video.getVideoFile().getFilePath());
			
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			
			video = this.findById(result.getLong(1));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return video;
	}

	@Override
	public Video update(Video video) {
		
		Video videoNow = new Video();
		String sql = "update videos set title = ?, description = ?, yearLaunched = ?, duration = ?, "
				+ "rating = ?, censure = ?, thumbFile = ?, thumbHalf = ?"
				+ ", bannerFile = ?, trailerFile = ?, videoFile = ? where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			videoNow = this.findById(video.getId());
			
			if(video.getTitle() != null ) videoNow.setTitle(video.getTitle());
			if(video.getDescription() != null ) videoNow.setDescription(video.getDescription());
			if(video.getYearLaunched() != videoNow.getYearLaunched()) videoNow.setYearLaunched(video.getYearLaunched());
			if(video.getDuration() != videoNow.getDuration()) videoNow.setDuration((video.getDuration()));
			if(video.getRating() != videoNow.getRating()) videoNow.setRating(video.getRating());
			if(video.getCensure() != null ) videoNow.setCensure(video.getCensure());
			if(video.getThumbFile() != null) videoNow.setThumbFile(video.getThumbFile());
			if(video.getThumbHalf() != null) videoNow.setThumbHalf(video.getThumbHalf());
			if(video.getBannerFile() != null) videoNow.setBannerFile(video.getBannerFile());
			if(video.getTrailerFile() != null) videoNow.setTrailerFile(video.getTrailerFile());
			if(video.getVideoFile() != null) videoNow.setVideoFile(video.getVideoFile());
			
			statement.setString(1, videoNow.getTitle());
			statement.setString(2, videoNow.getDescription());
			statement.setInt(3, videoNow.getYearLaunched());
			statement.setInt(4, videoNow.getDuration());
			statement.setInt(5, videoNow.getRating());
			statement.setString(6, videoNow.getCensure().name());
			statement.setString(7, videoNow.getThumbFile().getFilePath());
			statement.setString(8, videoNow.getThumbHalf().getFilePath());
			statement.setString(9, videoNow.getBannerFile().getFilePath());
			statement.setString(10, videoNow.getTrailerFile().getFilePath());
			statement.setString(11, videoNow.getVideoFile().getFilePath());
			statement.setLong(12, video.getId());
			
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			
			video = this.findById(result.getLong(1));
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return video;
	}

	@Override
	public void delete(Long id) {
		
		String sql = "delete from videos where id = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Censure censura(String censura) {
		Censure censure = null;
		switch(censura) {
			case "L":
				censure = Censure.L;
				break;
			case "CENSURA_10":
				censure = Censure.CENSURA_10;
				break;
			case "CENSURA_12":
				censure = Censure.CENSURA_12;
				break;
			case "CENSURA_14":
				censure = Censure.CENSURA_14;
				break;
			case "CENSURA_16":
				censure = Censure.CENSURA_16;
				break;
			case "CENSURA_18":
				censure = Censure.CENSURA_18;
				break;
		}
		return censure;
	}
	
	

}
