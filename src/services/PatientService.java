/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
package services;

import dao.IPatient;
import models.Patient;
import utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;



/**
 *
 * @author Cikneyprince
 */
public class PatientService implements IPatient {
    


    private EntityManager entityManager = null;

    public PatientService() {
        entityManager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Patient addPatient(Patient patient) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(patient);
            entityManager.flush();
            transaction.commit();
            return patient;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de l'ajout du patient : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Patient> allPatient() {
        try {
            return entityManager.createNamedQuery("Patient.findAll", Patient.class).getResultList();
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la récupération de tous les patients : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Patient updatePatient(Patient patient) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(patient);
            entityManager.flush();
            transaction.commit();
            return patient;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la mise à jour du patient : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deletePatient(Patient patient) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            patient = entityManager.merge(patient);
            entityManager.remove(patient);
            entityManager.flush();
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la suppression du patient : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Patient findPatientById(Long id) {
        try {
            return entityManager.find(Patient.class, id);
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la recherche du patient : " + e.getMessage());
            throw e;
        }
    }

    
}
