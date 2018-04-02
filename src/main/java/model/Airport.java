package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "Airport")
@Table(name = "airport")
public class Airport {
	//Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AirportID")
	private int fID;
	
	@Column(name="IataCode")
	private String fIataCode;
	
	//Getters and Setters
	public int getID() {
		return this.fID;
	}
	public void setID(int pID) {
		this.fID = pID;
	}
	public String getIataCode() {
		return fIataCode;
	}
	public void setIataCode(String pIataCode) {
		this.fIataCode = pIataCode;
	}
}
