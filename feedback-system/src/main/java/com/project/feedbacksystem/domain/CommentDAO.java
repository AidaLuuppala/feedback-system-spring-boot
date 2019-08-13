package com.project.feedbacksystem.domain;

import java.util.List;

//list of methods used for database queries
//use this interface to call those methods
public interface CommentDAO {
	
	public void save(Comment comment);
	
	public List<Comment> findAll(long feedback_id);

}
