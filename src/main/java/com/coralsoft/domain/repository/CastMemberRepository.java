package com.coralsoft.domain.repository;

import java.util.List;

import com.coralsoft.domain.entity.CastMember;

public interface CastMemberRepository {
	
	public List<CastMember> findAll() throws Exception;
	public CastMember findById(Long id);
	public CastMember save(CastMember castMember);
	public CastMember update(CastMember castMember);
	public void delete(Long id);

}
