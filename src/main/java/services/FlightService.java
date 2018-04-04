package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.AircraftModel;
import model.Flight;

@Stateless(name = "flightService")
public class FlightService {

	@EJB
	private EntityManagerProvider emp;

	public List<Flight> getFlights() {
		return emp.getEntitiyManager().createNamedQuery("Flight.findAll", Flight.class).getResultList();
	}
	
	public void persistFlight(Flight flight) {
		EntityManager em = emp.getEntitiyManager();
		em.getTransaction().begin();
		em.persist(flight);
		em.getTransaction().commit();
		em.close();
	}
}
