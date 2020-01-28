/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Lenguaje;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface LenguajeFacadeLocal {

    void create(Lenguaje lenguaje);

    void edit(Lenguaje lenguaje);

    void remove(Lenguaje lenguaje);

    Lenguaje find(Object id);

    List<Lenguaje> findAll();

    List<Lenguaje> findRange(int[] range);

    int count();
    
}
