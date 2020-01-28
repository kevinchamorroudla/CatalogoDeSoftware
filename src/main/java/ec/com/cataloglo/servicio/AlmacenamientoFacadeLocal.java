/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Almacenamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface AlmacenamientoFacadeLocal {

    void create(Almacenamiento almacenamiento);

    void edit(Almacenamiento almacenamiento);

    void remove(Almacenamiento almacenamiento);

    Almacenamiento find(Object id);

    List<Almacenamiento> findAll();

    List<Almacenamiento> findRange(int[] range);

    int count();
    
}
