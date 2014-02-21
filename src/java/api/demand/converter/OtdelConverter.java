package api.demand.converter;

import api.demand.HibernateUtil;
import api.demand.model.Otdel;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author BIG_bu
 */

@Named
@RequestScoped
@FacesConverter(value = "otdel")
public class OtdelConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        try {
            Query q = s.getNamedQuery(Otdel.findById)
                    .setInteger("id", Integer.parseInt(value));
            try {
                Otdel otdel = (Otdel) q.uniqueResult();
                return otdel;
            } catch (HibernateException e) {
                return null; 
            }
        } catch (NumberFormatException e) {
                return null;
        } finally {
            s.close();
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Otdel) || ((Otdel) value).getId() == null) {
            return null;
        }
        return ((Otdel) value).getId().toString();
    
    }

}