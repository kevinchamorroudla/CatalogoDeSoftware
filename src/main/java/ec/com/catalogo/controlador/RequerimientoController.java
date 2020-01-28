package ec.com.catalogo.controlador;

import ec.com.cataloglo.servicio.FuncionarioFacadeLocal;
import ec.com.cataloglo.servicio.PersonaFacadeLocal;
import ec.com.cataloglo.servicio.RequerimientoFacadeLocal;
import ec.com.catalogo.modelo.Funcionario;
import ec.com.catalogo.modelo.Persona;
import ec.com.catalogo.modelo.Requerimiento;
import ec.com.catalogo.viewmodel.RequerimientoViewModel;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
    private Map<String,String> tiposRequerimiento;
    private Map<String,String> prioridades;
    private String idSolicitante;
    private String nombreAprobador;

    public String getNombreAprobador() {
        return nombreAprobador;
    }

    public void setNombreAprobador(String nombreAprobador) {
        this.nombreAprobador = nombreAprobador;
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

    public Map<String, String> getTiposRequerimiento() {
        return tiposRequerimiento;
    }

    public void setTiposRequerimiento(Map<String, String> tiposRequerimiento) {
        this.tiposRequerimiento = tiposRequerimiento;
    }

    public Map<String, String> getPrioridades() {
        return prioridades;
    }

    public void setPrioridades(Map<String, String> prioridades) {
        this.prioridades = prioridades;
    }
    
    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }
    
    @PostConstruct
    public void init(){
        try {
            getAllRequerimientos();
            getAllPersonas();
            initListCombos();
            requerimiento = new Requerimiento();
            Instant instant = Instant.now();
            requerimiento.setFechaSolicitud(Date.from(instant));
            this.nombreAprobador = "Usuario Logeado";
        } catch (Exception e) {
            System.out.println("init: " + e.getMessage());
        }
    }
    
    public void nuevoRequerimiento(){
        try {
            List<Funcionario> lFun = funcionarioEJB.findAll();
            
            Funcionario solicitante = lFun.stream()
                    .filter(f -> f.getIdPersona().getIdPersona().equals(Integer.parseInt(idSolicitante.toString())))
                    .findAny().orElse(null);
            
            getRequerimiento().setIdSolicitante(solicitante);
            getRequerimiento().setEstado("PENDIENTE_APROBAR");
            
            System.out.println(getRequerimiento().toString());
            
            requerimientoEJB.create(getRequerimiento());
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro exitoso"));
            
            getAllRequerimientos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void getAllRequerimientos(){
        try {
            List<Requerimiento> lReq = requerimientoEJB.findAll();
            this.requerimientos = lReq.stream().map(m -> new RequerimientoViewModel(
                    m.getIdSolicitante().getIdPersona().getNombre(), m.getTipo(), m.getDescripcion(), m.getEstado()
            )).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("getAllRequerimientos: " + e.getMessage());
        }
    }
    
    public void getAllPersonas(){
        try {
            List<Persona> lPersonas = personaEJB.findAll();
            this.personas  = new HashMap<>();
            if(lPersonas != null){
                lPersonas.forEach((item) -> {
                    this.personas.put(item.getNombre(), item.getIdPersona().toString());
                });
            }
        } catch (Exception e) {
            System.out.println("getAllPersonas: " + e.getMessage());
        }
    }
    
    public void initListCombos(){
        try {
            this.tiposRequerimiento = new HashMap<>();
            this.tiposRequerimiento.put("CAMBIO DEL SISTEMA", "CAMBIO DEL SISTEMA");
            this.tiposRequerimiento.put("MEJORA AL SISTEMA", "MEJORA AL SISTEMA");
            this.tiposRequerimiento.put("CONSULTA DE REPORTES", "CONSULTA DE REPORTES");
            this.tiposRequerimiento.put("CASOS DE ERROR", "CASOS DE ERROR");
            this.tiposRequerimiento.put("APROBAR SOFTWARE DE TERCEROS", "APROBAR SOFTWARE DE TERCEROS");
            this.tiposRequerimiento.put("CAMBIO BASE DE DATOS", "CAMBIO BASE DE DATOS");
            this.tiposRequerimiento.put("OTROS", "OTROS");
            this.prioridades = new HashMap<>();
            this.prioridades.put("ALTA", "ALTA");
            this.prioridades.put("MEDIA", "MEDIA");
            this.prioridades.put("BAJA", "BAJA");
        } catch (Exception e) {
            System.out.println("initListCombos: " + e.getMessage());
        }
    }
}
