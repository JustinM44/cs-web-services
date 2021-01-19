package com.justinmechanye.cs.cswebservices.Models.CommentModels;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

import com.justinmechanye.cs.cswebservices.Models.UserModels.UserShort;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer movieid;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "userid", referencedColumnName="id")
	private UserShort user; 
	private String comment;
	private Integer raiting;
	
	public Integer getId() {
		return id;
	}
	public Integer getRaiting() {
		return raiting;
	}
	public void setRaiting(Integer rating) {
		this.raiting = rating;
	}
	public Integer getMovieId() {
		return movieid;
	}
	public void setMovieId(Integer movieId) {
		this.movieid = movieId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public UserShort getUser() {
		return user;
	}
	public void setUser(UserShort user2) {
		this.user = user2;
	}
	

	
}
