/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.SoftwareRequerimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface SoftwareRequerimientoFacadeLocal {

    void create(SoftwareRequerimiento softwareRequerimiento);

    void edit(SoftwareRequerimiento softwareRequerimiento);

    void remove(SoftwareRequerimiento softwareRequerimiento);

    SoftwareRequerimiento find(Object id);

    List<SoftwareRequerimiento> findAll();

    List<SoftwareRequerimiento> findRange(int[] range);

    int count();
    
}
