package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.Aircraft;

@Stateless(name = "aircraftService")
public class AircraftService {
	
	@EJB
	private EntityManagerProvider emp;
	
	public List<Aircraft> getAircrafts() {
		return emp.getEntitiyManager().createNamedQuery("Aircraft.findAll", Aircraft.class).getResultList();
	}
	
	public void persistAircraft(Aircraft aircraft) {
		EntityManager em = emp.getEntitiyManager();
		em.getTransaction().begin();
		em.persist(aircraft);
		em.getTransaction().commit();
		em.close();
	}

}
