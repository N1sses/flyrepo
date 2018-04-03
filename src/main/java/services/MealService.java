package services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Flight;
import model.Meal;

@Stateless(name="mealService")
public class MealService {

	@EJB
	private EntityManagerProvider emp;

	public List<Meal> getMeals() {
		return emp.getEntitiyManager().createNamedQuery("Meal.findAll", Meal.class).getResultList();
	}
}
