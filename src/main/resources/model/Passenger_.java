package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-02T16:19:20.467+0200")
@StaticMetamodel(Passenger.class)
public class Passenger_ {
	public static volatile SingularAttribute<Passenger, Integer> fID;
	public static volatile SingularAttribute<Passenger, String> fName;
	public static volatile SingularAttribute<Passenger, String> fSurname;
	public static volatile ListAttribute<Passenger, Flight> fFlights;
}
