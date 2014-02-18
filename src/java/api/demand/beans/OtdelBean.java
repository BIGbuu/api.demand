package api.demand.beans;

import api.demand.HibernateUtil;
import api.demand.model.Otdel;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author BIG_bu
 */

@Named("otdelBean")
@RequestScoped
public class OtdelBean {
    private List <Otdel> otdels;

    public OtdelBean() {
    }
    
    public List<Otdel> getOtdels() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        this.otdels = s.createCriteria(Otdel.class)
                .add(Restrictions.eq("deleted","0"))
                .addOrder(Order.asc("name"))
                .list();
        s.close();
        return this.otdels;
    }
    
    
    
    
    
}
