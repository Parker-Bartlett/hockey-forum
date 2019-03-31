package com.hockeyforum.hockeyforum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hockeyforum.hockeyforum.models.Post;
import com.hockeyforum.hockeyforum.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PostRepositoryTest {
	@Resource
	private TestEntityManager entityManager;

	@Resource
	PostRepository postRepo;

	@Test
	public void shouldAddAndGetPost() {
		Post post = postRepo.save(new Post("Name", "Body", null));

		entityManager.persist(post);
		entityManager.flush();
		entityManager.clear();

		Long idToFind = 1L;
		Post postFromDB = postRepo.findById(idToFind).get();

		assertThat(postFromDB.getTitle(), is("Name"));
		assertThat(postFromDB.getBody(), is("Body"));

	}
}