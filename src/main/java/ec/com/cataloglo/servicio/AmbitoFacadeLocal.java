/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Ambito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface AmbitoFacadeLocal {

    void create(Ambito ambito);

    void edit(Ambito ambito);

    void remove(Ambito ambito);

    Ambito find(Object id);

    List<Ambito> findAll();

    List<Ambito> findRange(int[] range);

    int count();
    
}
