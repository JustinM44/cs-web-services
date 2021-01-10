package com.justinmechanye.cs.cswebservices.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.justinmechanye.cs.cswebservices.Models.MovieDetails;
import com.justinmechanye.cs.cswebservices.Models.User;

public interface MovieRepository extends CrudRepository<MovieDetails, Integer>{
	public MovieDetails findByMovieId(int id);
}
