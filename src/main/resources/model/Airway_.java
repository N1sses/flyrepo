package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-04-02T16:19:20.440+0200")
@StaticMetamodel(Airway.class)
public class Airway_ {
	public static volatile SingularAttribute<Airway, Integer> fID;
	public static volatile SingularAttribute<Airway, Airport> fStart;
	public static volatile SingularAttribute<Airway, Airport> fDestination;
	public static volatile ListAttribute<Airway, Flight> fFlights;
}
