package demo.web.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {

	private int id;
	
	@NotEmpty
	private String name;
	
	@Length(min = 6, max = 12)
	private String password;
	
	@Length(min = 10, max = 11)
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
