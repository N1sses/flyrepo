package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Airway")
@Table(name = "airway")
public class Airway {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fID;
	
	@ManyToOne
	private Airport fStart;
	
	@ManyToOne
	private Airport fDestination;

	@OneToMany(targetEntity=Flight.class)
	private List<Flight> fFlights;

	//Getters and Setters
	public int getID() {
		return this.fID;
	}
	public void setID(int pID) {
		this.fID = pID;
	}
	public Airport getStart() {
		return fStart;
	}
	public void setStart(Airport pStart) {
		this.fStart = pStart;
	}
	public Airport getDestination() {
		return fDestination;
	}
	public void setDestination(Airport pDestination) {
		this.fDestination = pDestination;
	}
	public List<Flight> getFlights() {
		return fFlights;
	}
	public void setFlights(List<Flight> pFlights) {
		this.fFlights = pFlights;
	}
}
