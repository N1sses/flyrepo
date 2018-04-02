package de.hsw.flightmanager;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Flight;

@Stateless
public class FlightsBean {
	
	private EntityManagerFactory emf;
	
	public List<Flight> getFlights() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		return em.createQuery("SELECT f from Flight f", Flight.class).getResultList();
	}
	
}
