package com.coralsoft.domain.entity;

import java.time.Instant;
import java.util.Objects;

public class Genre {

	private Long id;
	private String name;
	private String description;
	private boolean isActive = true;
	private Instant createdAt = Instant.now();

	public Genre() {
	}

	public Genre(Long id, String name, String description, boolean isActive, Instant createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	public Genre(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsActive() {
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
		Genre other = (Genre) obj;
		return Objects.equals(id, other.id);
	}

}
