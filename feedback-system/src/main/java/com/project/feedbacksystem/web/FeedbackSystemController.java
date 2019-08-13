package com.project.feedbacksystem.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.feedbacksystem.domain.Comment;
import com.project.feedbacksystem.domain.CommentDAO;
import com.project.feedbacksystem.domain.Feedback;
import com.project.feedbacksystem.domain.FeedbackDAO;

//controller class for site mapping
@Controller
public class FeedbackSystemController {
	
	@Autowired
	private FeedbackDAO feedbackDAO;
	// use FeedbackDAO interface to call FeedbackDAOImpl database query methods
	
	@Autowired
	private CommentDAO commentDAO;
	// use CommentDAO interface to call CommentDAOImpl database query methods
	
	// login page
    @RequestMapping(value="/login")
    public String login() {
    	 return "login";
    }
    
    // after login redirect to feedbacks page
    @RequestMapping(value="/")
    public String loggedIn() {
    	 return "redirect:feedbacks";
    }
    
    // logout
    @RequestMapping(value="/logout")
    public String logOut() {
    	 return "redirect:login";
    }
	
	@RequestMapping(value="/feedbacks")
	public String listFeedbacks(Model model) throws ParseException {
		// fetch all feedbacks
		List<Feedback> feedbacks = feedbackDAO.findAll(); // find all feedbacks
		// add feedbacks to model
		model.addAttribute("feedbacks", feedbacks);
		// return view name
		return "feedbacks";
	}
	
	// add new feedback and create new Feedback object
	@RequestMapping(value="/add")
	public String addFeedback(Model model) {
		model.addAttribute("feedback", new Feedback());
		// return the feedback form
		return "feedbackform";
	}
	
	// return the success page
	@GetMapping(value="/success")
	public String getSuccessPage() {
		return "success";
	}
	
	// save feedback when submit button is clicked
	@PostMapping("/save")
	public ModelAndView save(@Valid Feedback feedback, BindingResult bindingResult) {
	
		if(bindingResult.hasErrors()) {
			return new ModelAndView("feedbackform");
		};
		feedbackDAO.save(feedback);
		
		// returns to success page
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/success");
		return new ModelAndView(redirect);

	}
	
	// search feedbacks with searchword
	@PostMapping("/search")
	public String search(@RequestParam("searchWord") String searchWord, Model model) {
		// if searchWord is 'search', that means that search button is clicked without a searchWord,
		if( searchWord.equals("search") ){
			List<Feedback> feedbacks = feedbackDAO.findAll(); // so find all feedbacks 
			model.addAttribute("feedbacks", feedbacks);
			return "feedbacks";
	    } else { // otherwise searchWord is given,
	    	List<Feedback> feedbacks = feedbackDAO.search(searchWord); //so search with searchWord
			model.addAttribute("feedbacks", feedbacks);
			return "search_result";
	    }
	}
	
	// find one feedback to edit based on feedback_id
	@PostMapping("/edit")
	public String findOne(@RequestParam("feedback_id") long feedback_id, ModelMap map) {
		//hae kaikki commentit
		Feedback feedback = feedbackDAO.findOne(feedback_id);
		List<Comment> comments = commentDAO.findAll(feedback_id);
		map.addAttribute("feedback", feedback);
		map.addAttribute("comments", comments);
		map.addAttribute("comment", new Comment());
		return "edit";
	}
	
	// update or delete feedback
	@PostMapping("/update")
	public String update(@RequestParam String action, @RequestParam("feedback_status") String feedback_status, Comment comment){
		// if update button is clicked
		long feedback_id = comment.getFeedback_id();
		if( action.equals("Tallenna") ){
			feedbackDAO.update(feedback_id, feedback_status); // update status
			commentDAO.save(comment);
		}else if( action.equals("Poista") ){ // if delete button is clicked
			feedbackDAO.delete(feedback_id); // delete feedback 
		}
		return "redirect:feedbacks"; //in all cases redirect back to feedbacks
	} 

	// format date for submitting
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd.MM.yyyy"), true, 10));   
	}

}
