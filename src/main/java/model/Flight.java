package model;

import java.time.LocalDateTime;
import java.util.List;

public class Flight {
	
	private String fID;
	private Airway fAirway;
	private Aircraft fAircraft;
	
	private LocalDateTime fArrival;
	private LocalDateTime fDeparture;
	
	private List<Passenger> fPassengers;
	private List<Meal> fMeals;
	
	public String getID() {
		return fID;
	}
	public void setID(String pID) {
		this.fID = pID;
	}
	public Airway getAirway() {
		return fAirway;
	}
	public void setAirway(Airway pAirway) {
		this.fAirway = pAirway;
	}
	public Aircraft getAircraft() {
		return fAircraft;
	}
	public void setAircraft(Aircraft pAircraft) {
		this.fAircraft = pAircraft;
	}
	public List<Passenger> getPassengers() {
		return fPassengers;
	}
	public void setPassengers(List<Passenger> pPassengers) {
		this.fPassengers = pPassengers;
	}
	public List<Meal> getMeals() {
		return fMeals;
	}
	public void setMeals(List<Meal> pMeals) {
		this.fMeals = pMeals;
	}
	public LocalDateTime getArrival() {
		return fArrival;
	}
	public void setArrival(LocalDateTime pArrival) {
		this.fArrival = pArrival;
	}
	public LocalDateTime getDeparture() {
		return fDeparture;
	}
	public void setDeparture(LocalDateTime pDeparture) {
		this.fDeparture = pDeparture;
	}
	
	public Status getStatus(){
		LocalDateTime lCurrentTime = LocalDateTime.now();
		if(lCurrentTime.isBefore(this.fDeparture)){
			return Status.SCHEDULED;
		} else if (lCurrentTime.isBefore(this.fArrival)){
			return Status.DEPARTED;
		} else if (lCurrentTime.isBefore(this.fArrival.plusHours(1))){
			return Status.LANDED;
		} else {
			return Status.COMPLETED;
		}
	}

}
