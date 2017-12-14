/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.rest.model;

/**
 *
 * @author mdominguez
 */
public class Cliente {
    private Integer id;
    private String nombre;
    private String cuit;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, String cuit) {
        this.id = id;
        this.nombre = nombre;
        this.cuit = cuit;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
     
}
