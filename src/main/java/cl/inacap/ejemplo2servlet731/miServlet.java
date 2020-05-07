package cl.inacap.ejemplo2servlet731;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "miServlet", urlPatterns = {"/app.do"})
public class miServlet extends HttpServlet {
//Reuerde no escribir código aquí
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1 Carpturar   2 Procesar   3 Compartir
        String bt=request.getParameter("enviar");
        switch (bt){
            case "login": 
                ejercicio1(request,response);
            break;
            case "calcular":
                ejercicio2(request,response);
        }
        
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

    protected void ejercicio1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1 Capturar
        String usuario = request.getParameter("txt1");
        String clave= request.getParameter("txt2");
        //2 Procesar
            //Validamos
            StringBuilder errores = new StringBuilder();
        if (usuario.isEmpty()) {
            errores.append("<li>Falta el usuario</li>");
        }
        if (clave.isEmpty()) {
            errores.append("<li>Falta la contraseña</li>");
        }
        //Preguntamos si existen errores
        if (errores.toString().isEmpty()) {
            if (usuario.equals("admin") && clave.equals("123")) {
                request.setAttribute("success", "Usuario Correcto");
                request.setAttribute("success2","Bienvenido!");
            }else{
                request.setAttribute("errores", "Usuario incorrecto");
            }
        }else{
            request.setAttribute("errores", errores);
        }
        //3 Compartir
        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    }

    protected void ejercicio2(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1 Capturar
        String precioTxt = request.getParameter("precio");
        String descuento = request.getParameter("descuento");
        int precio=0;
        double precDesc=0,valorDesc=0,total=0;
        // 2 Procesar
        //Valida
        StringBuilder errores = new StringBuilder();
        if (precioTxt.isEmpty()) {
            errores.append("<li>Falta el Precio</li>");
        }
        if (descuento.isEmpty()) {
            errores.append("<li>Seleccione el descuento</li>");
        }
        try {
              precio=Integer.parseInt(precioTxt);
              if (precio<0) {
                errores.append("<li>El precio debe ser un valor positivo</li>");
            }
        } catch (Exception e) {
            errores.append("<li>El precio debe ser un valor numérico</li>");
        }
        
        if (errores.toString().isEmpty()) {
            precDesc=Double.parseDouble(descuento);
            valorDesc=precio*precDesc;
            total = precio-valorDesc;
            StringBuilder success = new StringBuilder();
            success.append("<li>Precio: $"+(int)precio+"</li>");
            success.append("<li>Descuento: $"+(int)valorDesc+"</li>");
            success.append("<li>A pagar: $"+(int)total+"</li>");
            request.setAttribute("success", success);
        }else{
            request.setAttribute("errores", errores);
        }
        
        // 3 Compartir
        request.getRequestDispatcher("descuento.jsp").forward(request, response);
    }
}
