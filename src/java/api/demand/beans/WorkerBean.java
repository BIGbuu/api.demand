package api.demand.beans;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import api.demand.HibernateUtil;
import api.demand.model.Worker;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
/**
 *
 * @author BIG_bu
 */
@Named("workerBean")
@RequestScoped
public class WorkerBean {
    private List<Worker> workers;

    public WorkerBean() {
    }
    
    public List<Worker> getWorkers() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        this.workers = s.createCriteria(Worker.class)
                .add(Restrictions.eq("deleted","0"))
                .list();
        return this.workers;
    }
}
