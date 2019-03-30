package com.hockeyforum.hockeyforum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockeyforum.hockeyforum.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
