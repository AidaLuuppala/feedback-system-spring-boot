package com.project.feedbacksystem.domain;

import java.util.List;

public interface FeedbackDAO {

	public void save(Feedback feedback);
	
	public Feedback findOne(int feedback_id);
	
	public List<Feedback> findAll();

	public List<Feedback> search(String searchWord);

	public void delete(Feedback feedback);

	public void update(Feedback feedback);

}
