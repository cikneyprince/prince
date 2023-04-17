/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Medecin;

/**
 *
 * @author Cikneyprince
 */
public interface IMedecin {
     Medecin addMedecin(Medecin medecin);
     List<Medecin> allMedecin();
     Medecin updateMedecin(Medecin medecin);
    void deleteMedecin(Medecin medecin);
    Medecin findMedecinById(Long id);
    
}
