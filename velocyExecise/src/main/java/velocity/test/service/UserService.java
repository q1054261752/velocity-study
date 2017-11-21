package velocity.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import velocity.test.dao.IUserDao;
import velocity.test.model.User;

@Service("userService")
public class UserService {
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	public List<User> getUserList() {
		return this.userDao.getUserList();
	}
}
