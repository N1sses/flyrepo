package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.User;

@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {
	
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	private EntityManagerFactory emf;


	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
		emf = Persistence.createEntityManagerFactory("flightdb");
		EntityManager em = emf.createEntityManager();
		Query userQuery = em.createNamedQuery("User.findByName", User.class);
		userQuery.setParameter("name", this.user);

		try{
			User user = (User) userQuery.getSingleResult();
			if(getPwd().equals(user.getPassword())){
				user.setPassword(null);
				this.userBean.setCurrentUser(user);
				return "home";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Incorrect password",
								"Please enter correct password"));
				return "login";
			}
			
			
			
		} catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username",
							"Please enter correct username and the corresponding password"));
			return "login";
		}
		
		
	}

	//logout event, invalidate session
	public String logout() {
		
		return "login";
	}
}