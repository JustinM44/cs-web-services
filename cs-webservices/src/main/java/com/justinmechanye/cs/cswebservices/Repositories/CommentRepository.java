
  package com.justinmechanye.cs.cswebservices.Repositories;
  
  import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import
  com.justinmechanye.cs.cswebservices.Models.Comment;
  
  @Repository
  public interface CommentRepository extends CrudRepository<Comment, Integer> {
	 
  }
 
