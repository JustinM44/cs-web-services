package com.justinmechanye.cs.cswebservices.Models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer movieid;
	private Integer userid;
	private String comment;
	private Integer rating;
	
	public Integer getId() {
		return id;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Integer getMovieId() {
		return movieid;
	}
	public void setMovieId(Integer movieId) {
		this.movieid = movieId;
	}
	public Integer getUserId() {
		return userid;
	}
	public void setUserId(Integer userId) {
		this.userid = userId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
