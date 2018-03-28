package model;

import java.util.List;

public class Airway {
	
	private Airport fStart;
	private Airport fDestination;
	
	List<Flight> fFlights;

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
