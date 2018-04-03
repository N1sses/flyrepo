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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Aircraft")
@Table(name = "aircraft")
public class Aircraft {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AircraftID")
	private String fID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AircraftModelID")
	private AircraftModel fModel;
	
	@OneToMany(mappedBy = "fAircraft")
	private List<Flight> fFlights;

	//Getters and Setters
	public String getID() {
		return fID;
	}
	public void setID(String pID) {
		this.fID = pID;
	}
	public AircraftModel getModel() {
		return fModel;
	}
	public void setModel(AircraftModel pModel) {
		this.fModel = pModel;
	}
	public List<Flight> getFlights() {
		return fFlights;
	}
	public void setFlights(List<Flight> pFlights) {
		this.fFlights = pFlights;
	}
}
