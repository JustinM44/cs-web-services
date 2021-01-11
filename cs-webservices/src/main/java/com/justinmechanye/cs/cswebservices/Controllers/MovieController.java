package com.justinmechanye.cs.cswebservices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justinmechanye.cs.cswebservices.Models.MovieDetails;
import com.justinmechanye.cs.cswebservices.Models.MovieSimple;
import com.justinmechanye.cs.cswebservices.Services.CommentReviewService;
import com.justinmechanye.cs.cswebservices.Services.MovieService;

@RestController
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentReviewService crs;
	
	@GetMapping(value="/getMovie/{id}")
	public MovieDetails getMovie(@PathVariable Integer id) {
		return movieService.getMovieDetails(id);
	}
	
	@GetMapping(value="/getMovies")
	public List<MovieSimple> getMoviesList(){
		return movieService.getMovieList();
	}
	
	@PostMapping(value="/submitcomment")
	public String submitNewComment() {
		return crs.submitComment("This is a test upload", 1, 1, 0);
	}
	
}
