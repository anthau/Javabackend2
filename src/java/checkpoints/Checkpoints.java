/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkpoints;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author antto
 */
@Entity
@Table(name = "CHECKPOINTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checkpoints.findAll", query = "SELECT c FROM Checkpoints c")
    , @NamedQuery(name = "Checkpoints.findById", query = "SELECT c FROM Checkpoints c WHERE c.id = :id")
    , @NamedQuery(name = "Checkpoints.findByLat", query = "SELECT c FROM Checkpoints c WHERE c.lat = :lat")
    , @NamedQuery(name = "Checkpoints.findByLon", query = "SELECT c FROM Checkpoints c WHERE c.lon = :lon")})
public class Checkpoints implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LAT")
    private Double lat;
    @Column(name = "LON")
    private Double lon;
    @Lob
    @Size(max = 32700)
    @Column(name = "HINT")
    private String hint;
    @Lob
    @Column(name = "PICTURE")
    private Serializable picture;

    public Checkpoints() {
    }

    public Checkpoints(Long id) {
        this.id = id;
    }

    public Checkpoints(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Serializable getPicture() {
        return picture;
    }

    public void setPicture(Serializable picture) {
        this.picture = picture;
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
        if (!(object instanceof Checkpoints)) {
            return false;
        }
        Checkpoints other = (Checkpoints) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "checkpoints.Checkpoints[ id=" + id + " ]";
    }
    
}
