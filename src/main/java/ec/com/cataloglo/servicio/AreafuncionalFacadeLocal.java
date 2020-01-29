/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Areafuncional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author labmacq
 */
@Local
public interface AreafuncionalFacadeLocal {

    void create(Areafuncional areafuncional);

    void edit(Areafuncional areafuncional);

    void remove(Areafuncional areafuncional);

    Areafuncional find(Object id);

    List<Areafuncional> findAll();

    List<Areafuncional> findRange(int[] range);

    int count();
    
}
