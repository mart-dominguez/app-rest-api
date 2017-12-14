/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.rest;

import com.mdevsol.app.dao.FacturaDao;
import com.mdevsol.app.rest.model.Factura;
import java.util.List;
import javax.inject.Inject;
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

/**
 * REST Web Service
 *
 * @author mdominguez
 */
@Path("factura")
public class FacturaResource {

    @Inject FacturaDao facturaDao; 
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FacturaResource
     */
    public FacturaResource() {
    }

    /**
     * Retrieves representation of an instance of com.mdevsol.app.rest.FacturaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Factura>  getXml() {
        return facturaDao.listar();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Factura>  getJsonLista() {
        return facturaDao.listar();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")    
    public Factura  getJson(@PathParam("id") Integer id) {
        return facturaDao.buscarPorId(1);
    }

        /**
     * Retrieves representation of an instance of com.mdevsol.app.rest.FacturaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Factura getXmlId(@PathParam("id") Integer id) {
        return facturaDao.buscarPorId(1);
    }
    
    
    
    /**
     * PUT method for updating or creating an instance of FacturaResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void putXml(Factura content) {
        System.out.println(content);
    }
    
    
        /**
     * PUT method for updating or creating an instance of FacturaResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void putTexto(String texto) {
        System.out.println(texto);
    }
}
