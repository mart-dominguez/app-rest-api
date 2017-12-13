/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.rest.model;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mdominguez
 */
@XmlRootElement(name = "ventas")
public class Factura {
    private Integer id;
    private Date fecha;
    private Cliente cliente;
    private List<DetalleFactura> detalle;

    public Factura() {
    }
    
    

    public Factura(Integer id, Date fecha, Cliente cliente, List<DetalleFactura> detalle) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalle = detalle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }
    
    
    
}
