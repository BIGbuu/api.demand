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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BIG_bu
 */
@Entity
@Table(name = "otdel", uniqueConstraints = { 
                        @UniqueConstraint(columnNames = "id") })
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Otdel.findAll, query = "SELECT o FROM Otdel o"),
    @NamedQuery(name = Otdel.findById, query = "SELECT o FROM Otdel o WHERE o.id = :id"),
    @NamedQuery(name = Otdel.findByIdCotem, query = "SELECT o FROM Otdel o WHERE o.idCotem = :idCotem"),
    @NamedQuery(name = Otdel.findByName, query = "SELECT o FROM Otdel o WHERE o.name = :name"),
    @NamedQuery(name = Otdel.findByFullname, query = "SELECT o FROM Otdel o WHERE o.fullname = :fullname"),
    @NamedQuery(name = Otdel.findByDeleted, query = "SELECT o FROM Otdel o WHERE o.deleted = :deleted")})

public class Otdel implements Serializable {
    
    public static final String findAll          = "findAll";
    public static final String findById         = "findById";
    public static final String findByIdCotem    = "findByIdCotem";
    public static final String findByName       = "findByName";
    public static final String findByFullname   = "findByFullname";
    public static final String findByDeleted    = "findByDeleted";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_cotem")
    private Integer idCotem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "name")
    private String name;
    @Size(max = 250)
    @Column(name = "fullname")
    private String fullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "deleted")
    private String deleted;

    public Otdel() {
    }

    public Otdel(Integer id) {
        this.id = id;
    }

    public Otdel(Integer id, String name, String deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCotem() {
        return idCotem;
    }

    public void setIdCotem(Integer idCotem) {
        this.idCotem = idCotem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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
        if (!(object instanceof Otdel)) {
            return false;
        }
        Otdel other = (Otdel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "api.demand.model.Otdel[ id=" + id + " ]";
    }
    
}
