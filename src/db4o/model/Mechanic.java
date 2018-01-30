package db4o.model;

import java.io.Serializable;

public class Mechanic implements Serializable {

	private static final long serialVersionUID = 5L;
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private Integer rank;
	private Workshop workshop;
	
	public Mechanic(Integer id, String name, String address, String phone, Integer rank, Workshop workshop) {
		setId(id);
		setName(name);
		setAddress(address);
		setPhone(phone);
		setRank(rank);
		setWorkshop(workshop);
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
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getRank() {
		return rank;
	}
	
	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}
	public Workshop getWorkshop() {
		return workshop;
	}

	public String toString() {
		return "  Mechanic: (" + id + " | " + name + " | " + address + " | " + phone + " | " + rank + " | \n" + workshop + ")";
	}
}