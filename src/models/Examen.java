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
@Table(name = "examens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examen.findAll", query = "SELECT e FROM Examen e")
    , @NamedQuery(name = "Examen.findById", query = "SELECT e FROM Examen e WHERE e.id = :id")
    , @NamedQuery(name = "Examen.findByNom", query = "SELECT e FROM Examen e WHERE e.nom = :nom")
    , @NamedQuery(name = "Examen.findByDateExamen", query = "SELECT e FROM Examen e WHERE e.dateExamen = :dateExamen")
    , @NamedQuery(name = "Examen.findByResultat", query = "SELECT e FROM Examen e WHERE e.resultat = :resultat")})
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "date_examen")
    @Temporal(TemporalType.DATE)
    private Date dateExamen;
    @Basic(optional = false)
    @Column(name = "resultat")
    private String resultat;
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Patient patientId;
    @JoinColumn(name = "medecin_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Medecin medecinId;

    public Examen() {
    }

    public Examen(Integer id) {
        this.id = id;
    }

    public Examen(Integer id, String nom, Date dateExamen, String resultat) {
        this.id = id;
        this.nom = nom;
        this.dateExamen = dateExamen;
        this.resultat = resultat;
    }

    public Examen(String nom, Date dateExamen, Medecin medecinId, Patient patientId, String resultat) {
        this.nom = nom;
        this.dateExamen = dateExamen;
        this.resultat = resultat;
        this.patientId = patientId;
        this.medecinId = medecinId; 
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
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
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Examen[ id=" + id + " ]";
    }
    
}
