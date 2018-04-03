package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Passenger;
import services.PassengerService;

@ManagedBean(name = "passengerBean")
@ViewScoped
public class PassengerBean {

	private List<Passenger> passengers;

	private List<Passenger> filteredPassengers;

	@EJB
	private PassengerService ps;

	@PostConstruct
	public void airwayBeanInit() {
		this.passengers = this.ps.getPassengers();
	}

	public List<Passenger> getPassengers() {
		return this.passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public List<Passenger> getFilteredPassengers() {
		return this.filteredPassengers;
	}

	public void setFilteredPassengers(List<Passenger> filteredPassengers) {
		this.filteredPassengers = filteredPassengers;
	}
}
