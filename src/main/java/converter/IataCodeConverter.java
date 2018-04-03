package converter;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import model.Airport;
import services.EntityManagerProvider;

public class IataCodeConverter implements Converter{
    
    @EJB
    private EntityManagerProvider emp;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return emp.getEntitiyManager().createNamedQuery("Airport.findByIataCode", Airport.class);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	System.out.println("hallo");
        return value == null ? "select" : ((Airport) value).getIataCode();
    }

}
