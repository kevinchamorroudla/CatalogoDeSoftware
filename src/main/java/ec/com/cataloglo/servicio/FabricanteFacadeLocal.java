/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Fabricante;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface FabricanteFacadeLocal {

    void create(Fabricante fabricante);

    void edit(Fabricante fabricante);

    void remove(Fabricante fabricante);

    Fabricante find(Object id);

    List<Fabricante> findAll();

    List<Fabricante> findRange(int[] range);

    int count();
    
}
