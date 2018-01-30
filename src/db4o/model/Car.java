package db4o.model;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 2L;
	private Integer id;
	private String model;
	private Integer power;
	private String dateOfIssue; 
	private String color;
	private Driver driver;
	
	public Car(Integer id, String model, Integer power, String dateOfIssue, String color, Driver driver) {
		setId(id);
		setModel(model);
		setPower(power);
		setDateOfIssue(dateOfIssue);
		setColor(color);
		setDriver(driver);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	
	public void setPower(Integer power) {
		this.power = power;
	}
	public Integer getPower() {
		return power;
	}
	
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Driver getDriver() {
		return driver;
	}
	

	public String toString() {
		return "  Car: (" + id + " | " + model + " | " + power + " | " + dateOfIssue + " | " + color +  " | \n" + driver + ")" ;
	}
}