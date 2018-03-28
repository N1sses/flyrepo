package model;

import java.util.List;

public class Passenger {
	
	private String fName;
	private String fSurname;
	
	List<Flight> fFlights;

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
