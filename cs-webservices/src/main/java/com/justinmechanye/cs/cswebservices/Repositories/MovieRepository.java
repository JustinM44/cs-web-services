package com.justinmechanye.cs.cswebservices.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.*;

public interface MovieRepository extends CrudRepository<MovieSimple, Integer> {
	public List<MovieSimple> findAll();
}
