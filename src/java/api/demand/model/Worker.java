/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api.demand.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BIG_bu
 */
@Entity
@Table(name = "worker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Worker.findAll", query = "SELECT w FROM Worker w"),
    @NamedQuery(name = "Worker.findById", query = "SELECT w FROM Worker w WHERE w.id = :id"),
    @NamedQuery(name = "Worker.findByName", query = "SELECT w FROM Worker w WHERE w.name = :name"),
    @NamedQuery(name = "Worker.findByType", query = "SELECT w FROM Worker w WHERE w.type = :type"),
    @NamedQuery(name = "Worker.findByImgHref", query = "SELECT w FROM Worker w WHERE w.imgHref = :imgHref"),
    @NamedQuery(name = "Worker.findByTel", query = "SELECT w FROM Worker w WHERE w.tel = :tel"),
    @NamedQuery(name = "Worker.findByEmail", query = "SELECT w FROM Worker w WHERE w.email = :email"),
    @NamedQuery(name = "Worker.findByDeleted", query = "SELECT w FROM Worker w WHERE w.deleted = :deleted")})
public class Worker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "img_href")
    private String imgHref;
    @Size(max = 200)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "deleted")
    private String deleted;

    public Worker() {
    }

    public Worker(Integer id) {
        this.id = id;
    }

    public Worker(Integer id, String name, String type, String imgHref, String email, String deleted) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imgHref = imgHref;
        this.email = email;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgHref() {
        return imgHref;
    }

    public void setImgHref(String imgHref) {
        this.imgHref = imgHref;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
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
        if (!(object instanceof Worker)) {
            return false;
        }
        Worker other = (Worker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.demand.model.Worker[ id=" + id + " ]";
    }
    
}
