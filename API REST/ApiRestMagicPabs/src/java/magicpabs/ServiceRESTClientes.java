/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicpabs;

import clases.Clientes;
import clases.ClientesJpaController;
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
@Path("clientes")
public class ServiceRESTClientes {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiceRESTClientes
     */
    public ServiceRESTClientes() {
    }

    //Get one
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne() {
        EntityManagerFactory emf = null;
        Response.Status statusResult = Response.Status.OK;
        List <Clientes> clientes = null;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            ClientesJpaController dao = new ClientesJpaController(emf);
            clientes = dao.findClientesEntities();
            if(clientes == null){
                statusResult = Response.Status.NO_CONTENT;
            }
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response
                    .status(statusResult)
                    .entity(clientes)
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
        Response.Status statusResult = Response.Status.OK;
        Clientes cliente = null;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            ClientesJpaController dao = new ClientesJpaController(emf);
            cliente = dao.findClientes(id);
            if(cliente == null){
                statusResult = Response.Status.NO_CONTENT;
            }
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response
                    .status(statusResult)
                    .entity(cliente)
                    .build();
            return response;
        }
    }
    
    
    //Post de un cliente
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response post(Clientes cliente){
        EntityManagerFactory emf = null;
        Status statusResult = Response.Status.CREATED;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            ClientesJpaController dao = new ClientesJpaController(emf);
            dao.create(cliente);
        } catch (Exception e) {
            statusResult = Response.Status.BAD_REQUEST;
        }finally{
            emf.close();
            Response response = Response.status(statusResult).build();
            return response;
        }
    }
    
    //Put de un cliente
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Clientes cliente) {
        EntityManagerFactory emf = null;
        Status statusResul = Response.Status.OK;
        try {
            emf = Persistence.createEntityManagerFactory("ApiRestMagicPabsPU");
            ClientesJpaController dao = new ClientesJpaController(emf);
            Clientes clienteFound = dao.findClientes(cliente.getIdCliente());            
            if (clienteFound == null) {
                statusResul = Response.Status.NOT_FOUND;
            } else {
                clienteFound.setEmail(cliente.getEmail());
                clienteFound.setNombre(cliente.getNombre());
                clienteFound.setTelefono(cliente.getTelefono());
                dao.edit(clienteFound);
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
