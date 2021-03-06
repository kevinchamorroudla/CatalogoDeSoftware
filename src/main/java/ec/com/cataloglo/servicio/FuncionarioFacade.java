/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.cataloglo.servicio;

import ec.com.catalogo.modelo.Funcionario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Kevin
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
