/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import clases.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author pablo
 */
public class ClientesJpaController implements Serializable {

    public ClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes clientes) {
        if (clientes.getEventosCollection() == null) {
            clientes.setEventosCollection(new ArrayList<Eventos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Eventos> attachedEventosCollection = new ArrayList<Eventos>();
            for (Eventos eventosCollectionEventosToAttach : clientes.getEventosCollection()) {
                eventosCollectionEventosToAttach = em.getReference(eventosCollectionEventosToAttach.getClass(), eventosCollectionEventosToAttach.getIdEvento());
                attachedEventosCollection.add(eventosCollectionEventosToAttach);
            }
            clientes.setEventosCollection(attachedEventosCollection);
            em.persist(clientes);
            for (Eventos eventosCollectionEventos : clientes.getEventosCollection()) {
                Clientes oldIdClienteEventosOfEventosCollectionEventos = eventosCollectionEventos.getIdClienteEventos();
                eventosCollectionEventos.setIdClienteEventos(clientes);
                eventosCollectionEventos = em.merge(eventosCollectionEventos);
                if (oldIdClienteEventosOfEventosCollectionEventos != null) {
                    oldIdClienteEventosOfEventosCollectionEventos.getEventosCollection().remove(eventosCollectionEventos);
                    oldIdClienteEventosOfEventosCollectionEventos = em.merge(oldIdClienteEventosOfEventosCollectionEventos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientes clientes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes persistentClientes = em.find(Clientes.class, clientes.getIdCliente());
            Collection<Eventos> eventosCollectionOld = persistentClientes.getEventosCollection();
            Collection<Eventos> eventosCollectionNew = clientes.getEventosCollection();
            Collection<Eventos> attachedEventosCollectionNew = new ArrayList<Eventos>();
            for (Eventos eventosCollectionNewEventosToAttach : eventosCollectionNew) {
                eventosCollectionNewEventosToAttach = em.getReference(eventosCollectionNewEventosToAttach.getClass(), eventosCollectionNewEventosToAttach.getIdEvento());
                attachedEventosCollectionNew.add(eventosCollectionNewEventosToAttach);
            }
            eventosCollectionNew = attachedEventosCollectionNew;
            clientes.setEventosCollection(eventosCollectionNew);
            clientes = em.merge(clientes);
            for (Eventos eventosCollectionOldEventos : eventosCollectionOld) {
                if (!eventosCollectionNew.contains(eventosCollectionOldEventos)) {
                    eventosCollectionOldEventos.setIdClienteEventos(null);
                    eventosCollectionOldEventos = em.merge(eventosCollectionOldEventos);
                }
            }
            for (Eventos eventosCollectionNewEventos : eventosCollectionNew) {
                if (!eventosCollectionOld.contains(eventosCollectionNewEventos)) {
                    Clientes oldIdClienteEventosOfEventosCollectionNewEventos = eventosCollectionNewEventos.getIdClienteEventos();
                    eventosCollectionNewEventos.setIdClienteEventos(clientes);
                    eventosCollectionNewEventos = em.merge(eventosCollectionNewEventos);
                    if (oldIdClienteEventosOfEventosCollectionNewEventos != null && !oldIdClienteEventosOfEventosCollectionNewEventos.equals(clientes)) {
                        oldIdClienteEventosOfEventosCollectionNewEventos.getEventosCollection().remove(eventosCollectionNewEventos);
                        oldIdClienteEventosOfEventosCollectionNewEventos = em.merge(oldIdClienteEventosOfEventosCollectionNewEventos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = clientes.getIdCliente();
                if (findClientes(id) == null) {
                    throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
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
            Clientes clientes;
            try {
                clientes = em.getReference(Clientes.class, id);
                clientes.getIdCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.", enfe);
            }
            Collection<Eventos> eventosCollection = clientes.getEventosCollection();
            for (Eventos eventosCollectionEventos : eventosCollection) {
                eventosCollectionEventos.setIdClienteEventos(null);
                eventosCollectionEventos = em.merge(eventosCollectionEventos);
            }
            em.remove(clientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clientes> findClientesEntities() {
        return findClientesEntities(true, -1, -1);
    }

    public List<Clientes> findClientesEntities(int maxResults, int firstResult) {
        return findClientesEntities(false, maxResults, firstResult);
    }

    private List<Clientes> findClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clientes.class));
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

    public Clientes findClientes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clientes> rt = cq.from(Clientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
