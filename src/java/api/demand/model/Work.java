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
@Table(name = "works")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Work.findAll", query = "SELECT w FROM Work w"),
    @NamedQuery(name = "Work.findById", query = "SELECT w FROM Work w WHERE w.id = :id"),
    @NamedQuery(name = "Work.findByName", query = "SELECT w FROM Work w WHERE w.name = :name"),
    @NamedQuery(name = "Work.findByImgHref", query = "SELECT w FROM Work w WHERE w.imgHref = :imgHref"),
    @NamedQuery(name = "Work.findByDeleted", query = "SELECT w FROM Work w WHERE w.deleted = :deleted")})
public class Work implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "img_href")
    private String imgHref;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "deleted")
    private String deleted;

    public Work() {
    }

    public Work(Integer id) {
        this.id = id;
    }

    public Work(Integer id, String name, String imgHref, String deleted) {
        this.id = id;
        this.name = name;
        this.imgHref = imgHref;
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

    public String getImgHref() {
        return imgHref;
    }

    public void setImgHref(String imgHref) {
        this.imgHref = imgHref;
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
        if (!(object instanceof Work)) {
            return false;
        }
        Work other = (Work) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.demand.model.Work[ id=" + id + " ]";
    }
    
}
