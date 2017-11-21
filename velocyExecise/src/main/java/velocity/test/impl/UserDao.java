package velocity.test.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import velocity.test.dao.IUserDao;
import velocity.test.model.User;
@Repository("userDao")
public class UserDao implements IUserDao{
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<User> getUserList() {
		RowMapper<User> rowMapper=new RowMapper<User>() {
			
			public User mapRow(ResultSet rs, int num) throws SQLException {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				return user;
			}
		};
		List<User> list=this.jdbcTemplate.query("select * from user",rowMapper); 
		return list;
	}
}
