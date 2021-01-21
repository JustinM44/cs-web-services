
package com.justinmechanye.cs.cswebservices.Repositories;
  

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.justinmechanye.cs.cswebservices.Models.CommentModels.Comment;
  
  @Repository
  public interface CommentRepository extends CrudRepository<Comment, Integer> {
	
  }
 
