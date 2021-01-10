package com.justinmechanye.cs.cswebservices.Interfaces;

public interface ICommentReviewService {
	public void submitComment(String Comment);
	public void submitRating(int numberOfStars);
}
