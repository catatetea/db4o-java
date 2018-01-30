package db4o.model;

import java.io.Serializable;

public class Workshop implements Serializable {

	private static final long serialVersionUID = 4L;
	private Integer id;
	private String name;
	private String address;
	private String phone;
	
	public Workshop(Integer id, String name, String address, String phone) {
		setId(id);
		setName(name);
		setAddress(address);
		setPhone(phone);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}

	public String toString() {
		return "  Workshop: (" + id + " | " + name + " | " + address + " | " + phone + ")";
	}
	
	
	
}