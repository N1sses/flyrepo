package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "AircraftModel")
@Table(name = "aircraftmodel")
@NamedQuery(name="AircraftModel.findAll", query="SELECT a FROM AircraftModel a")
public class AircraftModel implements Serializable {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AircraftModelID")
	private int id;
	
	@Column(name="Name")
	private String name;
	@Column(name="Capacity")
	private int capacity;
	
	//Getters and Setters
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	} 
	
	@Override 
	public int hashCode() {
		return this.id;
	}
	
	@Override 
	public boolean equals(Object other) {
		if (other instanceof AircraftModel) {
			return ((AircraftModel) other).getID() == this.getID();
		}
		return false;
	}
}
