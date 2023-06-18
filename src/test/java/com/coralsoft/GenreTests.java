package com.coralsoft;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.coralsoft.domain.entity.Genre;
import com.coralsoft.domain.exception.GenreNotFoundException;
import com.coralsoft.useCase.GenreUseCase;

public class GenreTests {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GenreTests.class);
	private GenreUseCase repository = new GenreUseCase();
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssz").withZone(ZoneId.systemDefault());


	@Test
	void findAllGenres() throws Exception {
		List<Genre> genres = repository.findAll();
		Assertions.assertNotNull(genres);
		logger.info("Genres-> {}",genres.stream().map(x-> x.getName()).collect(Collectors.toList()));
	}

	@Test
	void findByIdGenre() {
		Genre genre = repository.findById(1L);
		Assertions.assertEquals("Animação", genre.getName());
		logger.info("ID-> {} ,Name-> {}, isActive-> {}, createdAt-> {}",genre.getId(), genre.getName(),genre.getIsActive(),dtf.format(genre.getCreatedAt()));
	}

	@Test
	void saveGenre() {
		Genre genre = new Genre("TesteSave");
		genre = repository.save(genre);
		Assertions.assertEquals("TesteSave", genre.getName());
		logger.info("ID-> {},Name-> {}", genre.getId(),genre.getName());
	}

	@Test
	void updateGenre() {
		Genre genre = new Genre("TestUpdate");
		genre.setDescription("OPCIONAL");
		genre.setId(5L);
		Genre genreToTest = repository.update(genre);
		Assertions.assertEquals("TestUpdate", genreToTest.getName());
		logger.info("Expected-> {}, Result-> {}", genre.getName(),genreToTest.getName());
	}

	@Test
	void deleteGenre_But_Expected_Throw_Exception() {
		Assertions.assertThrows(GenreNotFoundException.class, ()->repository.delete(315L));
		logger.info("Expected-> Throws GenreNotFoundException");
	}

	@Test
	void deleteGenre() {
		Genre genreTeste = new Genre("TesteDelete");
		genreTeste = this.repository.save(genreTeste);

		this.repository.delete(genreTeste.getId());
		logger.info("Expected-> Delete genre");
	}
}
