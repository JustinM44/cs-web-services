package com.justinmechanye.cs.cswebservices.Interfaces;

public interface ICommentReviewService {
	public String submitComment(String Comment, Integer movieId, Integer userId, Integer rating);
	public void submitRating(int numberOfStars);
}
