package com.justinmechanye.cs.cswebservices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.justinmechanye.cs.cswebservices.Interfaces.IMovieService;
import com.justinmechanye.cs.cswebservices.Models.CommentModels.Comment;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.MovieDetails;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.MovieSimple;
import com.justinmechanye.cs.cswebservices.Repositories.MovieDetailsRepository;
import com.justinmechanye.cs.cswebservices.Repositories.MovieRepository;

@Component
public class MovieService implements IMovieService {
	@Autowired
	private MovieDetailsRepository movieDetailsRepo;
	
	@Autowired
	private MovieRepository movieRepo;
	
	@Override
	public MovieDetails getMovieDetails(Integer id) {
		Optional<MovieDetails> md = this.movieDetailsRepo.findById(id);
		return md.get();
	}

	@Override
	public List<MovieSimple> getMovieList() {
		List<MovieSimple> movieList = this.movieRepo.findAll();
		return movieList;
	}
	
	public List<MovieSimple> getMoviesFromSearch(String keyword){
		List<MovieSimple> movieList = this.movieRepo.search(keyword);
		return movieList;
	}
	
	public MovieDetails updateCollectiveRaiting(MovieDetails md) {
		double overallRaiting;
		double totalRaiting = 0;
		if(md.getComments().size() >= 1) {
			for(Comment comment: md.getComments()){
				totalRaiting += comment.getRaiting();
			}
			overallRaiting = totalRaiting/md.getComments().size();
			md.setOverallRaiting(overallRaiting);
			this.movieDetailsRepo.save(md);
			return md;
		} else {
			md.setOverallRaiting(0);
			this.movieDetailsRepo.save(md);
			return md;
		}
	}

}
