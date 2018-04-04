package beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import model.Flight;
import model.Passenger;
import services.FlightService;

public class FlightPersistenceBean implements Serializable{
	
	@EJB
	private FlightService fs;
	
	private Flight newFlight;
	
	@PostConstruct
	public void init() {
		this.newFlight = new Flight();
		this.newFlight.setDeparture(LocalDateTime.of(2018, 6, 17, 8, 50));
		this.newFlight.setArrival(LocalDateTime.of(2018, 6, 17, 11, 50));
		this.newFlight.setPassengers(new ArrayList<Passenger>());
	}

	public Flight getNewAircraft() {
		return newFlight;
	}

	public void setNewFlight(Flight newFlight) {
		this.newFlight = newFlight;
	}
	
	public void persist() {
		this.fs.persistFlight(this.newFlight);
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	}
	
	
}
