package com.justinmechanye.cs.cswebservices.Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.justinmechanye.cs.cswebservices.Interfaces.ICommentReviewService;
import com.justinmechanye.cs.cswebservices.Models.Comment;
import com.justinmechanye.cs.cswebservices.Repositories.CommentRepository;

@Component
public class CommentReviewService implements ICommentReviewService{

	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public String submitComment(String Comment, Integer movieId, Integer userId, Integer rating) {
		Comment newComment = new Comment();
		
		newComment.setComment(Comment);
		newComment.setMovieId(movieId);
		newComment.setRating(rating);
		newComment.setUserId(userId);
		
		commentRepo.save(newComment);
		
		return "Comment Submited";
		
	}

	@Override
	public void submitRating(int numberOfStars) {
		// TODO Auto-generated method stub
		
	}

}
