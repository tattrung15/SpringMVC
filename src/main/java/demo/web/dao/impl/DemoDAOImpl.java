package demo.web.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import demo.web.dao.DemoDAO;
import demo.web.model.User;

@Repository
public class DemoDAOImpl implements DemoDAO{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO Student VALUES(?,?,?)";
		jdbcTemplate.update(sql, user.getId(), user.getName(), user.getPhone());
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Student SET Name = ?, Phone = ? WHERE ID = ?";
		jdbcTemplate.update(sql, user.getName(), user.getPhone(), user.getId());
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Student WHERE ID = ?";
		jdbcTemplate.update(sql, id);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Student WHERE ID = ?";
		
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>(){

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				return user;
			}
			
		});
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM Student";
		return jdbcTemplate.query(sql, new Object[]{}, new RowMapper<User>(){

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPhone(rs.getString(3));
				return user;
			}
			
		});
	}

}
