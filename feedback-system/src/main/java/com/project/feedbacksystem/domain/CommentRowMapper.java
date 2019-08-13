package com.project.feedbacksystem.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentRowMapper implements RowMapper<Comment> {

	// go through database query result set rows and populate a new Comment object with the data
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setComment_id(rs.getLong("comment_id"));
		comment.setFeedback_id(rs.getLong("feedback_id"));
		comment.setComment_date(rs.getDate("comment_date"));
		comment.setComment_text(rs.getString("comment_text"));
		comment.setComment_handler(rs.getString("comment_handler"));
		return comment;
	}

}
