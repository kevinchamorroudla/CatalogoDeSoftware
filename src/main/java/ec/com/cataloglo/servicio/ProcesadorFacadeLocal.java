/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Procesador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface ProcesadorFacadeLocal {

    void create(Procesador procesador);

    void edit(Procesador procesador);

    void remove(Procesador procesador);

    Procesador find(Object id);

    List<Procesador> findAll();

    List<Procesador> findRange(int[] range);

    int count();
    
}
