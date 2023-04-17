/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Examen;

/**
 *
 * @author Cikneyprince
 */
public interface IExamen {
    Examen addExamen(Examen examen);
           List<Examen> allExamen();
           Examen updateExamen(Examen examen);
           void deleteExamen(Examen examen);
           Examen findExamenById(Long id);
    
    
}
