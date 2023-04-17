/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Patient;

/**
 *
 * @author Cikneyprince
 */
public interface IPatient {
    Patient addPatient(Patient patient);
    List<Patient> allPatient();
    Patient updatePatient(Patient patient);
    void deletePatient(Patient patient);
    Patient findPatientById(Long id);
    
}
