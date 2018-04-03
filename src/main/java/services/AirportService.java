package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Airport;

@Stateless(name = "airportService")
public class AirportService {

	@EJB
	private EntityManagerProvider emp;
	
	public List<Airport> getAirports() {
		return emp.getEntitiyManager().createNamedQuery("Airport.findAll", Airport.class).getResultList();
	}
	
}
