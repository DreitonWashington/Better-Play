package com.coralsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.coralsoft.domain.entity.CastMember;
import com.coralsoft.domain.enums.CastMemberType;
import com.coralsoft.domain.exception.CastMemberNotFoundException;
import com.coralsoft.domain.repository.CastMemberRepository;
import com.coralsoft.useCase.CastMemberUseCase;

public class CastMemberTests {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GenreTests.class);
	CastMemberRepository repository = new CastMemberUseCase();

	@Test
	void findAllCastMembers() throws Exception {
		List<CastMember> castMembers = new ArrayList<>();
		castMembers = repository.findAll();
		Assertions.assertNotNull(castMembers);
		logger.info("CastMembers-> {}", castMembers.stream().map(x -> x.getName()).collect(Collectors.toList()));
	}

	@Test
	void findByIdCastMember() {
		CastMember castMember = repository.findById(1L);
		Assertions.assertEquals("Robert Denin", castMember.getName());
		logger.info("ID-> {}, Name-> {}, Type-> {}", castMember.getId(), castMember.getName()
				, castMember.getType().name());
	}

	@Test
	void saveCastMemberANDdelete() {
		CastMember castSave = new CastMember();
		castSave.setName("Test Save");
		castSave.setType(CastMemberType.ACTOR);

		castSave = repository.save(castSave);

		Assertions.assertEquals("Test Save", castSave.getName());
		repository.delete(castSave.getId());
		Long id = castSave.getId();
		Assertions.assertThrows(CastMemberNotFoundException.class, () -> repository.findById(id));
		logger.info("SavedCast ID-> {}, Name-> '{}' and Deleted throwing CastMemberNotFoundException to try findByID-> {} "
				+ "after deleted", castSave.getId(), castSave.getName(), id);
	}

	@Test
	void updateCastMember() {
		CastMember castMember = new CastMember();
		castMember.setId(3L);
		castMember.setName("Test Update");
		castMember.setType(CastMemberType.ACTOR);

		castMember = repository.update(castMember);
		Assertions.assertEquals("Test Update", castMember.getName());
		logger.info("Update Name-> {}", castMember.getName());
	}
}
