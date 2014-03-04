package api.demand.beans;

import api.demand.ClientUtil;
import api.demand.HibernateUtil;
import api.demand.model.Demand;
import api.demand.model.Otdel;
import api.demand.model.Printer;
import api.demand.model.RoomType;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
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

    private Demand  demand;

    private String  hostName;
    private String  hostIp;
    
    private String  room;
    private RoomType roomType;
    private Otdel   otdel;
    private String  comments;
    private Printer Pprinter;
    private String  printer;
        private Boolean printerConfirm;

    private String  client;
    private String  tel;
    private String  httpHeader;
    public DemandBean() {

        try {
            this.hostName   = ClientUtil.getHostName();
            this.hostIp     = ClientUtil.getIp();
            this.room       = this.hostName.split("-")[1];
        } catch (Exception e) {
            this.room = null;
        }
    }        
    public boolean Session() {
        try {
            if (this.demand.getId() != null) {
                FacesContext.getCurrentInstance().addMessage(null, 
                        new FacesMessage("Уникальный номер вашей заявки №: "+this.demand.getId()) );            
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }
    public String getRoom() throws IllegalStateException{
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
    public String getPprinter() {
        return this.Pprinter.getName();
    }
    public String getPrinter() {
        return this.printer;
    }
    public Boolean getPrinterConfirm() {
        return this.printerConfirm;
    }
    public String getHttpHeader() {
        String tmp = "";
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            Map<String,String> map = fc.getExternalContext().getRequestHeaderMap();
            
            for(Object o : map.keySet().toArray()){
              tmp += o+": "+map.get(o);
            }
        } catch (Exception e) {
        }
        return "123: "+tmp;
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
    public void setPprinter(String printer) {
        this.Pprinter.setName(printer);
    }
    public void setPrinter(String printer) {
        this.printer=printer;
    }
    public void setPrinterConfirm(Boolean printerConfirm) {
        this.printerConfirm=printerConfirm;
    }

    public void addDemand(ActionEvent actionEvent) {
        try {
            if (this.demand.getId() != null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Уникальный номер вашей заявки №: "+this.demand.getId()) );
                return;
            }
        } catch (NullPointerException e) {
        }
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Integer roomTypeId = 0;
        Integer otdelId = 0;
        String printer  = ((this.printerConfirm)?("принтер:"+this.printer):"");
        try {
            roomTypeId = this.roomType.getId();
        } catch (NullPointerException e) {
        }
        try {
            otdelId = this.otdel.getId();
        } catch (NullPointerException e) {
        }

        this.demand = new Demand(
                this.room,
                roomTypeId,
                otdelId,
                this.comments + " " + printer + "| from api.demand: " + this.hostName + "@" + this.hostIp,
                this.client,
                this.tel);

        s.save(this.demand);
        assertNotNull(this.demand.getId());

        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Заявка принята. №:"+this.demand.getId()) );
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("каб.       : "+  this.room));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("тип каб.   : "+  this.roomType.getName()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("отдел      : "+  this.otdel.getName()));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("комментарии: "+  this.comments+ " " + printer));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ФИО        : "+  this.client));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("тел        : "+  this.tel));

        
        s.close();
            
        
    }
}
