package de.hsw.flightmanager;

import java.time.LocalDateTime;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Aircraft;
import model.Airway;
import model.Flight;

@ManagedBean
@SessionScoped
public class AddFlightBean {

	private EntityManagerFactory emf;
	private Flight flight;
	private String airway;
	private String aircraft;
	private String arrival;
	private String departure;
	
	
	@ManagedProperty(value="#{existingAirways}")
	private List<Airway> existingAirways;
	@ManagedProperty(value="#{existingAircrafts}")
	private List<Aircraft> existingAircrafts;
	
	public void setExistingAirways(List<Airway> existingAirways) {
		this.existingAirways = existingAirways;
	}
	public void setExistingAircrafts(List<Aircraft> existingAircrafts) {
		this.existingAircrafts = existingAircrafts;
	}
	
	public String getAirway() {
		return airway;
	}
	public void setAirway(String airway) {
		this.airway = airway;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	public List<Airway> getExistingAirways() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Airway> result = em.createQuery("SELECT a from Airway a", Airway.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	
	public List<Aircraft> getExistingAircrafts() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Aircraft> result = em.createQuery("SELECT ac from Aircraft ac", Aircraft.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	
	public void saveFlight(){
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		
		this.flight = new Flight();
		this.flight.setAircraft(em.find(Aircraft.class, this.aircraft));
		this.flight.setAirway(em.find(Airway.class, new Integer(this.airway)));
		this.flight.setArrival(LocalDateTime.parse(arrival));
		this.flight.setDeparture(LocalDateTime.parse(departure));

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(flight);
		em.flush();
		tx.commit();
		em.close();
		emf.close();
	}
	
	
}
