/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.dao;

import com.mdevsol.app.rest.model.Factura;
import java.util.List;

/**
 *
 * @author mdominguez
 */
public interface FacturaDao {

    Factura buscarPorId(Integer id);

    List<Factura> listar();
    
}
