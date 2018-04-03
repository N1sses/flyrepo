package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Meal;
import services.MealService;

@ManagedBean(name="mealBean")
@ViewScoped
public class MealBean {

	private List<Meal> meals;
	
	private List<Meal> filteredMeals;
	
	@EJB
	private MealService ms;
	
	@PostConstruct
	public void mealBeanInit(){
		this.meals = this.ms.getMeals();
		this.filteredMeals = this.ms.getMeals();
	}
	
	public List<Meal> getMeals() {
		return this.meals;
	}
	
	public void setMeals(List<Meal> meals){
		this.meals = meals;
	}
	
	public List<Meal> getFilteredMeals(){
		return this.filteredMeals;
	}
	
	public void setFilteredMeals(List<Meal> filteredMeals){
		this.filteredMeals = filteredMeals;
	}
	
}
