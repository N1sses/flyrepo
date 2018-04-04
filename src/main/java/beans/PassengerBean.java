package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Passenger;
import services.PassengerService;

@ManagedBean(name = "passengerBean")
@ViewScoped
public class PassengerBean implements Serializable  {

	private List<Passenger> passengers;

	private List<Passenger> filteredPassengers;
	
	private Passenger selectedPassenger;

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
	
	public void setSelectedPassenger(Passenger passenger){
		this.selectedPassenger=passenger;
	}
	
	public Passenger getSelectedPassenger(){
		return this.selectedPassenger;
	}
}
