package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.AircraftModel;
import model.Airway;

@Stateless(name = "airwayService")
public class AirwayService {

	@EJB
	private EntityManagerProvider emp;

	public List<Airway> getAirways() {
		return emp.getEntitiyManager().createNamedQuery("Airway.findAll", Airway.class).getResultList();
	}
	public void persistAirway(Airway airway) {
		EntityManager em = emp.getEntitiyManager();
		em.getTransaction().begin();
		em.persist(airway);
		em.getTransaction().commit();
		em.close();
	}
}
