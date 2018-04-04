package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.Aircraft;
import model.Passenger;

@Stateless(name = "passengerService")
public class PassengerService {

	@EJB
	private EntityManagerProvider emp;

	public List<Passenger> getPassengers() {
		return emp.getEntitiyManager().createNamedQuery("Passenger.findAll", Passenger.class).getResultList();
	}
	
	public void persistPassenger(Passenger passenger) {
		EntityManager em = emp.getEntitiyManager();
		em.getTransaction().begin();
		em.persist(passenger);
		em.getTransaction().commit();
		em.close();
	}
}
