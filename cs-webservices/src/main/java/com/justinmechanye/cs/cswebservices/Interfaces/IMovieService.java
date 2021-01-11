package com.justinmechanye.cs.cswebservices.Interfaces;

import java.util.List;

import com.justinmechanye.cs.cswebservices.Models.MovieDetails;
import com.justinmechanye.cs.cswebservices.Models.MovieSimple;

public interface IMovieService {
	public MovieDetails getMovieDetails(Integer id);
	public List<MovieSimple> getMovieList();
}
