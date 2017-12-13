/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.dao;

import com.mdevsol.app.rest.model.Cliente;
import com.mdevsol.app.rest.model.DetalleFactura;
import com.mdevsol.app.rest.model.Factura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author mdominguez
 */
@ApplicationScoped
public class FacturaDaoMock implements FacturaDao {
    @Override
    public List<Factura> listar(){
        Random r = new Random();
        
        Cliente c1 = new Cliente(999, "martin", "20-22333444-5");
        Cliente c2 = new Cliente(888, "maria", "27-58239693-8");
        Cliente c3 = new Cliente(777, "ana", "27-33456987-1");
        DetalleFactura df1 = new DetalleFactura(1, "producto 1", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df2 = new DetalleFactura(1, "producto 2", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df3 = new DetalleFactura(1, "producto 3", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df4 = new DetalleFactura(1, "producto 4", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df5 = new DetalleFactura(1, "producto 5", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df6 = new DetalleFactura(1, "producto 6", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df7 = new DetalleFactura(1, "producto 7", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df8 = new DetalleFactura(1, "producto 8", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df9 = new DetalleFactura(1, "producto 9", r.nextDouble()*1000, 1+r.nextInt(10));
        
        List<DetalleFactura> listaF1 = new ArrayList<>();        
        listaF1.add(df1);
        listaF1.add(df2);
        listaF1.add(df3);
        List<DetalleFactura> listaF2 = new ArrayList<>();
        listaF2.add(df4);
        listaF2.add(df5);
        List<DetalleFactura> listaF3 = new ArrayList<>();
        listaF3.add(df6);
        listaF3.add(df7);
        listaF3.add(df8);
        listaF3.add(df9);
        
        
        Factura f1 = new Factura(Integer.SIZE, new Date(), c1, listaF1);
        Factura f2 = new Factura(Integer.SIZE, new Date(), c1, listaF2);
        Factura f3 = new Factura(Integer.SIZE, new Date(), c1, listaF3);
        List<Factura> resultado = new ArrayList<>();
        resultado.add(f1);
        resultado.add(f2);
        resultado.add(f3);
        return resultado;
    }
    
    @Override
     public Factura buscarPorId(Integer id){
        Random r = new Random();
        
        Cliente c1 = new Cliente(999, "martin", "20-22333444-5");
        
        DetalleFactura df1 = new DetalleFactura(1, "producto 1", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df2 = new DetalleFactura(1, "producto 2", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df3 = new DetalleFactura(1, "producto 3", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df4 = new DetalleFactura(1, "producto 4", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df5 = new DetalleFactura(1, "producto 5", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df6 = new DetalleFactura(1, "producto 6", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df7 = new DetalleFactura(1, "producto 7", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df8 = new DetalleFactura(1, "producto 8", r.nextDouble()*1000, 1+r.nextInt(10));
        DetalleFactura df9 = new DetalleFactura(1, "producto 9", r.nextDouble()*1000, 1+r.nextInt(10));
        
        List<DetalleFactura> listaF1 = new ArrayList<>();        
        listaF1.add(df1);
        listaF1.add(df2);
        listaF1.add(df3);
        listaF1.add(df4);
        listaF1.add(df5);
        listaF1.add(df6);
        listaF1.add(df7);
        listaF1.add(df8);
        listaF1.add(df9); 
        
        Factura f1 = new Factura(Integer.SIZE, new Date(), c1, listaF1);
        return f1;
    }
}
