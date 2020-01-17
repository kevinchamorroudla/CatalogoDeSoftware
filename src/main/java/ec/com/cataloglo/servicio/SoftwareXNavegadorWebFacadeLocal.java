/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.SoftwareXNavegadorWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface SoftwareXNavegadorWebFacadeLocal {

    void create(SoftwareXNavegadorWeb softwareXNavegadorWeb);

    void edit(SoftwareXNavegadorWeb softwareXNavegadorWeb);

    void remove(SoftwareXNavegadorWeb softwareXNavegadorWeb);

    SoftwareXNavegadorWeb find(Object id);

    List<SoftwareXNavegadorWeb> findAll();

    List<SoftwareXNavegadorWeb> findRange(int[] range);

    int count();
    
}
