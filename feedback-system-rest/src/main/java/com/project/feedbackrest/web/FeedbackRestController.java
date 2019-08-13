package com.project.feedbackrest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.feedbackrest.domain.Feedback;
import com.project.feedbackrest.domain.FeedbackRepository;

@RestController
@RequestMapping(path = "/api")
public class FeedbackRestController {
	
    FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackRestController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }
    
    protected FeedbackRestController() {

    }
	
	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveRest(@RequestBody Feedback feedback) {
		feedbackRepository.save(feedback);
	}

}
