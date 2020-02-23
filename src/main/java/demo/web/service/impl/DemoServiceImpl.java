package demo.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.web.dao.DemoDAO;
import demo.web.model.User;
import demo.web.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	DemoDAO demoDAO;

	public void addUser(User user) {
		// TODO Auto-generated method stub
		demoDAO.addUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		demoDAO.updateUser(user);
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		demoDAO.deleteUser(id);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return demoDAO.getUserById(id);
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return demoDAO.getAllUsers();
	}
}
