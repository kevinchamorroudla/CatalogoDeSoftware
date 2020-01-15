/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.controlador;

import ec.com.catalogo.controlador.exceptions.IllegalOrphanException;
import ec.com.catalogo.controlador.exceptions.NonexistentEntityException;
import ec.com.catalogo.controlador.exceptions.PreexistingEntityException;
import ec.com.catalogo.controlador.exceptions.RollbackFailureException;
import ec.com.catalogo.modelo.Ambito;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import ec.com.catalogo.modelo.Software;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author carlosballadares
 */
public class AmbitoJpaController implements Serializable {

    public AmbitoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ambito ambito) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (ambito.getSoftwareList() == null) {
            ambito.setSoftwareList(new ArrayList<Software>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Software> attachedSoftwareList = new ArrayList<Software>();
            for (Software softwareListSoftwareToAttach : ambito.getSoftwareList()) {
                softwareListSoftwareToAttach = em.getReference(softwareListSoftwareToAttach.getClass(), softwareListSoftwareToAttach.getIdSoftware());
                attachedSoftwareList.add(softwareListSoftwareToAttach);
            }
            ambito.setSoftwareList(attachedSoftwareList);
            em.persist(ambito);
            for (Software softwareListSoftware : ambito.getSoftwareList()) {
                Ambito oldIdAmbitoOfSoftwareListSoftware = softwareListSoftware.getIdAmbito();
                softwareListSoftware.setIdAmbito(ambito);
                softwareListSoftware = em.merge(softwareListSoftware);
                if (oldIdAmbitoOfSoftwareListSoftware != null) {
                    oldIdAmbitoOfSoftwareListSoftware.getSoftwareList().remove(softwareListSoftware);
                    oldIdAmbitoOfSoftwareListSoftware = em.merge(oldIdAmbitoOfSoftwareListSoftware);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findAmbito(ambito.getIdAmbito()) != null) {
                throw new PreexistingEntityException("Ambito " + ambito + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ambito ambito) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Ambito persistentAmbito = em.find(Ambito.class, ambito.getIdAmbito());
            List<Software> softwareListOld = persistentAmbito.getSoftwareList();
            List<Software> softwareListNew = ambito.getSoftwareList();
            List<String> illegalOrphanMessages = null;
            for (Software softwareListOldSoftware : softwareListOld) {
                if (!softwareListNew.contains(softwareListOldSoftware)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Software " + softwareListOldSoftware + " since its idAmbito field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Software> attachedSoftwareListNew = new ArrayList<Software>();
            for (Software softwareListNewSoftwareToAttach : softwareListNew) {
                softwareListNewSoftwareToAttach = em.getReference(softwareListNewSoftwareToAttach.getClass(), softwareListNewSoftwareToAttach.getIdSoftware());
                attachedSoftwareListNew.add(softwareListNewSoftwareToAttach);
            }
            softwareListNew = attachedSoftwareListNew;
            ambito.setSoftwareList(softwareListNew);
            ambito = em.merge(ambito);
            for (Software softwareListNewSoftware : softwareListNew) {
                if (!softwareListOld.contains(softwareListNewSoftware)) {
                    Ambito oldIdAmbitoOfSoftwareListNewSoftware = softwareListNewSoftware.getIdAmbito();
                    softwareListNewSoftware.setIdAmbito(ambito);
                    softwareListNewSoftware = em.merge(softwareListNewSoftware);
                    if (oldIdAmbitoOfSoftwareListNewSoftware != null && !oldIdAmbitoOfSoftwareListNewSoftware.equals(ambito)) {
                        oldIdAmbitoOfSoftwareListNewSoftware.getSoftwareList().remove(softwareListNewSoftware);
                        oldIdAmbitoOfSoftwareListNewSoftware = em.merge(oldIdAmbitoOfSoftwareListNewSoftware);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ambito.getIdAmbito();
                if (findAmbito(id) == null) {
                    throw new NonexistentEntityException("The ambito with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Ambito ambito;
            try {
                ambito = em.getReference(Ambito.class, id);
                ambito.getIdAmbito();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ambito with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Software> softwareListOrphanCheck = ambito.getSoftwareList();
            for (Software softwareListOrphanCheckSoftware : softwareListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ambito (" + ambito + ") cannot be destroyed since the Software " + softwareListOrphanCheckSoftware + " in its softwareList field has a non-nullable idAmbito field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ambito);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ambito> findAmbitoEntities() {
        return findAmbitoEntities(true, -1, -1);
    }

    public List<Ambito> findAmbitoEntities(int maxResults, int firstResult) {
        return findAmbitoEntities(false, maxResults, firstResult);
    }

    private List<Ambito> findAmbitoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ambito.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ambito findAmbito(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ambito.class, id);
        } finally {
            em.close();
        }
    }

    public int getAmbitoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ambito> rt = cq.from(Ambito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
