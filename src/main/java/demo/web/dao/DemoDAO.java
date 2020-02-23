package demo.web.dao;

import java.util.List;

import demo.web.model.User;

public interface DemoDAO {

	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public User getUserById(int id);
	
	public List<User> getAllUsers();
}
