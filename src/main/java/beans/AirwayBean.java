package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Airway;
import services.AirwayService;

@ManagedBean(name = "airwayBean")
@ViewScoped
public class AirwayBean implements Serializable {

	private List<Airway> airways;

	private List<Airway> filteredAirways;

	@EJB
	private AirwayService as;

	@PostConstruct
	public void airwayBeanInit() {
		this.airways = this.as.getAirways();
	}

	public List<Airway> getAirways() {
		return this.airways;
	}

	public void setAirways(List<Airway> airways) {
		this.airways = airways;
	}

	public List<Airway> getFilteredAirways() {
		return this.filteredAirways;
	}

	public void setFilteredAirways(List<Airway> filteredAirways) {
		this.filteredAirways = filteredAirways;
	}

}
