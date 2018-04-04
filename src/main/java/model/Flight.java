package model;

import java.io.Serializable;
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
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity(name = "Flight")
@Table(name = "flight")
@NamedQuery(name="Flight.findAll", query="SELECT f FROM Flight f")
public class Flight implements Serializable {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FlightID")
	private String id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AirwayID")
	private Airway airway;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AircraftID")
	private Aircraft aircraft;
	
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@Column(name="Arrival" )
	private LocalDateTime arrival;
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	@Column(name="Departure")
	private LocalDateTime departure;
	
	@ManyToMany
	@JoinTable(
		      name="booking",
		      joinColumns=@JoinColumn(name="FlightID", referencedColumnName="FlightID"),
		      inverseJoinColumns=@JoinColumn(name="PassengerID", referencedColumnName="PassengerID"))
	private List<Passenger> passengers;
	
	@ManyToMany
	@JoinTable(
		      name="menu",
		      joinColumns=@JoinColumn(name="FlightID", referencedColumnName="FlightID"),
		      inverseJoinColumns=@JoinColumn(name="MealID", referencedColumnName="MealID"))
	private List<Meal> meals;
	
	
	//Getters and Setters
	public String getID() {
		return this.id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public Airway getAirway() {
		return this.airway;
	}
	public void setAirway(Airway airway) {
		this.airway = airway;
	}
	public Aircraft getAircraft() {
		return this.aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public List<Passenger> getPassengers() {
		return this.passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public List<Meal> getMeals() {
		return this.meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public LocalDateTime getArrival() {
		return this.arrival;
	}
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}
	public LocalDateTime getDeparture() {
		return this.departure;
	}
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}
	
	public int getPassengerCount(){
		return this.passengers.size();
	}
	
	public void addPassenger(Passenger passenger){
		this.passengers.add(passenger);
	}
	
	public Status getStatus(){
		LocalDateTime lCurrentTime = LocalDateTime.now();
		if(lCurrentTime.isBefore(this.departure)){
			return Status.SCHEDULED;
		} else if (lCurrentTime.isBefore(this.arrival)){
			return Status.DEPARTED;
		} else if (lCurrentTime.isBefore(this.arrival.plusHours(1))){
			return Status.LANDED;
		} else {
			return Status.COMPLETED;
		}
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(this.id);
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Flight) {
			return ((Flight) other).getID() == this.getID();
		}
		return false;
	}

}
