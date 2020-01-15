/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.NavegadorWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface NavegadorWebFacadeLocal {

    void create(NavegadorWeb navegadorWeb);

    void edit(NavegadorWeb navegadorWeb);

    void remove(NavegadorWeb navegadorWeb);

    NavegadorWeb find(Object id);

    List<NavegadorWeb> findAll();

    List<NavegadorWeb> findRange(int[] range);

    int count();
    
}
