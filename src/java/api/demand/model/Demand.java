/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api.demand.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author BIG_bu
 */
@Entity
@Table(name = "demands")
@DynamicInsert
@DynamicUpdate
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Demand.findAll", query = "SELECT d FROM Demand d"),
    @NamedQuery(name = "Demand.findById", query = "SELECT d FROM Demand d WHERE d.id = :id"),
    @NamedQuery(name = "Demand.findByRoom", query = "SELECT d FROM Demand d WHERE d.room = :room"),
    @NamedQuery(name = "Demand.findByIdRoomType", query = "SELECT d FROM Demand d WHERE d.idRoomType = :idRoomType"),
    @NamedQuery(name = "Demand.findByIdOtdel", query = "SELECT d FROM Demand d WHERE d.idOtdel = :idOtdel"),
    @NamedQuery(name = "Demand.findByIdWork", query = "SELECT d FROM Demand d WHERE d.idWork = :idWork"),
    @NamedQuery(name = "Demand.findByClient", query = "SELECT d FROM Demand d WHERE d.client = :client"),
    @NamedQuery(name = "Demand.findByTel", query = "SELECT d FROM Demand d WHERE d.tel = :tel"),
    @NamedQuery(name = "Demand.findByTimeIn", query = "SELECT d FROM Demand d WHERE d.timeIn = :timeIn"),
    @NamedQuery(name = "Demand.findByIdAcceptedBy", query = "SELECT d FROM Demand d WHERE d.idAcceptedBy = :idAcceptedBy"),
    @NamedQuery(name = "Demand.findByTimeStart", query = "SELECT d FROM Demand d WHERE d.timeStart = :timeStart"),
    @NamedQuery(name = "Demand.findByTimeEnd", query = "SELECT d FROM Demand d WHERE d.timeEnd = :timeEnd"),
    @NamedQuery(name = "Demand.findByIdEndBy", query = "SELECT d FROM Demand d WHERE d.idEndBy = :idEndBy"),
    @NamedQuery(name = "Demand.findByIdHelpedBy", query = "SELECT d FROM Demand d WHERE d.idHelpedBy = :idHelpedBy"),
    @NamedQuery(name = "Demand.findByPriority", query = "SELECT d FROM Demand d WHERE d.priority = :priority"),
    @NamedQuery(name = "Demand.findByDeleted", query = "SELECT d FROM Demand d WHERE d.deleted = :deleted"),
    @NamedQuery(name = "Demand.findByIdDeleted", query = "SELECT d FROM Demand d WHERE d.idDeleted = :idDeleted"),
    @NamedQuery(name = "Demand.findByDeletedIp", query = "SELECT d FROM Demand d WHERE d.deletedIp = :deletedIp"),
    @NamedQuery(name = "Demand.findByDeletedDate", query = "SELECT d FROM Demand d WHERE d.deletedDate = :deletedDate")})
public class Demand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "room")
    private String room;

    @Basic(optional = true)
    @Column(name = "id_room_type")
    private int idRoomType;

    @Basic(optional = false)
    @Column(name = "id_otdel")
    private int idOtdel;

    @Basic(optional = false)
    @Column(name = "id_work")
    private int idWork;

    @Basic(optional = false)
    @Lob
    @Size(min = 0, max = 2147483647)
    @Column(name = "comments")
    private String comments     =   "";

    @Basic(optional = true)
    @Lob
    @Size(min = 0, max = 2147483647)
    @Column(name = "inf")
    private String inf          =   "";
    
    @Basic(optional = false)
    @Size(min = 1, max = 40)
    @Column(name = "client")
    private String client;
    
    @Basic(optional = false)
    @Size(min = 1, max = 5)
    @Column(name = "tel")
    private String tel;
    
    @Basic(optional = true)
    @Column(name = "time_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeIn;
    
    @Basic(optional = true)
    @Column(name = "id_accepted_by")
    private int idAcceptedBy;
    
    @Basic(optional = true)
    @Column(name = "time_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStart;
    
    @Basic(optional = true)
    @Column(name = "time_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeEnd;
    
    @Basic(optional = true)
    @Column(name = "id_end_by")
    private int idEndBy;
    
    @Basic(optional = true)
    @Column(name = "id_helped_by")
    private int idHelpedBy;
    
    @Basic(optional = true)
    @Size(min = 1, max = 2)
    @Column(name = "priority")
    private String priority;
    
    @Basic(optional = true)
    @Column(name = "deleted")
    private boolean deleted;
    
    @Basic(optional = true)
    @Column(name = "id_deleted")
    private int idDeleted;
    
    @Basic(optional = true)
    @Size(min = 1, max = 20)
    @Column(name = "deleted_ip")
    private String deletedIp;
    
    @Basic(optional = true)
    @Column(name = "deleted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    public Demand() {
    }

    public Demand(Integer id) {
        this.id = id;
    }

    public Demand(String room, int idRoomType, int idOtdel, String comments, String client, String tel) {
        this.id = null;
        this.room = room;
        this.idRoomType = idRoomType;
        this.idOtdel = idOtdel;
        this.idWork = 7;
        this.comments = comments;
        this.client = client;
        this.tel = tel;
//        this.timeIn = null;
//        this.idAcceptedBy = 0;
//        this.timeStart = new Date();
//        this.timeEnd = new Date();
//        this.idEndBy = 0;
//        this.idHelpedBy = 0;
//        this.priority = 0;
//        this.deleted = false;
//        this.idDeleted = 0;
//        this.deletedIp = null;
//        this.deletedDate = null;
    }

    public Demand(Integer id, String room, int idRoomType, int idOtdel, int idWork, String comments, String inf, String client, String tel, Date timeIn, int idAcceptedBy, Date timeStart, Date timeEnd, int idEndBy, int idHelpedBy, String priority, boolean deleted, int idDeleted, String deletedIp, Date deletedDate) {
        this.id = id;
        this.room = room;
        this.idRoomType = idRoomType;
        this.idOtdel = idOtdel;
        this.idWork = idWork;
        this.comments = comments;
        this.inf = inf;
        this.client = client;
        this.tel = tel;
        this.timeIn = timeIn;
        this.idAcceptedBy = idAcceptedBy;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.idEndBy = idEndBy;
        this.idHelpedBy = idHelpedBy;
        this.priority = priority;
        this.deleted = deleted;
        this.idDeleted = idDeleted;
        this.deletedIp = deletedIp;
        this.deletedDate = deletedDate;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getIdRoomType() {
        return idRoomType;
    }

    public void setIdRoomType(int idRoomType) {
        this.idRoomType = idRoomType;
    }

    public int getIdOtdel() {
        return idOtdel;
    }

    public void setIdOtdel(int idOtdel) {
        this.idOtdel = idOtdel;
    }

    public int getIdWork() {
        return idWork;
    }

    public void setIdWork(int idWork) {
        this.idWork = idWork;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Date timeIn) {
        this.timeIn = timeIn;
    }

    public int getIdAcceptedBy() {
        return idAcceptedBy;
    }

    public void setIdAcceptedBy(int idAcceptedBy) {
        this.idAcceptedBy = idAcceptedBy;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public int getIdEndBy() {
        return idEndBy;
    }

    public void setIdEndBy(int idEndBy) {
        this.idEndBy = idEndBy;
    }

    public int getIdHelpedBy() {
        return idHelpedBy;
    }

    public void setIdHelpedBy(int idHelpedBy) {
        this.idHelpedBy = idHelpedBy;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(int idDeleted) {
        this.idDeleted = idDeleted;
    }

    public String getDeletedIp() {
        return deletedIp;
    }

    public void setDeletedIp(String deletedIp) {
        this.deletedIp = deletedIp;
    }

    public Date getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Date deletedDate) {
        this.deletedDate = deletedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demand)) {
            return false;
        }
        Demand other = (Demand) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.demand.model.Demand[ id=" + id + " ]";
    }
    
}
