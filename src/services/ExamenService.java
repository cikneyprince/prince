/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
package services;

import dao.IExamen;
import models.Examen;
import utils.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;



/**
 *
 * @author Cikneyprince
 */
public class ExamenService implements IExamen {
    


    private EntityManager entityManager = null;

    public ExamenService() {
        entityManager = EntityManagerUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Examen addExamen(Examen examen) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(examen);
            entityManager.flush();
            transaction.commit();
            return examen;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de l'ajout du examen : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Examen> allExamen() {
        try {
            return entityManager.createNamedQuery("Examen.findAll", Examen.class).getResultList();
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la récupération de tous les examens : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Examen updateExamen(Examen examen) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(examen);
            entityManager.flush();
            transaction.commit();
            return examen;
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la mise à jour du examen : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteExamen(Examen examen) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            examen = entityManager.merge(examen);
            entityManager.remove(examen);
            entityManager.flush();
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erreur lors de la suppression du examen : " + e.getMessage());
            throw e;
        }
    }

    @Override
    public Examen findExamenById(Long id) {
        try {
            return entityManager.find(Examen.class, id);
        } catch (PersistenceException e) {
            System.err.println("Erreur lors de la recherche du examen : " + e.getMessage());
            throw e;
        }
    }

    
}
