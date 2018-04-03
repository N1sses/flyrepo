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
import model.Flight;
import model.Meal;
import model.Passenger;

@ManagedBean
@SessionScoped
public class AddMealBean {
	
	private EntityManagerFactory emf;
	
	private Flight flight;
	private Meal meal;
	private String mealID;
	private String flightID;
	@ManagedProperty(value="#{existingMeals}")
	private List<Meal> existingMeals;
	@ManagedProperty(value="#{existingFlights}")
	private List<Flight> existingFlights;
	
	
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public String getMealID() {
		return mealID;
	}

	public void setMealID(String mealID) {
		this.mealID = mealID;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public void setExistingMeals(List<Meal> existingMeals) {
		this.existingMeals = existingMeals;
	}


	public void setExistingFlights(List<Flight> existingFlights) {
		this.existingFlights = existingFlights;
	}

	public List<Meal> getExistingMeals() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Meal> result = em.createQuery("SELECT m from Meal m", Meal.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	
	public List<Flight> getExistingFlights() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<Flight> result = em.createQuery("SELECT f from Flight f", Flight.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	
	public void saveMenu(){
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		
		this.meal = em.find(Meal.class, new Integer(this.mealID));
		this.flight = em.find(Flight.class, this.flightID);
		this.flight.addMeal(this.meal);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(flight);
		em.flush();
		tx.commit();
		em.close();
		emf.close();
	}
	
}
