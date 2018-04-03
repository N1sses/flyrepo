package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Passenger")
@Table(name = "passenger")
	@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
	

public class Passenger {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PassengerID")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Surname")
	private String surname;
	
	@ManyToMany(mappedBy="passengers")
	private List<Flight> flights;

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
	public String getSurname() {
		return this.surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public List<Flight> getFlights() {
		return this.flights;
	}
	public void addFlight(Flight pFlight) {
		this.flights.add(pFlight);
	}
}
