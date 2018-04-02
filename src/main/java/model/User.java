package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="user")
@NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE u.fUsername = :name") 
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="UserID")
	private int fID;
	@Column(name="Username")
	private String fUsername;
	@Column(name="Password")
	private String fPassword;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RoleID")
	private Role fRole; 
	
	
	public int getID() {
		return fID;
	}
	public void setID(int pID) {
		this.fID = pID;
	}
	public String getUsername() {
		return fUsername;
	}
	public void setUsername(String pUsername) {
		this.fUsername = pUsername;
	}
	public String getPassword() {
		return fPassword;
	}
	public void setPassword(String pPassword) {
		this.fPassword = pPassword;
	}
	public Role getRole() {
		return fRole;
	}
	public void setRole(Role pRole) {
		this.fRole = pRole;
	}
}
