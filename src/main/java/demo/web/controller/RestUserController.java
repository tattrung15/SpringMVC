package demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import demo.web.model.User;
import demo.web.service.DemoService;

@RestController
public class RestUserController {

	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public List<User> listUser(HttpServletRequest request) {
		List<User> users = demoService.getAllUsers();
		return users;
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		demoService.addUser(user);
	}
}
