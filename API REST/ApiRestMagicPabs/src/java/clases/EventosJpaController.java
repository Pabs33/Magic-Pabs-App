/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author pablo
 */
public class EventosJpaController implements Serializable {

    public EventosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Eventos eventos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes idClienteEventos = eventos.getIdClienteEventos();
            if (idClienteEventos != null) {
                idClienteEventos = em.getReference(idClienteEventos.getClass(), idClienteEventos.getIdCliente());
                eventos.setIdClienteEventos(idClienteEventos);
            }
            Espectaculos idEspectaculoEventos = eventos.getIdEspectaculoEventos();
            if (idEspectaculoEventos != null) {
                idEspectaculoEventos = em.getReference(idEspectaculoEventos.getClass(), idEspectaculoEventos.getIdEspectaculo());
                eventos.setIdEspectaculoEventos(idEspectaculoEventos);
            }
            em.persist(eventos);
            if (idClienteEventos != null) {
                idClienteEventos.getEventosCollection().add(eventos);
                idClienteEventos = em.merge(idClienteEventos);
            }
            if (idEspectaculoEventos != null) {
                idEspectaculoEventos.getEventosCollection().add(eventos);
                idEspectaculoEventos = em.merge(idEspectaculoEventos);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Eventos eventos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Eventos persistentEventos = em.find(Eventos.class, eventos.getIdEvento());
            Clientes idClienteEventosOld = persistentEventos.getIdClienteEventos();
            Clientes idClienteEventosNew = eventos.getIdClienteEventos();
            Espectaculos idEspectaculoEventosOld = persistentEventos.getIdEspectaculoEventos();
            Espectaculos idEspectaculoEventosNew = eventos.getIdEspectaculoEventos();
            if (idClienteEventosNew != null) {
                idClienteEventosNew = em.getReference(idClienteEventosNew.getClass(), idClienteEventosNew.getIdCliente());
                eventos.setIdClienteEventos(idClienteEventosNew);
            }
            if (idEspectaculoEventosNew != null) {
                idEspectaculoEventosNew = em.getReference(idEspectaculoEventosNew.getClass(), idEspectaculoEventosNew.getIdEspectaculo());
                eventos.setIdEspectaculoEventos(idEspectaculoEventosNew);
            }
            eventos = em.merge(eventos);
            if (idClienteEventosOld != null && !idClienteEventosOld.equals(idClienteEventosNew)) {
                idClienteEventosOld.getEventosCollection().remove(eventos);
                idClienteEventosOld = em.merge(idClienteEventosOld);
            }
            if (idClienteEventosNew != null && !idClienteEventosNew.equals(idClienteEventosOld)) {
                idClienteEventosNew.getEventosCollection().add(eventos);
                idClienteEventosNew = em.merge(idClienteEventosNew);
            }
            if (idEspectaculoEventosOld != null && !idEspectaculoEventosOld.equals(idEspectaculoEventosNew)) {
                idEspectaculoEventosOld.getEventosCollection().remove(eventos);
                idEspectaculoEventosOld = em.merge(idEspectaculoEventosOld);
            }
            if (idEspectaculoEventosNew != null && !idEspectaculoEventosNew.equals(idEspectaculoEventosOld)) {
                idEspectaculoEventosNew.getEventosCollection().add(eventos);
                idEspectaculoEventosNew = em.merge(idEspectaculoEventosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = eventos.getIdEvento();
                if (findEventos(id) == null) {
                    throw new NonexistentEntityException("The eventos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Eventos eventos;
            try {
                eventos = em.getReference(Eventos.class, id);
                eventos.getIdEvento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eventos with id " + id + " no longer exists.", enfe);
            }
            Clientes idClienteEventos = eventos.getIdClienteEventos();
            if (idClienteEventos != null) {
                idClienteEventos.getEventosCollection().remove(eventos);
                idClienteEventos = em.merge(idClienteEventos);
            }
            Espectaculos idEspectaculoEventos = eventos.getIdEspectaculoEventos();
            if (idEspectaculoEventos != null) {
                idEspectaculoEventos.getEventosCollection().remove(eventos);
                idEspectaculoEventos = em.merge(idEspectaculoEventos);
            }
            em.remove(eventos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Eventos> findEventosEntities() {
        return findEventosEntities(true, -1, -1);
    }

    public List<Eventos> findEventosEntities(int maxResults, int firstResult) {
        return findEventosEntities(false, maxResults, firstResult);
    }

    private List<Eventos> findEventosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Eventos.class));
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

    public Eventos findEventos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Eventos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEventosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Eventos> rt = cq.from(Eventos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
