package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Meal")
@Table(name = "meal")
@NamedQuery(name="Meal.findAll", query="SELECT m FROM Meal m")
public class Meal {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MealID")
	private int id;
	@Column(name="Name")
	private String name;

	//Getters and Setters
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
