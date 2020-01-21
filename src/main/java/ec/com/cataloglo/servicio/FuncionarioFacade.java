/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.AreaFuncional;
import ec.com.catalogo.modelo.Funcionario;
import ec.com.catalogo.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import ec.com.catalogo.viewmodel.FuncionarioViewModel;
import javax.persistence.Query;

/**
 *
 * @author carlosballadares
 */
@Stateless
public class FuncionarioFacade extends AbstractFacade<Funcionario> implements FuncionarioFacadeLocal {

    @PersistenceContext(unitName = "catalogoSoftwarePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionarioFacade() {
        super(Funcionario.class);
    }
    
    @Override
    public List<FuncionarioViewModel> findAllFuncionarios() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        
        CriteriaQuery<FuncionarioViewModel> query  = builder.createQuery( FuncionarioViewModel.class );
        Root<Funcionario> from = query.from( Funcionario.class );
        
        Join<Funcionario, Persona> joinPersona = from.join("idPersona");
        Join<Funcionario, AreaFuncional> joinArea = from.join("idArea"); 
        
        query.multiselect(joinPersona.get("cedula"), joinPersona.get("nombre"), joinArea.get("nombre"));
        
        TypedQuery<FuncionarioViewModel> createQuery = getEntityManager().createQuery(query);       
        List<FuncionarioViewModel> resultList = createQuery.getResultList();
        return resultList;
    }
    
    
        
    @Override
    public Funcionario iniciarSesion(Funcionario usr) {
        Funcionario usuario = null;
        String consulta;
        try {
            consulta = "FROM Funcionario u WHERE u.nombreUsuario = ?1 and u.password = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usr.getNombreUsuario());
            query.setParameter(2, usr.getPassword());
            List<Funcionario> lista = query.getResultList(); 
            if (!lista.isEmpty()) {
                    usuario = lista.get(0);
            }
        } catch(Exception e) {
            throw e;
        }
        return usuario;
    }
}
