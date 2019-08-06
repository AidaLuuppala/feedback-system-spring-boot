package com.project.feedbacksystem.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//repository class for the database queries
@Repository
public class CommentDAOImpl implements CommentDAO {
	
		// use jdbc template to execute the database queries
		@Autowired
		private JdbcTemplate jdbcTemplate;
		
		public JdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}
		
		public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		// save comment to the database
		public void save(Comment comment) {
			String sql = "insert into comment(feedback_id, comment_date, comment_text, comment_handler) values(?,?,?,?)";
			Object[] parameters = new Object[] {
					comment.getFeedback_id(),
					comment.getComment_date(),
					comment.getComment_text(),
					comment.getComment_handler() };
			jdbcTemplate.update(sql, parameters);
		}

		// find all feedbacks for admins to feedbacks page
		public List<Comment> findAll(long feedback_id) {
			String sql = "select comment_id, feedback_id, comment_date, comment_text, comment_handler from comment where feedback_id = ?";
			Object[] parameters = new Object[] { feedback_id };
			RowMapper<Comment> mapper = new CommentRowMapper();
			List<Comment> comments = jdbcTemplate.query(sql, parameters, mapper);
			return comments;
		}

}
