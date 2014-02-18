package api.demand.beans;

import java.util.List;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import api.demand.HibernateUtil;
import api.demand.model.Work;
import javax.enterprise.context.RequestScoped;
/**
 *
 * @author BIG_bu
 */

@Named("workBean")
@RequestScoped
public class WorkBean {
    private List<Work> works;

    public WorkBean() {
    }
    
    public List<Work> getWorks() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        this.works = s.createCriteria(Work.class)
                .add(Restrictions.eq("deleted","0"))
                .list();
        s.close();
        return this.works;
    }
}
