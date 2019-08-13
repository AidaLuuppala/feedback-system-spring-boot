package com.project.feedbackrest.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name= "feedback") // table name in the database
public class Feedback {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id", nullable = false, updatable = false)
	private long feedback_id;
	
	// date format so the date will be in right format
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	@Column(name = "feedback_date", nullable = false)
	private Date feedback_date;
	
	@Column(name = "feedback_type", nullable = false)
	private String feedback_type;
	
	@Column(name = "feedback_giver_type", nullable = false)
	private String feedback_giver_type;
	
	@Column(name = "feedback_topic", nullable = false)
	private String feedback_topic;
	
	@Column(name = "feedback_status", nullable = false)
	private String feedback_status;
	
	@Column(name = "language", nullable = false)
	private String language;

	@Column(name = "feedback_text", nullable = false)
	private String feedback_text;
	
	@Column(name = "contact_firstname")
	private String contact_firstname;
	
	@Column(name = "contact_lastname")
	private String contact_lastname;
	
	@Column(name = "contact_email")
	private String contact_email;
	
	@Column(name = "contact_mobile")
	private String contact_mobile;
	
	@Column(name = "wants_contact", nullable = false)
	private boolean wants_contact;
	
	@Column(name = "is_deleted", nullable = false)
	private boolean is_deleted;

	public Feedback() {
		super();
	}

	public Feedback(long feedback_id, Date feedback_date, String feedback_type, String feedback_giver_type,
			String feedback_topic, String feedback_status, String language, String feedback_text,
			String contact_firstname, String contact_lastname, String contact_email, String contact_mobile,
			boolean wants_contact, boolean is_deleted) {
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
		this.is_deleted = is_deleted;
	}

	public Feedback(Date feedback_date, String feedback_type, String feedback_giver_type, String feedback_topic,
			String feedback_status, String feedback_text, boolean wants_contact, boolean is_deleted, String language,
			String contact_lastname, String contact_email, String contact_mobile, String string,
			String string2) {
		super();
		this.feedback_date = feedback_date;
		this.feedback_type = feedback_type;
		this.feedback_giver_type = feedback_giver_type;
		this.feedback_topic = feedback_topic;
		this.feedback_status = feedback_status;
		this.feedback_text = feedback_text;
		this.wants_contact = wants_contact;
		this.is_deleted = is_deleted;
		this.language = language;
		this.contact_lastname = contact_lastname;
		this.contact_email = contact_email;
		this.contact_mobile = contact_mobile;
	}
	
	public Feedback(long feedback_id, Date feedback_date, String feedback_type, String feedback_giver_type,
			String feedback_topic, String feedback_status, String language, String feedback_text, boolean wants_contact,
			boolean is_deleted) {
		super();
		this.feedback_id = feedback_id;
		this.feedback_date = feedback_date;
		this.feedback_type = feedback_type;
		this.feedback_giver_type = feedback_giver_type;
		this.feedback_topic = feedback_topic;
		this.feedback_status = feedback_status;
		this.language = language;
		this.feedback_text = feedback_text;
		this.wants_contact = wants_contact;
		this.is_deleted = is_deleted;
	}

	public Feedback(Date feedback_date, String feedback_type, String feedback_giver_type, String feedback_topic,
			String feedback_status, String language, String feedback_text, boolean wants_contact, boolean is_deleted) {
		super();
		this.feedback_date = feedback_date;
		this.feedback_type = feedback_type;
		this.feedback_giver_type = feedback_giver_type;
		this.feedback_topic = feedback_topic;
		this.feedback_status = feedback_status;
		this.language = language;
		this.feedback_text = feedback_text;
		this.wants_contact = wants_contact;
		this.is_deleted = is_deleted;
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

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Feedback [feedback_id=" + feedback_id + ", feedback_type=" + feedback_type + ", feedback_giver_type="
				+ feedback_giver_type + ", feedback_topic=" + feedback_topic + ", feedback_status=" + feedback_status
				+ ", language=" + language + ", feedback_text=" + feedback_text + ", contact_firstname="
				+ contact_firstname + ", contact_lastname=" + contact_lastname + ", contact_email=" + contact_email
				+ ", contact_mobile=" + contact_mobile + ", wants_contact=" + wants_contact + ", is_deleted="
				+ is_deleted + "]";
	}
}
