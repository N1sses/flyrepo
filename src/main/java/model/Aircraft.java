package model;

import java.io.Serializable;
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

@Entity(name = "Aircraft")
@Table(name = "aircraft")
@NamedQuery(name="Aircraft.findAll", query="SELECT a FROM Aircraft a")
public class Aircraft implements Serializable {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AircraftID")
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AircraftModelID")
	private AircraftModel model;
	
	@OneToMany(mappedBy = "aircraft")
	private List<Flight> flights;

	//Getters and Setters
	public String getID() {
		return this.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public AircraftModel getModel() {
		return this.model;
	}
	public void setModel(AircraftModel model) {
		this.model = model;
	}
	public List<Flight> getFlights() {
		return this.flights;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	@Override 
	public int hashCode() {
		return Integer.parseInt(this.id);
	}
	
	@Override 
	public boolean equals(Object other) {
		if (other instanceof Aircraft) {
			return ((Aircraft) other).getID() == this.getID();
		}
		return false;
	}
}
