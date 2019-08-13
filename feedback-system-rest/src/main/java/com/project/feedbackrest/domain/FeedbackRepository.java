package com.project.feedbackrest.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {

	@Override
	<S extends Feedback> S save(S entity);

}
