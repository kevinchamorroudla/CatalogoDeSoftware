package ec.com.catalogo.viewmodel;

import java.io.Serializable;

public class FuncionarioViewModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String cedula;
    private String nombre;
    private String areaNombre;

    public FuncionarioViewModel(String cedula, String nombre, String areaNombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.areaNombre = areaNombre;
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    @Override
    public String toString() {
        return "FuncionarioViewModel{" + "cedula=" + cedula + ", nombre=" + nombre + ", areaNombre=" + areaNombre + '}';
    }
    
}
