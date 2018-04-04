package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import model.AircraftModel;

@Stateless(name="aircraftModelService")
public class AircraftModelService {
	
	@EJB
	private EntityManagerProvider emp;
	
	public List<AircraftModel> getAircraftModels() {
		return emp.getEntitiyManager().createNamedQuery("AircraftModel.findAll", AircraftModel.class).getResultList();
	}
	
	public void persistAircraftModel(AircraftModel aircraftModel) {
		EntityManager em = emp.getEntitiyManager();
		em.getTransaction().begin();
		em.persist(aircraftModel);
		em.getTransaction().commit();
		em.close();
	}
	

}
