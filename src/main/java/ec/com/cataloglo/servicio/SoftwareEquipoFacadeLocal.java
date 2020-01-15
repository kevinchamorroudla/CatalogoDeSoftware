/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.SoftwareEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author carlosballadares
 */
@Local
public interface SoftwareEquipoFacadeLocal {

    void create(SoftwareEquipo softwareEquipo);

    void edit(SoftwareEquipo softwareEquipo);

    void remove(SoftwareEquipo softwareEquipo);

    SoftwareEquipo find(Object id);

    List<SoftwareEquipo> findAll();

    List<SoftwareEquipo> findRange(int[] range);

    int count();
    
}
