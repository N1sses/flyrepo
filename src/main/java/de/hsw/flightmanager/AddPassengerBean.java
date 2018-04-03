package de.hsw.flightmanager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Passenger;

@ManagedBean
@SessionScoped
public class AddPassengerBean {

  private EntityManagerFactory emf;
  private Passenger passenger;
  private String name;
  private String surname;
  
  
public Passenger getPassenger() {
	return passenger;
}
public void setPassenger(Passenger passenger) {
	this.passenger = passenger;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}

public void registerPassenger(){
	emf = Persistence.createEntityManagerFactory("flightdb");
	EntityManager em = emf.createEntityManager();
	
	this.passenger = new Passenger();
	this.passenger.setName(this.name);
	this.passenger.setSurname(this.surname);


	EntityTransaction tx = em.getTransaction();
	tx.begin();
	
	em.persist(passenger);
	em.flush();
	tx.commit();
	em.close();
	emf.close();
}
  
}
