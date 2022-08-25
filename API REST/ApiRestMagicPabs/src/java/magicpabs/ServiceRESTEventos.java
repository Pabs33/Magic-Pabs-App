/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicpabs;

import clases.Espectaculos;
import clases.EspectaculosJpaController;
import clases.Eventos;
import clases.EventosJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * REST Web Service
 *
 * @author pablo
 */
@Path("eventos")
public class ServiceRESTEventos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceRESTEventos
     */
    public ServiceRESTEventos() {
    }

    //Get All
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        Status statusResult = Response.Status.OK;
        List <Eventos> eventos = null;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EventosJpaController dao = new EventosJpaController(emf);
            eventos = dao.findEventosEntities();
            if(eventos == null){
                statusResult = Response.Status.NO_CONTENT;
            }
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response
                    .status(statusResult)
                    .entity(eventos)
                    .build();
            return response;
        }
    }
    
    //Get One
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") int id){
        EntityManagerFactory emf = null;
        Status statusResult = Response.Status.OK;
        Eventos evento = null;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EventosJpaController dao = new EventosJpaController(emf);
            evento = dao.findEventos(id);
            if(evento == null){
                statusResult = Response.Status.NO_CONTENT;
            }
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response
                    .status(statusResult)
                    .entity(evento)
                    .build();
            return response;
        }
    }
    
    //Post de un evento
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response post(Eventos evento){
        EntityManagerFactory emf = null;
        Response.Status statusResult = Response.Status.CREATED;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EventosJpaController dao = new EventosJpaController(emf);
            dao.create(evento);
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response.status(statusResult).build();
            return response;
        }
    }
    
    //Put de un evento
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Eventos evento) {
        EntityManagerFactory emf = null;
        Status statusResul = Response.Status.OK;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EventosJpaController dao = new EventosJpaController(emf);
            EspectaculosJpaController daoEspectaculos = new EspectaculosJpaController(emf);
            Eventos eventoFound = dao.findEventos(evento.getIdEvento());            
            if (eventoFound == null) {
                statusResul = Response.Status.NOT_FOUND;
            } else {
                dao.edit(evento);
            }
        } catch (Exception ex) {
            statusResul = Response.Status.BAD_REQUEST;
        } finally {
            emf.close();
            Response response = Response
                    .status(statusResul)
                    .build();
            return response;
        }
    }
}
