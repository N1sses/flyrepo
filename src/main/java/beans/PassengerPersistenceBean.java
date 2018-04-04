package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Passenger;
import services.PassengerService;


@ManagedBean(name="passengerPersistenceBean")
@ViewScoped
public class PassengerPersistenceBean {
	
	@EJB
	private PassengerService ps;
	
	private Passenger newPassenger;
	
	@PostConstruct
	public void init() {
		this.newPassenger = new Passenger();
	}

	public Passenger getNewPassenger() {
		return newPassenger;
	}

	public void setNewPassenger(Passenger newPassenger) {
		this.newPassenger = newPassenger;
	}
	
	public void persist() {
		this.ps.persistPassenger(this.newPassenger);
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	}

}
