package com.project.feedbacksystem.domain;

import java.util.List;

// list of methods used for database queries
// use this interface to call those methods
public interface FeedbackDAO {

	public void save(Feedback feedback);
	
	public Feedback findOne(long feedback_id);
	
	public List<Feedback> findAll();

	public List<Feedback> search(String searchWord);

	public void delete(long feedback_id);

	public void update(long feedback_id, String feedback_status);

}
