/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Plataforma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface PlataformaFacadeLocal {

    void create(Plataforma plataforma);

    void edit(Plataforma plataforma);

    void remove(Plataforma plataforma);

    Plataforma find(Object id);

    List<Plataforma> findAll();

    List<Plataforma> findRange(int[] range);

    int count();
    
}
