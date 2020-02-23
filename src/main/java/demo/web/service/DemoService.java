package demo.web.service;

import java.util.List;

import demo.web.model.User;

public interface DemoService {

	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public User getUserById(int id);
	
	public List<User> getAllUsers();
}
