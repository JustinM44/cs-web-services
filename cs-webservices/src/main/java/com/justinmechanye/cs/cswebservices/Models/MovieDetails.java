package com.justinmechanye.cs.cswebservices.Models;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
//TODO build tables for this class
//@Entity
public class MovieDetails {
	//@Id
	private Integer id;
	private String description;
	private String title;
	private List<String> cast;
	private List<String> crew;
	private String genre;
	private Date releaseDate;
	private String Language;
	private Integer overallRating;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getCast() {
		return cast;
	}
	public void setCast(List<String> cast) {
		this.cast = cast;
	}
	public List<String> getCrew() {
		return crew;
	}
	public void setCrew(List<String> crew) {
		this.crew = crew;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	public Integer getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(Integer overallRating) {
		this.overallRating = overallRating;
	}
	
	
}
