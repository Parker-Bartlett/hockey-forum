package com.hockeyforum.hockeyforum.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hockeyforum.hockeyforum.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
