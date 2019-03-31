package com.hockeyforum.hockeyforum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hockeyforum.hockeyforum.models.Comment;
import com.hockeyforum.hockeyforum.models.Post;
import com.hockeyforum.hockeyforum.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CommentTest {
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

		Comment comment = new Comment("Test Comment");
		post.addComment(comment);
		postRepo.save(post);
		
		Long idToFind = 1L;
		Post postFromDB = postRepo.findById(idToFind).get();

		Collection<Comment> comments = postFromDB.getComment();
		for (Comment commentItem : comments) {
			assertThat(commentItem.getCommentContent(), is("Test Comment"));
		}
		

	}
}