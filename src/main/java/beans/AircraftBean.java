package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Aircraft;
import services.AircraftService;

@ManagedBean(name = "aircraftBean")
@ViewScoped
public class AircraftBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5253049580402090502L;

	private List<Aircraft> aircrafts;

	private List<Aircraft> filteredAircrafts;

	@EJB
	private AircraftService as;

	@PostConstruct
	public void aircraftBeanInit() {
		this.aircrafts = this.as.getAircrafts();
	}

	public List<Aircraft> getAircrafts() {
		return this.aircrafts;
	}

	public void setAircrafts(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}

	public List<Aircraft> getFilteredAircrafts() {
		return this.filteredAircrafts;
	}

	public void setFilteredAircrafts(List<Aircraft> filteredAircrafts) {
		this.filteredAircrafts = filteredAircrafts;
	}

}
