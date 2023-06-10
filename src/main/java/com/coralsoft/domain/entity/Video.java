package com.coralsoft.domain.entity;

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.print.attribute.standard.Media;

import com.coralsoft.domain.enums.Censure;

public class Video {
	
	private Long id;
	private String title;
	private String description;
	private int yearLaunched;
	private int duration;
	private boolean opened = false;
	private int rating;
	private Censure censure;
	private boolean published;
	private LocalDateTime createdAt;
	private Image thumbFile;
	private Image thumbHalf;
	private Image bannerFile;
	private Media trailerFile;
	private Media videoFile;
	
	private List<Category> categoriesId = new ArrayList<>();
	private List<Genre> genresId = new ArrayList<>();
	private List<CastMember> castMembersId = new ArrayList<>();
	private List<Comment> commentsId = new ArrayList<>();
	
	public Video() {
	}

	public Video(Long id, String title, String description, int yearLaunched, int duration, boolean opened, int rating,
			Censure censure, boolean published, LocalDateTime createdAt, Image thumbFile, Image thumbHalf,
			Image bannerFile, Media trailerFile, Media videoFile) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.yearLaunched = yearLaunched;
		this.duration = duration;
		this.opened = opened;
		this.rating = rating;
		this.censure = censure;
		this.published = published;
		this.createdAt = createdAt;
		this.thumbFile = thumbFile;
		this.thumbHalf = thumbHalf;
		this.bannerFile = bannerFile;
		this.trailerFile = trailerFile;
		this.videoFile = videoFile;
	}
	
	public void addCategory(Category categoryId) {
		this.categoriesId.add(categoryId);
	}
	
	public void removeCategory(Category category) {
		this.categoriesId.remove(category);
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

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
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
