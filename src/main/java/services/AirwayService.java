package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Airway;

@Stateless(name = "airwayService")
public class AirwayService {

	@EJB
	private EntityManagerProvider emp;

	public List<Airway> getAirways() {
		return emp.getEntitiyManager().createNamedQuery("Airway.findAll", Airway.class).getResultList();
	}
}
