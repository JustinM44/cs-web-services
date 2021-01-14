package com.justinmechanye.cs.cswebservices.Models.MovieModels;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.justinmechanye.cs.cswebservices.Models.CastCrewMember;
import com.justinmechanye.cs.cswebservices.Models.CommentModels.Comment;
//TODO build tables for this class
@Entity
@Table(name = "movies")
public class MovieDetails {
	@Id
	private Integer id;
	private String description;
	private String title;
	@OneToMany(mappedBy = "movieid")
	private List<CastCrewMember> crew; 
	private String genre;
	private Date releasedate;
	private String language;
	private Integer overallrating;
	
	@OneToMany(mappedBy = "movieid")
	private List<Comment> comments; 
	
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

	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Date getReleaseDate() {
		return releasedate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releasedate = releaseDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getOverallRating() {
		return this.overallrating;
	}
	public void setOverallRating(Integer overallRating) {
		this.overallrating = overallRating;
	}

	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<CastCrewMember> getCrew() {
		return crew;
	}
	public void setCrew(List<CastCrewMember> crew) {
		this.crew = crew;
	}
	
	
}
