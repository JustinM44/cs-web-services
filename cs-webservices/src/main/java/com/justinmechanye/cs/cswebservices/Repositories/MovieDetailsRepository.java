
  package com.justinmechanye.cs.cswebservices.Repositories;
  



import org.springframework.data.repository.CrudRepository;
import com.justinmechanye.cs.cswebservices.Models.MovieModels.*; 

  
public interface MovieDetailsRepository extends CrudRepository<MovieDetails,Integer>{ 
	  public MovieDetails findById(int id); 
 }
 