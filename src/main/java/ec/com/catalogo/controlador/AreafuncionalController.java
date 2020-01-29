/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.cataloglo.servicio.AreafuncionalFacadeLocal;
import ec.com.catalogo.modelo.Areafuncional;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

@Named("areafuncionalController")
@ViewScoped
public class AreafuncionalController implements Serializable{
    
    @EJB
    private AreafuncionalFacadeLocal areaEJB;
    
    private Areafuncional area;
    
    private List<Areafuncional> listaAreas;
    
    @PostConstruct
    public void init(){
        this.area = new Areafuncional();
        this.listaAreas = areaEJB.findAll();
    }

    public Areafuncional getArea() {
        return area;
    }

    public void setArea(Areafuncional area) {
        this.area = area;
    }

    public List<Areafuncional> getListaAreas() {
        return listaAreas;
    }

    public void setListaAreas(List<Areafuncional> listaAreas) {
        this.listaAreas = listaAreas;
    }
    
    public void editListener(RowEditEvent event) {
        try{
            Areafuncional refrescoEditado = (Areafuncional) event.getObject();
            areaEJB.edit(refrescoEditado);
        } 
        catch(Exception ex) {
            
        }
    }
    
    public void registrarArea(){
        try{
            areaEJB.create(this.area);
            this.area = null;
            this.init();
        }catch(Exception ex){

        }
        
    }
    
    public void eliminarArea() {
        try{
            areaEJB.remove(this.area);
            this.area = null;
            this.init();
        } catch(Exception ex) {
            
        }
    }
    
    public void reiniciarEntidadSeleccionada(){
        this.area = new Areafuncional();
    }
}
