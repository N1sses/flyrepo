package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Role")
@Table (name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RoleID")
	private int fID;
	
	@Column(name="name")
	private String fName;
	
	public int getID() {
		return fID;
	}

	public void setID(int pID) {
		this.fID = pID;
	}

	public String getName() {
		return fName;
	}

	public void setName(String pName) {
		this.fName = pName;
	}
	
}
