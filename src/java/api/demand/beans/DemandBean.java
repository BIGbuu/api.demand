package api.demand.beans;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import api.demand.HibernateUtil;
import api.demand.model.Demand;
import api.demand.model.Otdel;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import api.demand.ClientUtil;

/**
 *
 * @author BIG_bu
 */

@Named("demandBean")
@RequestScoped
public class DemandBean {
    private List<Demand> demands;

    private String room;
    private Otdel otdel;
    private String client;

    public DemandBean() {

        try {
            this.room   = ClientUtil.getHostName().split("-")[1];
        } catch (Exception e) {
            this.room = "";
        }
/*        if (this.otdel != null) {
            Session s = HibernateUtil.getSessionFactory().openSession();
            s.beginTransaction();
            try {
                Query q = s.getNamedQuery(Otdel.findByIdCotem)
                        .setInteger("idCotem", otdel.getId());
                try {
                    this.otdel = (Otdel) q.uniqueResult();
                } catch (HibernateException e) {
                    this.otdel = null;
                }
            } finally {
                s.close();        
            }
        }
*/
    }        
    public String getRoom() {
        return this.room;
    }
    
    public Otdel getOtdel() {
        return this.otdel;
    }
    
    public String getClient() {
        return this.client;
    }
    public void setRoom(String room) {
        this.room = room;
    }

    public void setOtdel(Otdel otdel) {
        this.otdel = otdel;
    }

    public void setClient(String client) {
        this.client = client;
    }
    public List<Demand> getDemands() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        
        this.demands = s.createCriteria(Demand.class)
                .add(Restrictions.eq("deleted", "0"))
                .list();

        return this.demands;
    }
    public void addDemand(ActionEvent actionEvent) {
/*        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.getTransaction().commit();
        
        //FacesMessage msg = new FacesMessage("Заявка принята.", Integer.toString(((Demand) event.getObject()).getId()) );
*/
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Заявка принята."));
        
//        s.close();
        
    }
}
