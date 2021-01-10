package com.justinmechanye.cs.cswebservices.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.justinmechanye.cs.cswebservices.Models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
	public List<Comment> findAllByMovieId(Integer movieId);
}
