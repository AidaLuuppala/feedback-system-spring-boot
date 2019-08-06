package com.project.feedbacksystem.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
	
	private long comment_id, feedback_id;
	
	// date format so the date will be in right format
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date comment_date;
	
	private String comment_text, comment_handler;

	public Comment() {
		super();
	}

	public Comment(long comment_id, long feedback_id, Date comment_date, String comment_text, String comment_handler) {
		super();
		this.comment_id = comment_id;
		this.feedback_id = feedback_id;
		this.comment_date = comment_date;
		this.comment_text = comment_text;
		this.comment_handler = comment_handler;
	}

	public Comment(long feedback_id, Date comment_date, String comment_text, String comment_handler) {
		super();
		this.feedback_id = feedback_id;
		this.comment_date = comment_date;
		this.comment_text = comment_text;
		this.comment_handler = comment_handler;
	}

	public long getComment_id() {
		return comment_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}

	public long getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(long feedback_id) {
		this.feedback_id = feedback_id;
	}

	public Date getComment_date() {
		return comment_date;
	}

	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public String getComment_handler() {
		return comment_handler;
	}

	public void setComment_handler(String comment_handler) {
		this.comment_handler = comment_handler;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", feedback_id=" + feedback_id + ", comment_date=" + comment_date
				+ ", comment_text=" + comment_text + ", comment_handler=" + comment_handler + "]";
	}
	
}
