/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
package services;

import dao.IConsultation;
import models.Consultation;
import utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;



/**
 *
 * @author Cikneyprince
 */
public class ConsultationService implements IConsultation {
    


    private EntityManager entityManager = null;

    public ConsultationService() {
        entityManager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Consultation addConsultation(Consultation consultation) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(consultation);
            entityManager.flush();
            transaction.commit();
            return consultation;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de l'ajout du consultation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Consultation> allConsultation() {
        try {
            return entityManager.createNamedQuery("Consultation.findAll", Consultation.class).getResultList();
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la récupération de tous les consultations : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Consultation updateConsultation(Consultation consultation) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(consultation);
            entityManager.flush();
            transaction.commit();
            return consultation;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la mise à jour du consultation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteConsultation(Consultation consultation) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            consultation = entityManager.merge(consultation);
            entityManager.remove(consultation);
            entityManager.flush();
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la suppression du consultation : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Consultation findConsultationById(Long id) {
        try {
            return entityManager.find(Consultation.class, id);
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la recherche du consultation : " + e.getMessage());
            throw e;
        }
    }

    
}
