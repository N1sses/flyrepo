package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Flight;
import services.FlightService;

@ManagedBean(name = "flightBean")
@ViewScoped
public class FlightBean implements Serializable {

	private List<Flight> flights;

	private List<Flight> filteredFlights;

	private Flight selectedFlight;

	@EJB
	private FlightService fs;

	@PostConstruct
	public void flightBeanInit() {
		this.flights = this.fs.getFlights();
	}

	public List<Flight> getFlights() {
		return this.flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Flight> getFilteredFlights() {
		return this.filteredFlights;
	}

	public void setFilteredFlights(List<Flight> filteredFlights) {
		this.filteredFlights = filteredFlights;
	}

	public Flight getSelectedFlight() {
		return this.selectedFlight;
	}

	public void setSelectedFlight(Flight selectedFlight) {
		this.selectedFlight = selectedFlight;
	}

}
