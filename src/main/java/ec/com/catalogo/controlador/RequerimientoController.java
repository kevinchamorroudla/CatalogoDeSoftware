package ec.com.catalogo.controlador;

import ec.com.cataloglo.servicio.FuncionarioFacadeLocal;
import ec.com.cataloglo.servicio.PersonaFacadeLocal;
import ec.com.cataloglo.servicio.RequerimientoFacadeLocal;
import ec.com.catalogo.modelo.Funcionario;
import ec.com.catalogo.modelo.Persona;
import ec.com.catalogo.modelo.Requerimiento;
import ec.com.catalogo.viewmodel.RequerimientoViewModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class RequerimientoController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private RequerimientoFacadeLocal requerimientoEJB;
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private FuncionarioFacadeLocal funcionarioEJB;
    
    private Requerimiento requerimiento;
    private List<RequerimientoViewModel> requerimientos;
    private Map<String,String> personas;
    private String idSolicitante;
    private String idAprobador;

    public String getIdAprobador() {
        return idAprobador;
    }

    public void setIdAprobador(String idAprobador) {
        this.idAprobador = idAprobador;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public RequerimientoFacadeLocal getRequerimientoEJB() {
        return requerimientoEJB;
    }

    public void setRequerimientoEJB(RequerimientoFacadeLocal requerimientoEJB) {
        this.requerimientoEJB = requerimientoEJB;
    }

    public List<RequerimientoViewModel> getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(List<RequerimientoViewModel> requerimientos) {
        this.requerimientos = requerimientos;
    }

    public Map<String, String> getPersonas() {
        return personas;
    }

    public void setPersonas(Map<String, String> personas) {
        this.personas = personas;
    }
    
    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }
    
    @PostConstruct
    public void init(){
        getAllRequerimientos();
        getAllPersonas();
        requerimiento = new Requerimiento();
    }
    
    public void nuevoRequerimiento(){
        try {
            Funcionario solicitante = funcionarioEJB.find(Integer.parseInt(idSolicitante));
            getRequerimiento().setIdSolicitante(solicitante);
            requerimientoEJB.create(getRequerimiento());
            getAllRequerimientos();
        } catch (Exception e) {
        }
    }
    
    public void getAllRequerimientos(){
        try {
            List<Requerimiento> lReq = requerimientoEJB.findAll();
            this.requerimientos = lReq.stream().map(m -> new RequerimientoViewModel(
                    m.getIdSolicitante().getIdPersona().getNombre(), m.getTipo(), m.getDescripcion(), m.getEstado()
            )).collect(Collectors.toList());
        } catch (Exception e) {
        }
    }
    
    public void getAllPersonas(){
        try {
            List<Persona> lPersonas = personaEJB.findAll();
            this.personas  = new HashMap<>();
            if(lPersonas != null){
                for (Persona item : lPersonas) {
                    this.personas.put(item.getNombre(), item.getIdPersona().toString());
                }
            }
        } catch (Exception e) {
        }
    }
}
