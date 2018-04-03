package de.hsw.flightmanager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Aircraft;
import model.AircraftModel;

@ManagedBean
@SessionScoped
public class AddAircraftBean {
	
	private EntityManagerFactory emf;
	private Aircraft aircraft;
	private String aircraftModel;
	
	@ManagedProperty(value="#{existingAircraftModels}")
	private List<AircraftModel> existingAircraftModels;
	
	public String getAircraftModel() {
		return aircraftModel;
	}
	public void setAircraftModel(String aircraftModel) {
		this.aircraftModel = aircraftModel;
	}
	
	public List<AircraftModel> getExistingAircraftModels() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		List<AircraftModel> result = em.createQuery("SELECT am from AircraftModel am", AircraftModel.class).getResultList();
		em.close();
		emf.close();
		return result;
	}
	
	public void setExistingAircraftModels(List<AircraftModel> existingAircraftModels) {
		this.existingAircraftModels = existingAircraftModels;
	}
	
	public void saveAircraft(){
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		
		this.aircraft = new Aircraft();
		this.aircraft.setModel(em.find(AircraftModel.class, new Integer(this.aircraftModel)));

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(aircraft);
		em.flush();
		tx.commit();
		em.close();
		emf.close();
	}
	
}
