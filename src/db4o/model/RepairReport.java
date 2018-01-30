package db4o.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepairReport implements Serializable {
	
	private static final long serialVersionUID = 5L;
	private Integer id;
	private Integer cost;
	private Date issueDate;
	private String category;
	private Date plannedDate;
	private Date actualDate;
	private Mechanic mechanic;
	private Car car;
	private SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy");
	
	public RepairReport(Integer id, Integer cost, String issueDate, String category, String plannedDate,String actualDate, Mechanic mechanic, Car car) throws ParseException {
		setId(id);
		setCost(cost);
		setIssueDate(issueDate);
		setCategory(category);
		setPlannedDate(plannedDate);
		setActualDate(actualDate);
		setMechanic(mechanic);
		setCar(car);
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Integer getCost() {
		return cost;
	}
	
	public void setIssueDate(String stringDate) throws ParseException {
		this.issueDate = ft.parse(stringDate);
	}
	public Date getIssueDate() {
		return issueDate;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	
	public void setPlannedDate(String stringDate) throws ParseException {
		this.plannedDate = ft.parse(stringDate);
	}
	public Date getPlannedDate() {
		return plannedDate;
	}
	
	public void setActualDate(String stringDate) throws ParseException {
		this.actualDate = ft.parse(stringDate);
	}
	public Date getActualDate() {
		return actualDate;
	}
	
	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}
	public Mechanic getMechanic() {
		return mechanic;
	}
	
	public void setCar(Car car) {
		this.car = car;
	}
	public Car getCar() {
		return car;
	}
	
	public String toString() {
		return "Repair Report: " + id + " | " + cost + " | " + issueDate + " | " + category + " | " + plannedDate + " | " + actualDate + " | \n" + mechanic + " | \n" + car;
	}

}
