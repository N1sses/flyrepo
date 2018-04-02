package model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-02T16:19:20.449+0200")
@StaticMetamodel(Flight.class)
public class Flight_ {
	public static volatile SingularAttribute<Flight, String> fID;
	public static volatile SingularAttribute<Flight, Airway> fAirway;
	public static volatile SingularAttribute<Flight, Aircraft> fAircraft;
	public static volatile SingularAttribute<Flight, LocalDateTime> fArrival;
	public static volatile SingularAttribute<Flight, LocalDateTime> fDeparture;
	public static volatile ListAttribute<Flight, Passenger> fPassengers;
	public static volatile ListAttribute<Flight, Meal> fMeals;
}
