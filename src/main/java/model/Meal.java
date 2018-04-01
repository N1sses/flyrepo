package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Meal")
@Table(name = "meal")
public class Meal {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fID;
	private String fName;

	//Getters and Setters
	public int getID() {
		return this.fID;
	}
	public void setID(int pID) {
		this.fID = pID;
	}
	public String getName() {
		return this.fName;
	}
	public void setName(String pName) {
		this.fName = pName;
	}
}
