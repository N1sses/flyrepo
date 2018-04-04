package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Airport;
import services.AirportService;

@ManagedBean(name = "airportBean")
@ViewScoped
public class AirportBean implements Serializable {

	private List<Airport> airports;

	@EJB
	private AirportService as;

	@PostConstruct
	public void airportBeanInit() {
		this.airports = this.as.getAirports();
	}

	public List<Airport> getAirports() {
		return this.airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}
