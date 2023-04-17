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
@Table(name = "consultations")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c")
    , @NamedQuery(name = "Consultation.findById", query = "SELECT c FROM Consultation c WHERE c.id = :id")
    , @NamedQuery(name = "Consultation.findByDateHeure", query = "SELECT c FROM Consultation c WHERE c.dateHeure = :dateHeure")
    , @NamedQuery(name = "Consultation.findByPrescriptions", query = "SELECT c FROM Consultation c WHERE c.prescriptions = :prescriptions")
    , @NamedQuery(name = "Consultation.findByExamensPrescrits", query = "SELECT c FROM Consultation c WHERE c.examensPrescrits = :examensPrescrits")})
public class Consultation implements Serializable {

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
    @Column(name = "prescriptions")
    private String prescriptions;
    @Basic(optional = false)
    @Column(name = "examens_prescrits")
    private String examensPrescrits;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;
    @JoinColumn(name = "medecin_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medecin medecinId;

    public Consultation() {
    }

    public Consultation(Integer id) {
        this.id = id;
    }

    public Consultation(Integer id, Date dateHeure, String prescriptions, String examensPrescrits) {
        this.id = id;
        this.dateHeure = dateHeure;
        this.prescriptions = prescriptions;
        this.examensPrescrits = examensPrescrits;
    }

    public Consultation(Date dateHeure, String examensPrescrits, String prescriptions, Medecin medecinId, Patient patientId) {
        this.dateHeure = dateHeure;
        this.prescriptions = prescriptions;
        this.examensPrescrits = examensPrescrits;
        this.patientId = patientId;
        this.medecinId = medecinId;    }
    

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

    public String getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(String prescriptions) {
        this.prescriptions = prescriptions;
    }

    public String getExamensPrescrits() {
        return examensPrescrits;
    }

    public void setExamensPrescrits(String examensPrescrits) {
        this.examensPrescrits = examensPrescrits;
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
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Consultation[ id=" + id + " ]";
    }
    
}
