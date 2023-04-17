/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Consultation;

/**
 *
 * @author Cikneyprince
 */
public interface IConsultation {
    Consultation addConsultation(Consultation consultation);
    List<Consultation> allConsultation();
    Consultation updateConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    Consultation findConsultationById(Long id);
    
}
