package model;

import java.util.List;

public class Aircraft {
	
	private String fID;
	private AircraftModel fModel;
	
	private List<Flight> fFlights;

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
