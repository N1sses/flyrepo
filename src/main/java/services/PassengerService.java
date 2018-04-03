package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Passenger;

@Stateless(name = "passengerService")
public class PassengerService {

	@EJB
	private EntityManagerProvider emp;

	public List<Passenger> getPassengers() {
		return emp.getEntitiyManager().createNamedQuery("Passenger.findAll", Passenger.class).getResultList();
	}
}
