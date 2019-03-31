package com.hockeyforum.hockeyforum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hockeyforum.hockeyforum.models.Category;
import com.hockeyforum.hockeyforum.repositories.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Resource
	private TestEntityManager entityManager;

	@Resource
	CategoryRepository catRepo;

	@Test
	public void shouldAddAndGetCategory() {
		Category category = catRepo.save(new Category("Name"));

		entityManager.persist(category);
		entityManager.flush();
		entityManager.clear();

		Long idToFind = 1L;
		Category categoryFromDB = catRepo.findById(idToFind).get();

		assertThat(categoryFromDB.getTitle(), is("Name"));

	}
}
