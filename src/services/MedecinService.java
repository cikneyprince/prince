/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
package services;

import dao.IMedecin;
import models.Medecin;
import utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;



/**
 *
 * @author Cikneyprince
 */
public class MedecinService implements IMedecin {
    


    private EntityManager entityManager = null;

    public MedecinService() {
        entityManager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Medecin addMedecin(Medecin medecin) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(medecin);
            entityManager.flush();
            transaction.commit();
            return medecin;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de l'ajout du medecin : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Medecin> allMedecin() {
        try {
            return entityManager.createNamedQuery("Medecin.findAll", Medecin.class).getResultList();
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la récupération de tous les medecins : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(medecin);
            entityManager.flush();
            transaction.commit();
            return medecin;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la mise à jour du medecin : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteMedecin(Medecin medecin) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            medecin = entityManager.merge(medecin);
            entityManager.remove(medecin);
            entityManager.flush();
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la suppression du medecin : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Medecin findMedecinById(Long id) {
        try {
            return entityManager.find(Medecin.class, id);
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la recherche du medecin : " + e.getMessage());
            throw e;
        }
    }

    
}
