package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.Airway;
import services.AirwayService;

@ManagedBean(name = "airwayPersistenceBean")
@ViewScoped
public class AirwayPersistenceBean {

	@EJB
	private AirwayService as;

	private Airway newAirway;

	@PostConstruct
	public void init() {
		this.newAirway = new Airway();
	}

	public Airway getNewAirway() {
		return newAirway;
	}

	public void setNewAirway(Airway newAirway) {
		this.newAirway = newAirway;
	}

	public void persist() {
		this.as.persistAirway(this.newAirway);
		FacesContext.getCurrentInstance().getViewRoot().getViewMap().clear();
	}

}
