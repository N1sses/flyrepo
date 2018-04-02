package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Passenger")
@Table(name = "passenger")
public class Passenger {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PassengerID")
	private int fID;
	@Column(name="Name")
	private String fName;
	@Column(name="Surname")
	private String fSurname;
	
	@ManyToMany(mappedBy="fPassengers")
	private List<Flight> fFlights;

	//Getters and Setters
	public int getID() {
		return this.fID;
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
	public String getSurname() {
		return fSurname;
	}
	public void setSurname(String pSurname) {
		this.fSurname = pSurname;
	}
	public List<Flight> getFlights() {
		return fFlights;
	}
	public void addFlight(Flight pFlight) {
		this.fFlights.add(pFlight);
	}
}
