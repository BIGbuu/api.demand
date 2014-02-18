package api.demand.converter;

import api.demand.HibernateUtil;
import api.demand.model.RoomType;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author BIG_bu
 */
@Named
@RequestScoped
@FacesConverter(value = "roomType")
public class RoomTypeConvertor implements Converter {
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
/*        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        try {
            Query q = s.getNamedQuery(RoomType.findById)
                    .setInteger("id", Integer.parseInt(value));
            try {
                RoomType roomType = (RoomType) q.uniqueResult();
                return roomType;
            } catch (HibernateException e) {
            }
        } finally {
            s.close();
        }
 */       return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof RoomType) || ((RoomType) value).getId() == null) {
            return null;
        }
        return ((RoomType) value).getId().toString();
    }
    
}
