/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Respaldo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface RespaldoFacadeLocal {

    void create(Respaldo respaldo);

    void edit(Respaldo respaldo);

    void remove(Respaldo respaldo);

    Respaldo find(Object id);

    List<Respaldo> findAll();

    List<Respaldo> findRange(int[] range);

    int count();
    
}
