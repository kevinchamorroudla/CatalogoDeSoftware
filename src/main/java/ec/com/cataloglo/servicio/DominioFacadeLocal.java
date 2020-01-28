/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Dominio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface DominioFacadeLocal {

    void create(Dominio dominio);

    void edit(Dominio dominio);

    void remove(Dominio dominio);

    Dominio find(Object id);

    List<Dominio> findAll();

    List<Dominio> findRange(int[] range);

    int count();
    
}
