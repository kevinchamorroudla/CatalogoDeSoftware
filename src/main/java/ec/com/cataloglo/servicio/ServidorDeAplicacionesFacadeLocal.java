/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.ServidorDeAplicaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface ServidorDeAplicacionesFacadeLocal {

    void create(ServidorDeAplicaciones servidorDeAplicaciones);

    void edit(ServidorDeAplicaciones servidorDeAplicaciones);

    void remove(ServidorDeAplicaciones servidorDeAplicaciones);

    ServidorDeAplicaciones find(Object id);

    List<ServidorDeAplicaciones> findAll();

    List<ServidorDeAplicaciones> findRange(int[] range);

    int count();
    
}
