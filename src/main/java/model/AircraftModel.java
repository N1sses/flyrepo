package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AircraftModel")
@Table(name = "aircraftmodel")
public class AircraftModel {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int fID;
	
	private String fName;
	private int fCapacity;
	
	//Getters and Setters
	public int getID() {
		return fID;
	}
	public void setID(int pID) {
		this.fID = pID;
	}
	public String getName() {
		return fName;
	}
	public void setName(String pName) {
		this.fName = pName;
	}
	public int getCapacity() {
		return fCapacity;
	}
	public void setCapacity(int pCapacity) {
		this.fCapacity = pCapacity;
	} 
}
