package com.project.feedbacksystem.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FeedbackRowMapper implements RowMapper<Feedback> {

	// go through database query result set rows and populate a new Feedback object with the data
	public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
		Feedback feedback = new Feedback();
		feedback.setFeedback_id(rs.getLong("feedback_id"));
		feedback.setFeedback_date(rs.getDate("feedback_date"));
		feedback.setFeedback_type(rs.getString("feedback_type"));
		feedback.setFeedback_giver_type(rs.getString("feedback_giver_type"));
		feedback.setFeedback_topic(rs.getString("feedback_topic"));
		feedback.setFeedback_status(rs.getString("feedback_status"));
		feedback.setFeedback_text(rs.getString("feedback_text"));
		feedback.setWants_contact(rs.getBoolean("wants_contact"));
		feedback.setIs_deleted(rs.getBoolean("is_deleted"));
		feedback.setLanguage(rs.getString("language"));
		feedback.setContact_firstname(rs.getString("contact_firstname"));
		feedback.setContact_lastname(rs.getString("contact_lastname"));
		feedback.setContact_email(rs.getString("contact_email"));
		feedback.setContact_mobile(rs.getString("contact_mobile"));
		return feedback;
	}
}
