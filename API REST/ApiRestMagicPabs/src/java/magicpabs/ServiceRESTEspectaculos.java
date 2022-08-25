/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicpabs;

import clases.Espectaculos;
import clases.EspectaculosJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
@Path("espectaculos")
public class ServiceRESTEspectaculos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceRESTEspectaculos
     */
    public ServiceRESTEspectaculos() {
    }

    //Get All
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        EntityManagerFactory emf = null;
        Status statusResult = Response.Status.OK;
        List <Espectaculos> espectaculos = null;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EspectaculosJpaController dao = new EspectaculosJpaController(emf);
            espectaculos = dao.findEspectaculosEntities();
            if(espectaculos == null){
                statusResult = Response.Status.NO_CONTENT;
            }
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response
                    .status(statusResult)
                    .entity(espectaculos)
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
        Espectaculos espectaculo = null;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EspectaculosJpaController dao = new EspectaculosJpaController(emf);
            espectaculo = dao.findEspectaculos(id);
            if(espectaculo == null){
                statusResult = Response.Status.NO_CONTENT;
            }
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response
                    .status(statusResult)
                    .entity(espectaculo)
                    .build();
            return response;
        }
    }
    
    //Post de un espectaculo
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response post(Espectaculos espectaculo){
        EntityManagerFactory emf = null;
        Response.Status statusResult = Response.Status.CREATED;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EspectaculosJpaController dao = new EspectaculosJpaController(emf);
            dao.create(espectaculo);
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
    public Response put(Espectaculos espectaculo) {
        EntityManagerFactory emf = null;
        Status statusResul = Response.Status.OK;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            EspectaculosJpaController dao = new EspectaculosJpaController(emf);
            EspectaculosJpaController daoEspectaculos = new EspectaculosJpaController(emf);
            Espectaculos espectaculoFound = dao.findEspectaculos(espectaculo.getIdEspectaculo());            
            if (espectaculoFound == null) {
                statusResul = Response.Status.NOT_FOUND;
            } else {
                espectaculoFound.setDescripcion(espectaculo.getDescripcion());
                espectaculoFound.setDuracion(espectaculo.getDuracion());
                espectaculoFound.setTitulo(espectaculo.getTitulo());
                dao.edit(espectaculoFound);
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
