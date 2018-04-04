package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.AircraftModel;
import services.AircraftModelService;

@ManagedBean(name = "aircraftModelBean")
@ViewScoped
public class AircraftModelBean implements Serializable {

	private List<AircraftModel> aircraftModels;

	@EJB
	private AircraftModelService as;

	@PostConstruct
	public void aircraftModelBeanInit() {
		this.aircraftModels = this.as.getAircraftModels();
	}

	public List<AircraftModel> getAircraftModels() {
		return this.aircraftModels;
	}

	public void setAircraftModels(List<AircraftModel> aircraftModels) {
		this.aircraftModels = aircraftModels;
	}

}
