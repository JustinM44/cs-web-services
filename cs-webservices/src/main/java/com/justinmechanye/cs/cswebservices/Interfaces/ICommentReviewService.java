package com.justinmechanye.cs.cswebservices.Interfaces;

import com.justinmechanye.cs.cswebservices.Models.CommentModels.Comment;
import com.justinmechanye.cs.cswebservices.Models.CommentModels.CommentInput;

public interface ICommentReviewService {
	public String submitComment(CommentInput requestBody);
	public String updateCommentRaiting(Comment comment);
}
