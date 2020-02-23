package demo.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.web.model.User;
import demo.web.service.DemoService;

@Controller
public class DemoController {

	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public String addUsera(HttpServletRequest request) {
		User user = new User();
		request.setAttribute("user", user);
		return "adduser";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String viewUser(HttpServletRequest request, @ModelAttribute("user") @Valid User user, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			request.setAttribute("user", user);
			return "adduser";
		}
		request.setAttribute("user", user);
		return "viewuser";
	}
	
	@RequestMapping(value = "/danh-sach-khach-hang", method = RequestMethod.GET)
	public String getAllUser(HttpServletRequest request) {
		List<User> users = demoService.getAllUsers();
		request.setAttribute("users", users);
		return "user/listUsers";
	}
	
	@RequestMapping(value = "/chi-tiet-nguoi-dung/{userId}", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, @PathVariable("userId") int userId) {
		request.setAttribute("user", demoService.getUserById(userId));
		return "user/viewUser";
	}
	
	@RequestMapping(value = "/them-khach-hang", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		User user = new User();
		request.setAttribute("user", user);
		return "user/addUser";
	}
	
	@RequestMapping(value = "/them-khach-hang", method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			request.setAttribute("user", user);
			return "user/addUser";
		}
		demoService.addUser(user);
		return "redirect:/danh-sach-khach-hang";
	}
	
	@RequestMapping(value = "/xoa-nguoi-dung/{userId}", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest request, @PathVariable("userId") int id) {
		demoService.deleteUser(id);
		return "redirect:/danh-sach-khach-hang";
	}
	
	@RequestMapping(value = "/sua-nguoi-dung/{userId}", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request, @PathVariable("userId") int id) {
		request.setAttribute("user", demoService.getUserById(id));
		return "user/editUser";
	}
	
	@RequestMapping(value = "/sua-nguoi-dung", method = RequestMethod.POST)
	public String editUser(HttpServletRequest request, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "user/editUser";
		}
		demoService.updateUser(user);
		return "redirect:/danh-sach-khach-hang";
	}
}
