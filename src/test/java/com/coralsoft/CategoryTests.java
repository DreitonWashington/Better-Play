package com.coralsoft;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.coralsoft.domain.entity.Category;
import com.coralsoft.domain.repository.CategoryRepository;
import com.coralsoft.useCase.CategoryUseCase;

public class CategoryTests {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GenreTests.class);
	CategoryRepository repository = new CategoryUseCase();

	@Test
	void findAllCategories() throws Exception {
		List<Category> categories = this.repository.findAll();
		Assertions.assertNotNull(categories);
		logger.info("Categories-> {}", categories.stream().map(x -> x.getName()).collect(Collectors.toList()));
	}

	@Test
	void findByIdCategory() {
		Category category = this.repository.findById(1L);
		Assertions.assertEquals("Filme", category.getName());
		logger.info("ID-> {}, Name-> {}, Description-> {}, IsActive-> {}, CreatedAt-> {}", category.getId(), category.getName()
				, category.getDescription(), category.getIsActive(), category.getCreatedAt());
	}

	@Test
	void saveCategory() {
		Category category = new Category();
		category.setName("Documentario");

		category = this.repository.save(category);
		Assertions.assertEquals("Documentario", category.getName());
		logger.info("ID-> {}, Name-> {}", category.getId(), category.getName());
	}

	@Test
	void updateCategory() {
		Category category = new Category();
		Category categoryFromDb = new Category();
		category.setId(4L);
		category.setName("Tv Show");
		category.setDescription("Shows like jornal");

		categoryFromDb = this.repository.update(category);
		Assertions.assertEquals(category.getName(), categoryFromDb.getName());
		logger.info("Expected ID-> {}, Name-> {}", categoryFromDb.getId(), categoryFromDb.getName());

	}

	@Test
	void deleteCategory() {
		Category categoryTest = new Category();
		categoryTest.setName("categoryTest");
		categoryTest = this.repository.save(categoryTest);

		this.repository.delete(categoryTest.getId());
		logger.info("Expected-> Delete category");
	}
}
