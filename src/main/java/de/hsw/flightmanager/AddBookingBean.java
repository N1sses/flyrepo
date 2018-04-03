package de.hsw.flightmanager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import model.Flight;
import model.Passenger;

@ManagedBean
@SessionScoped
public class AddBookingBean {
	private EntityManagerFactory emf;
	
	private String passengerId;
	private String flightId;
	private Passenger passenger;
	private Flight flight;
	
	@ManagedProperty(value="#{existingPassengers}")
	private List<Passenger> existingPassengers;
	@ManagedProperty(value="#{existingFlights}")
	private List<Flight> existingFlights;
	public String getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public List<Passenger> getExistingPassengers() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Passenger> result = em.createQuery("SELECT p from Passenger p", Passenger.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	public void setExistingPassengers(List<Passenger> existingPassengers) {
		this.existingPassengers = existingPassengers;
	}
	public List<Flight> getExistingFlights() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Flight> result = em.createQuery("SELECT f from Flight f", Flight.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	public void setExistingFlights(List<Flight> existingFlights) {
		this.existingFlights = existingFlights;
	}
	
	public void saveBooking(){
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		
		this.passenger = em.find(Passenger.class, new Integer(this.passengerId));
		this.flight = em.find(Flight.class, this.flightId);
		this.flight.addPassenger(this.passenger);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(flight);
		em.flush();
		tx.commit();
		em.close();
		emf.close();
	}
	
	

}
