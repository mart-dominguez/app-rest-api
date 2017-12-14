/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdevsol.app.dao.FacturaDao;
import com.mdevsol.app.dao.FacturaDaoMock;
import com.mdevsol.app.rest.model.Factura;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mdominguez
 */
public class MainApp {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FacturaDao fd = new FacturaDaoMock();
            Factura f = fd.buscarPorId(1);
            StringWriter sw = new StringWriter();
            mapper.writeValue(sw, f);
            System.out.println(sw.toString());
            
            StringReader sr = new StringReader(sw.toString());

            Factura f2 = mapper.readValue(sr, Factura.class);
            
            System.out.println("F2 to string :"+f2.toString());
            System.out.println("F equals F2:"+f.getId()+" : "+f2.getId());
            
            
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
