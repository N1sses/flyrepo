package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Stateless(name="entityManagerProvider")
public class EntityManagerProvider {
	
	public EntityManager getEntitiyManager(){
		return Persistence.createEntityManagerFactory("flightdb").createEntityManager();
	}

}
