package com.justinmechanye.cs.cswebservices.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.justinmechanye.cs.cswebservices.Models.CommentModels.*;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.*;
import com.justinmechanye.cs.cswebservices.Services.CommentReviewService;
import com.justinmechanye.cs.cswebservices.Services.MovieService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CommentReviewService crs;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
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
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@GetMapping(value="/getMovies/{keyword}")
	public List<MovieSimple> getMoviesListFiltered(@PathVariable String keyword){
		return movieService.getMoviesFromSearch(keyword);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@PostMapping(value="/submitcomment")
	public String submitNewComment(@RequestBody CommentInput comment) {
		return crs.submitComment(comment);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@PostMapping(value="/submitcommentupdate")
	public String updateComment(@RequestBody Comment comment) {
		return crs.updateCommentRaiting(comment);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@PostMapping(value="/deleteComponent/{userId}")
	public ResponseEntity<String> deleteComment(@PathVariable Integer userId, @RequestBody Comment commentToDelete ) {
		if(commentToDelete.getUser().getId() == userId) {
			return new ResponseEntity<String>(crs.deleteComment(commentToDelete.getId()), HttpStatus.OK);
		}
		return new ResponseEntity<String>("You do not have authorization for this", HttpStatus.UNAUTHORIZED);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
	@PostMapping(value="/updateRaiting/")
	public ResponseEntity<MovieDetails> updateRaiting(@RequestBody MovieDetails movie ) {
		return new ResponseEntity<MovieDetails>(this.movieService.updateCollectiveRaiting(movie), HttpStatus.OK);
	}
	
}
