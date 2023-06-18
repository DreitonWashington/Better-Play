package com.coralsoft.domain.entity;

import java.time.Instant;
import java.util.Objects;


public class Comment {

	private Long id;
	private String description;
	private boolean isActive;
	private Instant createdAt;

	public Comment() {
	}

	public Comment(Long id, String description, boolean isActive, Instant createdAt) {
		super();
		this.id = id;
		this.description = description;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(id, other.id);
	}

}
