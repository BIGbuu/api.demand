package api.demand.beans;

import api.demand.ClientUtil;
import api.demand.HibernateUtil;
import api.demand.model.Demand;
import api.demand.model.Otdel;
import api.demand.model.RoomType;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.hibernate.Session;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 *
 * @author BIG_bu
 */

@Named("demandBean")
@SessionScoped
public class DemandBean implements Serializable{

    private Demand demand;
    
    private String room;
    private RoomType roomType;
    private Otdel otdel;
    private String comments;
    private String client;
    private String tel;

    public DemandBean() {

        try {
            this.room   = ClientUtil.getHostName().split("-")[1];
        } catch (Exception e) {
            this.room = null;
        }
    }        
    public String getRoom() {
        return this.room;
    }
    public Demand getDemand() {
        return demand;
    }
    public RoomType getRoomType() {
        return this.roomType;
    }
    public Otdel getOtdel() {
        return this.otdel;
    }
    public String getClient() {
        return this.client;
    }
    public String getTel() {
        return tel;
    }
    public String getComments() {
        return comments;
    }
    
    
    public void setDemand(Demand demand) {
        this.demand = demand;
    }
    public void setRoom(String room) {
        this.room = room;
    }
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }    
    public void setOtdel(Otdel otdel) {
        this.otdel = otdel;
    }
    public void setClient(String client) {
        this.client = client;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public void addDemand(ActionEvent actionEvent) {
        try {
            if (this.demand.getId() != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Заявка УЖЕ принята. Уникальный номер вашей заявки №: "+this.demand.getId()));
                return;
            }
        } catch (NullPointerException e) {
        }
                Session s = HibernateUtil.getSessionFactory().openSession();
                s.beginTransaction();
                Integer roomTypeId = 0;
                Integer otdelId = 0;
                try {
                     roomTypeId = this.roomType.getId(); 
                } catch (NullPointerException e) {
                }
                try {
                     otdelId = this.otdel.getId(); 
                } catch (NullPointerException e) {
                }


                this.demand = new Demand(this.room, roomTypeId, otdelId, this.comments, this.client, this.tel);
                s.save(this.demand);
                assertNotNull(this.demand.getId());

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Заявка принята. Уникальный номер вашей заявки №: "+this.demand.getId()));
        /*          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Заявка принята. №: "+
                          "|room:"+this.room+
                          "|roomType:"+Integer.parseInt(this.roomType)+
                          "|otdel:"+this.otdel.getId()+
                          "|comments:"+this.comments+
                          "|client:"+this.client+
                          "|tel:"+this.tel
                          ));
        */        
                s.close();
            
        
    }
}
