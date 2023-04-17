/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cikneyprince
 */
@Entity
@Table(name = "rdv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rdv.findAll", query = "SELECT r FROM Rdv r")
    , @NamedQuery(name = "Rdv.findById", query = "SELECT r FROM Rdv r WHERE r.id = :id")
    , @NamedQuery(name = "Rdv.findByDateHeure", query = "SELECT r FROM Rdv r WHERE r.dateHeure = :dateHeure")
    , @NamedQuery(name = "Rdv.findByMotifConsultation", query = "SELECT r FROM Rdv r WHERE r.motifConsultation = :motifConsultation")})
public class Rdv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date_heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Basic(optional = false)
    @Column(name = "motif_consultation")
    private String motifConsultation;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;
    @JoinColumn(name = "medecin_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medecin medecinId;

    public Rdv() {
    }

    public Rdv(Integer id) {
        this.id = id;
    }

    public Rdv(Integer id, Date dateHeure, String motifConsultation) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.motifConsultation = motifConsultation;
    }

    public Rdv(Date dateHeure, String motifConsultation, Patient patientId, Medecin medecinId) {
        this.dateHeure = dateHeure;
        this.motifConsultation = motifConsultation;
        this.patientId = patientId;
        this.medecinId = medecinId;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getMotifConsultation() {
        return motifConsultation;
    }

    public void setMotifConsultation(String motifConsultation) {
        this.motifConsultation = motifConsultation;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Medecin getMedecinId() {
        return medecinId;
    }

    public void setMedecinId(Medecin medecinId) {
        this.medecinId = medecinId;
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
        if (!(object instanceof Rdv)) {
            return false;
        }
        Rdv other = (Rdv) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Rdv[ id=" + id + " ]";
    }
    
}
