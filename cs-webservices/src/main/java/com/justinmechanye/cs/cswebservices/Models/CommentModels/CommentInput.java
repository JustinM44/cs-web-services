package com.justinmechanye.cs.cswebservices.Models.CommentModels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.justinmechanye.cs.cswebservices.Models.UserModels.UserShort;


public class CommentInput {
	
	private UserShort user;
	private String comment;
	private Integer raiting;
	private Integer movieId;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getRaiting() {
		return raiting;
	}
	public void setRaiting(Integer rating) {
		this.raiting = rating;
	}
	
	public Integer getMovieid() {
		return movieId;
	}
	public void setMovieid(Integer movieid) {
		this.movieId = movieid;
	}
	public UserShort getUser() {
		return user;
	}
	public void setUser(UserShort user) {
		this.user = user;
	}
}
