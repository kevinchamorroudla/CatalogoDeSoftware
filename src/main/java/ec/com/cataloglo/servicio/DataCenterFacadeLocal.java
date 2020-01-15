/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.DataCenter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface DataCenterFacadeLocal {

    void create(DataCenter dataCenter);

    void edit(DataCenter dataCenter);

    void remove(DataCenter dataCenter);

    DataCenter find(Object id);

    List<DataCenter> findAll();

    List<DataCenter> findRange(int[] range);

    int count();
    
}
