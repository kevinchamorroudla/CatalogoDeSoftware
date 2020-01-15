/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.AreaFuncional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface AreaFuncionalFacadeLocal {

    void create(AreaFuncional areaFuncional);

    void edit(AreaFuncional areaFuncional);

    void remove(AreaFuncional areaFuncional);

    AreaFuncional find(Object id);

    List<AreaFuncional> findAll();

    List<AreaFuncional> findRange(int[] range);

    int count();
    
}
