package com.coralsoft.domain.entity;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.coralsoft.domain.enums.Censure;
import com.coralsoft.domain.valueObject.Image;
import com.coralsoft.domain.valueObject.Media;

public class Video {
	
	private Long id;
	private String title;
	private String description;
	private Category category_id;
	private int yearLaunched;
	private int duration;
	private int rating;
	private Censure censure;
	private boolean published;
	private Instant createdAt = Instant.now();
	private Image thumbFile;
	private Image thumbHalf;
	private Image bannerFile;
	private Media trailerFile;
	private Media videoFile;
	
	private List<Genre> genresId = new ArrayList<>();
	private List<CastMember> castMembersId = new ArrayList<>();
	private List<Comment> commentsId = new ArrayList<>();
	
	public Video() {
	}

	public Video(Long id, String title, String description, Category category, int yearLaunched, int duration, int rating,
			Censure censure, boolean published, Image thumbFile, Image thumbHalf,
			Image bannerFile, Media trailerFile, Media videoFile) {

		this.id = id;
		this.title = title;
		this.description = description;
		this.category_id = category;
		this.yearLaunched = yearLaunched;
		this.duration = duration;
		this.rating = rating;
		this.censure = censure;
		this.published = published;
		this.thumbFile = thumbFile;
		this.thumbHalf = thumbHalf;
		this.bannerFile = bannerFile;
		this.trailerFile = trailerFile;
		this.videoFile = videoFile;
	}
	
	public void addGenre(Genre genre) {
		this.genresId.add(genre);
	}
	
	public void removeGenre(Genre genre) {
		this.genresId.remove(genre);
	}
	
	public void addCastMember(CastMember castMember) {
		this.castMembersId.add(castMember);
	}
	
	public void removeCastMember(CastMember castMember) {
		this.castMembersId.remove(castMember);
	}
	
	public void addComment(Comment comment) {
		this.commentsId.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.commentsId.remove(comment);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYearLaunched() {
		return yearLaunched;
	}

	public void setYearLaunched(int yearLaunched) {
		this.yearLaunched = yearLaunched;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Censure getCensure() {
		return censure;
	}

	public void setCensure(Censure censure) {
		this.censure = censure;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Image getThumbFile() {
		return thumbFile;
	}

	public void setThumbFile(Image thumbFile) {
		this.thumbFile = thumbFile;
	}

	public Image getThumbHalf() {
		return thumbHalf;
	}

	public void setThumbHalf(Image thumbHalf) {
		this.thumbHalf = thumbHalf;
	}

	public Image getBannerFile() {
		return bannerFile;
	}

	public void setBannerFile(Image bannerFile) {
		this.bannerFile = bannerFile;
	}

	public Media getTrailerFile() {
		return trailerFile;
	}

	public void setTrailerFile(Media trailerFile) {
		this.trailerFile = trailerFile;
	}

	public Media getVideoFile() {
		return videoFile;
	}

	public void setVideoFile(Media videoFile) {
		this.videoFile = videoFile;
	}

	public Category getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Category category_id) {
		this.category_id = category_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
