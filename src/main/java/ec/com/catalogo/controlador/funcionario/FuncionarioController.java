package ec.com.catalogo.controlador.funcionario;

import ec.com.catalogo.viewmodel.FuncionarioViewModel;
import java.util.List;
import java.util.stream.Collectors;
import ec.com.cataloglo.servicio.FuncionarioFacadeLocal;
import ec.com.cataloglo.servicio.PersonaFacadeLocal;
import ec.com.catalogo.modelo.AreaFuncional;
import ec.com.catalogo.modelo.Persona;
import ec.com.catalogo.modelo.Funcionario;
//import com.udla.rfc.model.FuncionarioPK;

import ec.com.catalogo.modelo.Funcionario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@FacesConfig(
        // Activates CDI build-in beans
        version = JSF_2_3
)

@Named
@ViewScoped
public class FuncionarioController implements Serializable{
    
    private static final long serialVersionUID = 1L;
   
    @EJB
    private PersonaFacadeLocal personaEJB;
    @EJB
    private FuncionarioFacadeLocal funcionarioEJB;
    
    private Persona persona;
    private Funcionario funcionario;
    private AreaFuncional area;
    private List<FuncionarioViewModel> funcionarios;
    List<Funcionario> f;
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public List<FuncionarioViewModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioViewModel> funcionarios) {
        this.funcionarios = funcionarios;
    }
    @PostConstruct
    public void init() {
        getAllFuncionarios();
        persona = new Persona();
        area = new AreaFuncional();
        area.setNombre("Tecnologia");
        funcionario = new Funcionario();
    }
    
    
    public void getAllFuncionarios(){
        try {
            List<Funcionario> lFuncionarios = funcionarioEJB.findAll();
            this.funcionarios = lFuncionarios.stream().map(x -> new FuncionarioViewModel(
                    x.getIdPersona().getCedula(), x.getIdPersona().getNombre(), x.getIdAreaFuncional().getNombre()
            )).collect(Collectors.toList());
        } catch (Exception e) {
        }
    }
    
    public String nuevoFuncionario(){
        String redireccion = null;
        try {
            personaEJB.create(persona);
            Persona personaFunc = personaEJB.find(persona.getIdPersona());
//            funcionario.setIdPersona(persona);
            funcionario.setIdAreaFuncional(area);
            funcionario.setIdPersona(personaFunc);
            funcionarioEJB.create(funcionario);
            getAllFuncionarios();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro exitoso"));
            redireccion = "funcionario";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        
        return redireccion;
    }
}
