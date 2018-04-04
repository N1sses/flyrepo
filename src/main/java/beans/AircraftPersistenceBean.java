package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Aircraft;
import services.AircraftService;

@ManagedBean(name = "aircraftPersistenceBean")
@ViewScoped
public class AircraftPersistenceBean implements Serializable {

	@EJB
	private AircraftService as;

	private Aircraft newAircraft;

	@PostConstruct
	public void init() {
		this.newAircraft = new Aircraft();
	}

	public Aircraft getNewAircraft() {
		return newAircraft;
	}

	public void setNewAircraft(Aircraft newAircraft) {
		this.newAircraft = newAircraft;
	}

	public void persist() {
		this.as.persistAircraft(this.newAircraft);
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	}

}
