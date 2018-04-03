package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Flight;

@Stateless(name = "flightService")
public class FlightService {

	@EJB
	private EntityManagerProvider emp;

	public List<Flight> getFlights() {
		return emp.getEntitiyManager().createNamedQuery("Flight.findAll", Flight.class).getResultList();
	}
}
