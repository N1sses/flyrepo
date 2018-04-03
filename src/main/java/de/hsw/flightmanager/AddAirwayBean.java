package de.hsw.flightmanager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Airport;
import model.Airway;

@ManagedBean
@SessionScoped
public class AddAirwayBean {

	private EntityManagerFactory emf;
	private Airway airway;
	private String start;
	@ManagedProperty(value="#{existingAirports}")
	private List<Airport> existingAirports;
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	private String destination;
	
	
	public List<Airport> getExistingAirports() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Airport> result = em.createQuery("SELECT ap from Airport ap", Airport.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	
	public void setExistingAirports(List<Airport> existingAirports) {
		this.existingAirports = existingAirports;
	}
	
	public void saveAirway(){
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		
		this.airway = new Airway();
		this.airway.setStart(em.find(Airport.class, new Integer(this.start)));
		this.airway.setDestination(em.find(Airport.class, new Integer(this.destination)));

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(airway);
		em.flush();
		tx.commit();
		em.close();
		emf.close();
	}
	
}
