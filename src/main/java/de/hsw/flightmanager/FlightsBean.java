package de.hsw.flightmanager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import model.Flight;

@ManagedBean
@SessionScoped
public class FlightsBean {
	
	private EntityManagerFactory emf;
	@ManagedProperty(value="#{flights}")
	private List<Flight> flights;
	
	public FlightsBean() {
		
	}
	
	public List<Flight> getFlights() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		return em.createQuery("SELECT f from Flight f", Flight.class).getResultList();
	}
	
	public void setFlights(List<Flight> flights){
		this.flights=flights;
	}
}
