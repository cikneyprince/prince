/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Rdv;

/**
 *
 * @author Cikneyprince
 */
public interface IRdv {
   Rdv addRdv(Rdv rdv);
    List<Rdv> allRdv();
   Rdv updateRdv(Rdv rdv);
    void deleteRdv(Rdv rdv);
   Rdv findRdvById(Long id);
    
}
