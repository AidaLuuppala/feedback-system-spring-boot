package com.project.feedbacksystem.domain;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Feedback {
	private long feedback_id;
	
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date feedback_date;
	
	private String feedback_type, feedback_giver_type, feedback_topic, feedback_status, language;
	
	private String feedback_text; 
	
	private String contact_firstname;
	
	private String contact_lastname;
	
	private String contact_email;
	
	private String contact_mobile;
	
	private boolean wants_contact;
	
	public Feedback() {
		super();
	}

	public Feedback(long feedback_id, Date feedback_date, String feedback_type, String feedback_giver_type,
			String feedback_topic, String feedback_status, String language, String feedback_text,
			String contact_firstname, String contact_lastname, String contact_email, String contact_mobile,
			boolean wants_contact) {
		super();
		this.feedback_id = feedback_id;
		this.feedback_date = feedback_date;
		this.feedback_type = feedback_type;
		this.feedback_giver_type = feedback_giver_type;
		this.feedback_topic = feedback_topic;
		this.feedback_status = feedback_status;
		this.language = language;
		this.feedback_text = feedback_text;
		this.contact_firstname = contact_firstname;
		this.contact_lastname = contact_lastname;
		this.contact_email = contact_email;
		this.contact_mobile = contact_mobile;
		this.wants_contact = wants_contact;
	}

	public Feedback(Date feedback_date, String feedback_type, String feedback_giver_type, String feedback_topic,
			String feedback_status, String language, String feedback_text, String contact_firstname,
			String contact_lastname, String contact_email, String contact_mobile, boolean wants_contact) {
		super();
		this.feedback_date = feedback_date;
		this.feedback_type = feedback_type;
		this.feedback_giver_type = feedback_giver_type;
		this.feedback_topic = feedback_topic;
		this.feedback_status = feedback_status;
		this.language = language;
		this.feedback_text = feedback_text;
		this.contact_firstname = contact_firstname;
		this.contact_lastname = contact_lastname;
		this.contact_email = contact_email;
		this.contact_mobile = contact_mobile;
		this.wants_contact = wants_contact;
	}

	public Feedback(Date feedback_date, String feedback_type, String feedback_giver_type, String feedback_topic,
			String feedback_status, String language, String feedback_text, boolean wants_contact) {
		super();
		this.feedback_date = feedback_date;
		this.feedback_type = feedback_type;
		this.feedback_giver_type = feedback_giver_type;
		this.feedback_topic = feedback_topic;
		this.feedback_status = feedback_status;
		this.language = language;
		this.feedback_text = feedback_text;
		this.wants_contact = wants_contact;
	}

	public long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public Date getFeedback_date() {
		return feedback_date;
	}

	public void setFeedback_date(Date feedback_date) {
		this.feedback_date = feedback_date;
	}

	public String getFeedback_type() {
		return feedback_type;
	}

	public void setFeedback_type(String feedback_type) {
		this.feedback_type = feedback_type;
	}

	public String getFeedback_giver_type() {
		return feedback_giver_type;
	}

	public void setFeedback_giver_type(String feedback_giver_type) {
		this.feedback_giver_type = feedback_giver_type;
	}

	public String getFeedback_topic() {
		return feedback_topic;
	}

	public void setFeedback_topic(String feedback_topic) {
		this.feedback_topic = feedback_topic;
	}

	public String getFeedback_status() {
		return feedback_status;
	}

	public void setFeedback_status(String feedback_status) {
		this.feedback_status = feedback_status;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFeedback_text() {
		return feedback_text;
	}

	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}

	public String getContact_firstname() {
		return contact_firstname;
	}

	public void setContact_firstname(String contact_firstname) {
		this.contact_firstname = contact_firstname;
	}

	public String getContact_lastname() {
		return contact_lastname;
	}

	public void setContact_lastname(String contact_lastname) {
		this.contact_lastname = contact_lastname;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getContact_mobile() {
		return contact_mobile;
	}

	public void setContact_mobile(String contact_mobile) {
		this.contact_mobile = contact_mobile;
	}

	public boolean isWants_contact() {
		return wants_contact;
	}

	public void setWants_contact(boolean wants_contact) {
		this.wants_contact = wants_contact;
	}

	@Override
	public String toString() {
		return "Feedback [feedback_id=" + feedback_id + ", feedback_date=" + feedback_date + ", feedback_type="
				+ feedback_type + ", feedback_giver_type=" + feedback_giver_type + ", feedback_topic=" + feedback_topic
				+ ", feedback_status=" + feedback_status + ", language=" + language + ", feedback_text=" + feedback_text
				+ ", contact_firstname=" + contact_firstname + ", contact_lastname=" + contact_lastname
				+ ", contact_email=" + contact_email + ", contact_mobile=" + contact_mobile + ", wants_contact="
				+ wants_contact + "]";
	}
	
}