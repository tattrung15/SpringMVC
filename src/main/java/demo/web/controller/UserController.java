package demo.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import demo.web.model.Order;
import demo.web.model.OrderItem;
import demo.web.model.User;
import demo.web.service.DemoService;

@Controller
public class UserController {

	@Autowired
	DemoService demoService;
	
	@RequestMapping(value = "/them-nguoi-dung/{userId}", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request, HttpSession session, @PathVariable("userId") int userId) {
		User user = demoService.getUserById(userId);
		if (session.getAttribute("cart") == null) {
			Order order = new Order();
			OrderItem orderItem = new OrderItem();
			orderItem.setNumber(1);
			orderItem.setUser(user);
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			orderItems.add(orderItem);
			order.setItems(orderItems);
			session.setAttribute("cart", order);
			request.setAttribute("order", order);
		} else {
			Order order = (Order) session.getAttribute("cart");
			List<OrderItem> orderItems = order.getItems();
			boolean flag = false;
			for (OrderItem orderItem : orderItems) {
				if (orderItem.getUser().getId() == user.getId()) {
					orderItem.setNumber(orderItem.getNumber() + 1);
					flag = true;
				}
			}
			if (!flag) {
				OrderItem orderItem = new OrderItem();
				orderItem.setNumber(1);
				orderItem.setUser(user);
				orderItems.add(orderItem);
				order.setItems(orderItems);
			}
			session.setAttribute("cart", order);
			request.setAttribute("order", order);
		}
		return "test/cart";
	}
	
	@RequestMapping(value = "/xem-gio-hang", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, HttpSession session) {
		if (session.getAttribute("cart") != null) {
			Order order = (Order) session.getAttribute("cart");
			request.setAttribute("order", order);
		}
		return "test/cart";
	}
	
	@RequestMapping(value = "/xoa-san-pham/{userId}", method = RequestMethod.GET)
	public String delUser(HttpServletRequest request, HttpSession session, @PathVariable("userId") int userId) {
		if (session.getAttribute("cart") != null) {
			Order order = (Order) session.getAttribute("cart");
			List<OrderItem> orderItems = order.getItems();
			Iterator<OrderItem> iterator = orderItems.iterator();
			while (iterator.hasNext()) {
				if (iterator.next().getUser().getId() == userId) {
					iterator.remove();
				}
			}
			if (orderItems.isEmpty()) {
				session.removeAttribute("cart");
			}
			request.setAttribute("order", order);
		}
		return "test/cart";
	}
}
