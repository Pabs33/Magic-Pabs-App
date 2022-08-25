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
public class EspectaculosJpaController implements Serializable {

    public EspectaculosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Espectaculos espectaculos) {
        if (espectaculos.getEventosCollection() == null) {
            espectaculos.setEventosCollection(new ArrayList<Eventos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Eventos> attachedEventosCollection = new ArrayList<Eventos>();
            for (Eventos eventosCollectionEventosToAttach : espectaculos.getEventosCollection()) {
                eventosCollectionEventosToAttach = em.getReference(eventosCollectionEventosToAttach.getClass(), eventosCollectionEventosToAttach.getIdEvento());
                attachedEventosCollection.add(eventosCollectionEventosToAttach);
            }
            espectaculos.setEventosCollection(attachedEventosCollection);
            em.persist(espectaculos);
            for (Eventos eventosCollectionEventos : espectaculos.getEventosCollection()) {
                Espectaculos oldIdEspectaculoEventosOfEventosCollectionEventos = eventosCollectionEventos.getIdEspectaculoEventos();
                eventosCollectionEventos.setIdEspectaculoEventos(espectaculos);
                eventosCollectionEventos = em.merge(eventosCollectionEventos);
                if (oldIdEspectaculoEventosOfEventosCollectionEventos != null) {
                    oldIdEspectaculoEventosOfEventosCollectionEventos.getEventosCollection().remove(eventosCollectionEventos);
                    oldIdEspectaculoEventosOfEventosCollectionEventos = em.merge(oldIdEspectaculoEventosOfEventosCollectionEventos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Espectaculos espectaculos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Espectaculos persistentEspectaculos = em.find(Espectaculos.class, espectaculos.getIdEspectaculo());
            Collection<Eventos> eventosCollectionOld = persistentEspectaculos.getEventosCollection();
            Collection<Eventos> eventosCollectionNew = espectaculos.getEventosCollection();
            Collection<Eventos> attachedEventosCollectionNew = new ArrayList<Eventos>();
            for (Eventos eventosCollectionNewEventosToAttach : eventosCollectionNew) {
                eventosCollectionNewEventosToAttach = em.getReference(eventosCollectionNewEventosToAttach.getClass(), eventosCollectionNewEventosToAttach.getIdEvento());
                attachedEventosCollectionNew.add(eventosCollectionNewEventosToAttach);
            }
            eventosCollectionNew = attachedEventosCollectionNew;
            espectaculos.setEventosCollection(eventosCollectionNew);
            espectaculos = em.merge(espectaculos);
            for (Eventos eventosCollectionOldEventos : eventosCollectionOld) {
                if (!eventosCollectionNew.contains(eventosCollectionOldEventos)) {
                    eventosCollectionOldEventos.setIdEspectaculoEventos(null);
                    eventosCollectionOldEventos = em.merge(eventosCollectionOldEventos);
                }
            }
            for (Eventos eventosCollectionNewEventos : eventosCollectionNew) {
                if (!eventosCollectionOld.contains(eventosCollectionNewEventos)) {
                    Espectaculos oldIdEspectaculoEventosOfEventosCollectionNewEventos = eventosCollectionNewEventos.getIdEspectaculoEventos();
                    eventosCollectionNewEventos.setIdEspectaculoEventos(espectaculos);
                    eventosCollectionNewEventos = em.merge(eventosCollectionNewEventos);
                    if (oldIdEspectaculoEventosOfEventosCollectionNewEventos != null && !oldIdEspectaculoEventosOfEventosCollectionNewEventos.equals(espectaculos)) {
                        oldIdEspectaculoEventosOfEventosCollectionNewEventos.getEventosCollection().remove(eventosCollectionNewEventos);
                        oldIdEspectaculoEventosOfEventosCollectionNewEventos = em.merge(oldIdEspectaculoEventosOfEventosCollectionNewEventos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = espectaculos.getIdEspectaculo();
                if (findEspectaculos(id) == null) {
                    throw new NonexistentEntityException("The espectaculos with id " + id + " no longer exists.");
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
            Espectaculos espectaculos;
            try {
                espectaculos = em.getReference(Espectaculos.class, id);
                espectaculos.getIdEspectaculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The espectaculos with id " + id + " no longer exists.", enfe);
            }
            Collection<Eventos> eventosCollection = espectaculos.getEventosCollection();
            for (Eventos eventosCollectionEventos : eventosCollection) {
                eventosCollectionEventos.setIdEspectaculoEventos(null);
                eventosCollectionEventos = em.merge(eventosCollectionEventos);
            }
            em.remove(espectaculos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Espectaculos> findEspectaculosEntities() {
        return findEspectaculosEntities(true, -1, -1);
    }

    public List<Espectaculos> findEspectaculosEntities(int maxResults, int firstResult) {
        return findEspectaculosEntities(false, maxResults, firstResult);
    }

    private List<Espectaculos> findEspectaculosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Espectaculos.class));
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

    public Espectaculos findEspectaculos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Espectaculos.class, id);
        } finally {
            em.close();
        }
    }

    public int getEspectaculosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Espectaculos> rt = cq.from(Espectaculos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
