package converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Aircraft;
import model.Flight;

@FacesConverter("aircraftModelConverter")
public class AircraftConverter implements Converter{
	
	private ObjectSerializer<Flight> objectSerializer = new ObjectSerializer<Flight>();

	
	 @Override
	    public String getAsString(FacesContext context, UIComponent component, Object valueToRender) {
	    	return objectSerializer.objectToString((Serializable)valueToRender);
	    }

	    @Override
	    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	        return objectSerializer.stringToObject(submittedValue, Aircraft.class);
	    }

}
