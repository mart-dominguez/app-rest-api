/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mdevsol.app.web;

import com.mdevsol.app.rest.model.Cliente;
import com.mdevsol.app.rest.model.Factura;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mdominguez
 */
@WebServlet(name = "JsonModelServlet", urlPatterns = {"/jsonModel"})
public class JsonModelServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JsonModelServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JsonModelServlet at " + request.getContextPath() + "</h1>");            
            
            out.println("<h2>Resultado</h2>");
            out.println("<div style=\"color:red\">");
            out.println(this.procesarJson());          
            out.println("</div>");
            
            JsonObject model = Json.createObjectBuilder()
   .add("firstName", "Duke")
   .add("lastName", "Java")
   .add("age", 18)
   .add("streetAddress", "100 Internet Dr")
   .add("city", "JavaTown")
   .add("state", "JA")
   .add("postalCode", "12345")
   .add("phoneNumbers", Json.createArrayBuilder()
      .add(Json.createObjectBuilder()
         .add("type", "mobile")
         .add("number", "111-111-1111"))
      .add(Json.createObjectBuilder()
         .add("type", "home")
         .add("number", "222-222-2222")))
   .build();
            
            out.println("<h2>Resultado Builder</h2>");
            out.println("<div style=\"color:blue\">");
            out.println(model.toString());
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private String procesarJson( ){
     
        Function<JsonObject,Cliente> functionJsonToCliente = (objJson) ->{
            Cliente c = new Cliente();
            c.setId(objJson.getInt("id"));
            c.setNombre(objJson.getString("nombre"));
            c.setCuit(objJson.getString("cuit"));
            return c;  
        };
        
        Function<JsonObject,Factura> functionJsonToFactura = (objJson) ->{
            Factura f = new Factura();
            f.setId(objJson.getInt("id"));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(objJson.getJsonNumber("fecha").longValue());
            f.setFecha(calendar.getTime());
            f.setCliente(functionJsonToCliente.apply(objJson.getJsonObject("cliente")));
            return f;  
        };
        
            StringBuilder sb = new StringBuilder();
            InputStream input = getServletContext().getResourceAsStream("/WEB-INF/datos/arreglo.json");

            JsonReader reader = Json.createReader(input);
            JsonValue jsonval = reader.read();
            if(jsonval.getValueType().equals(JsonValue.ValueType.ARRAY)){
                JsonArray jsonArray = (JsonArray) jsonval;
                for(JsonValue jv : jsonArray){
                    if(jv.getValueType().equals(JsonValue.ValueType.OBJECT)){
                        Factura f = functionJsonToFactura.apply((JsonObject) jv);
                        sb.append(f.toString());
                    }
                }
            }
            
            return sb.toString();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
