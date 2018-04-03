package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Airway")
@Table(name = "airway")
@NamedQuery(name="Airway.findAll", query="SELECT a FROM Airway a")
public class Airway {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AirwayID")
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="StartID")
	private Airport start;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DestinationID")
	private Airport destination;

	@OneToMany(mappedBy="airway")
	private List<Flight> flights;

	//Getters and Setters
	public int getID() {
		return this.id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public Airport getStart() {
		return this.start;
	}
	public void setStart(Airport start) {
		this.start = start;
	}
	public Airport getDestination() {
		return this.destination;
	}
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	public List<Flight> getFlights() {
		return this.flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
