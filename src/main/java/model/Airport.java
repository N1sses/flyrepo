package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Airport")
@Table(name = "airport")
@NamedQueries({ @NamedQuery(name = "Airport.findAll", query = "SELECT a FROM Airport a"),
		@NamedQuery(name = "Airport.findByIataCode", query = "SELECT a FROM Airport a WHERE a.iataCode = :iatacode") })
public class Airport implements Serializable {
	// Attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AirportID")
	private int id;

	@Column(name = "IataCode")
	private String iataCode;

	// Getters and Setters
	public int getID() {
		return this.id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getIataCode() {
		return this.iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Airport) {
			return ((Airport) other).getID() == this.getID();
		}
		return false;
	}
}
