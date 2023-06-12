package com.coralsoft.domain.entity;

import java.util.Objects;

import com.coralsoft.domain.enums.CastMemberType;

public class CastMember {
	
	private Long id;
	private String name;
	private CastMemberType type;
	
	public CastMember() {
	}

	public CastMember(Long id, String name, CastMemberType type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
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

	public CastMemberType getType() {
		return type;
	}

	public void setType(CastMemberType type) {
		this.type = type;
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
		CastMember other = (CastMember) obj;
		return Objects.equals(id, other.id);
	}
	
}
