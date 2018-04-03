package model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity(name = "Flight")
@Table(name = "flight")
public class Flight {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FlightID")
	private String fID;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AirwayID")
	private Airway fAirway;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AircraftID")
	private Aircraft fAircraft;
	 
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@Column(name="Arrival" )
	private LocalDateTime fArrival;
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@Column(name="Departure")
	private LocalDateTime fDeparture;
	
	@ManyToMany
	@JoinTable(
		      name="booking",
		      joinColumns=@JoinColumn(name="FlightID", referencedColumnName="FlightID"),
		      inverseJoinColumns=@JoinColumn(name="PassengerID", referencedColumnName="PassengerID"))
	private List<Passenger> fPassengers;
	
	@ManyToMany
	@JoinTable(
		      name="menu",
		      joinColumns=@JoinColumn(name="FlightID", referencedColumnName="FlightID"),
		      inverseJoinColumns=@JoinColumn(name="MealID", referencedColumnName="MealID"))
	private List<Meal> fMeals;
	
	
	//Getters and Setters
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
	public void addPassenger(Passenger pPassenger){
		this.fPassengers.add(pPassenger);
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
