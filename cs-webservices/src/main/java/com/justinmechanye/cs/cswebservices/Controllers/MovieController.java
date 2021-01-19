package com.justinmechanye.cs.cswebservices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justinmechanye.cs.cswebservices.Models.CommentModels.*;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.*;
import com.justinmechanye.cs.cswebservices.Services.CommentReviewService;
import com.justinmechanye.cs.cswebservices.Services.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentReviewService crs;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getMovie/{id}")
	public MovieDetails getMovie(@PathVariable Integer id) {
		return movieService.getMovieDetails(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value="/getMovies")
	public List<MovieSimple> getMoviesList(){
		return movieService.getMovieList();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/submitcomment")
	public String submitNewComment(@RequestBody CommentInput comment) {
		return crs.submitComment(comment);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/submitcommentupdate")
	public String updateComment(@RequestBody Comment comment) {
		return crs.updateCommentRaiting(comment);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteComponent/{id}")
	public String deleteComment(@PathVariable Integer id) {
		return crs.deleteComment(id);
	}
	
}
