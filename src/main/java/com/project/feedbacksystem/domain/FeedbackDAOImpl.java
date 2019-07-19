package com.project.feedbacksystem.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// repository class for the database queries
@Repository
public class FeedbackDAOImpl implements FeedbackDAO {
	
	// use jdbc template to execute the database queries
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// save feedback to the database
	public void save(Feedback feedback) {
		String sql = "insert into feedback(feedback_date, feedback_type, feedback_giver_type, feedback_topic, feedback_status, feedback_text, wants_contact, language, contact_firstname, contact_lastname, contact_email, contact_mobile) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] parameters = new Object[] {
				feedback.getFeedback_date(),
				feedback.getFeedback_type(),
				feedback.getFeedback_giver_type(),
				feedback.getFeedback_topic(),
				feedback.getFeedback_status(),
				feedback.getFeedback_text(),
				feedback.isWants_contact(),
				feedback.getLanguage(),
				feedback.getContact_firstname(),
				feedback.getContact_lastname(),
				feedback.getContact_email(),
				feedback.getContact_mobile() };
		jdbcTemplate.update(sql, parameters);
	}

	// find one feedback to edit based on feedback_id
	public Feedback findOne(int feedback_id) {
		String sql = "select feedback_id, feedback_date, feedback_type, feedback_giver_type, feedback_topic, feedback_status, feedback_text, wants_contact, language, contact_firstname, contact_lastname, contact_email, contact_mobile from feedback where feedback_id = ?";
		Object[] parameters = new Object[] { feedback_id };
		RowMapper<Feedback> mapper = new FeedbackRowMapper();
		Feedback feedback = jdbcTemplate.queryForObject(sql, parameters, mapper);
		return feedback;
	}

	// find all feedbacks for admins to feedbacks page
	public List<Feedback> findAll() {
		String sql = "select feedback_id, feedback_date, feedback_type, feedback_giver_type, feedback_topic, feedback_status, feedback_text, wants_contact, language, contact_firstname, contact_lastname, contact_email, contact_mobile from feedback";
		RowMapper<Feedback> mapper = new FeedbackRowMapper();
		List<Feedback> feedbacks = jdbcTemplate.query(sql, mapper);
		return feedbacks;
	}

	// search for admins
	public List<Feedback> search(String searchWord) {
		String sql = "";
		Object[] parameters = null;
		
		//if searchWord is in full date format, convert to Date, so that we can query it from database
		boolean isDate = isDate(searchWord);
		if(isDate) {
			try {
				Date date = new SimpleDateFormat("dd.MM.yyyy").parse(searchWord);
				sql = "select * from feedback where feedback_date=?";
				parameters = new Object[] { date };
			} catch (ParseException e) {
				e.printStackTrace();
			}
		//search other fields with wildcards
		}else {
		sql = "select * from feedback where feedback_id::text LIKE ? or feedback_date::text LIKE ? or feedback_type ILIKE ? or feedback_giver_type ILIKE ? or feedback_topic ILIKE ? or feedback_status ILIKE ? or feedback_text ILIKE ? or wants_contact::text ILIKE ? or language ILIKE ? or contact_firstname ILIKE ? or contact_lastname ILIKE ? or contact_email ILIKE ? or contact_mobile ILIKE ?";
		parameters = new Object[] {
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%",
				"%" + searchWord + "%" };
		}
		RowMapper<Feedback> mapper = new FeedbackRowMapper();
		List<Feedback> feedbacks = jdbcTemplate.query(sql, parameters, mapper);
		return feedbacks;
	}
	
	// check if searchWord is a date
	public static boolean isDate(String searchWord) {
	    try {
	    	Date date = new SimpleDateFormat("dd.MM.yyyy").parse(searchWord);
	    } catch (ParseException e) {
	        return false;
	    }
	    return true;
	}

	// delete feedback from database
	public void delete(Feedback feedback) {
		String sql = "DELETE FROM feedback WHERE feedback_id = ?";
		Object[] parameters = new Object[] { feedback.getFeedback_id() };
		jdbcTemplate.update(sql, parameters);
	}
	
	// update feedback information to the database
	public void update(Feedback feedback) {
		String sql = "UPDATE feedback SET feedback_date = ?, feedback_type = ?, feedback_giver_type = ?, feedback_topic = ?, feedback_text = ?, feedback_status = ?, wants_contact = ?, language = ?, contact_firstname = ?, contact_lastname = ?, contact_email = ?, contact_mobile = ? WHERE feedback_id = ?";
		Object[] parameters = new Object[] {
				feedback.getFeedback_date(),
				feedback.getFeedback_type(),
				feedback.getFeedback_giver_type(),
				feedback.getFeedback_topic(),
				feedback.getFeedback_text(),
				feedback.getFeedback_status(),
				feedback.isWants_contact(),
				feedback.getLanguage(),
				feedback.getContact_firstname(),
				feedback.getContact_lastname(),
				feedback.getContact_email(),
				feedback.getContact_mobile(),
				feedback.getFeedback_id() };
		jdbcTemplate.update(sql, parameters);
	}
}
