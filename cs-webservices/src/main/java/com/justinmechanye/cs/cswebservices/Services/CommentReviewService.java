package com.justinmechanye.cs.cswebservices.Services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.justinmechanye.cs.cswebservices.Interfaces.ICommentReviewService;
import com.justinmechanye.cs.cswebservices.Models.CommentModels.Comment;
import com.justinmechanye.cs.cswebservices.Models.CommentModels.CommentInput;
import com.justinmechanye.cs.cswebservices.Repositories.CommentRepository;

@Component
public class CommentReviewService implements ICommentReviewService{

	@Autowired
	private CommentRepository commentRepo;

	@Override
	public String updateCommentRaiting(Comment comment) {
		commentRepo.save(comment);
		return "comment Updated";
		
	}

	@Override
	public String submitComment(CommentInput comment) {
		Comment newComment = new Comment();
		
		newComment.setComment(comment.getComment());
		newComment.setMovieId(comment.getMovieid());
		newComment.setRaiting(comment.getRating());
		newComment.setUser(comment.getUser());
		
		commentRepo.save(newComment);
		
		return "Comment Submited";
	}

}
