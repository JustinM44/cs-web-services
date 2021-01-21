package com.justinmechanye.cs.cswebservices.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.*;

public interface MovieRepository extends CrudRepository<MovieSimple, Integer> {
	public List<MovieSimple> findAll();
	
	@Query(value ="SELECT * FROM movies m WHERE m.title LIKE %?1% OR m.genre LIKE %?1%", nativeQuery=true)
	public List<MovieSimple> search(String keyword);
}
