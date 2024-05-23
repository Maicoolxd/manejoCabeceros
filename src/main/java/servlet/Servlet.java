package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Struct;
import java.util.Enumeration;

//Anotacion en el cual vamos a colocar nuestra key para enlazar al servlet

@WebServlet ("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String metodo = req.getMethod();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Imprimiendo cabeceros</h1>");
        out.println("El metodo que se utilizo es"+metodo);
        out.println("<br>");
        String uri= req.getRequestURI();
        out.println("La uri es: "+uri);

        //Imprima todos los cabceceros que utiliza la apliacion
        Enumeration cabeceros= req.getHeaderNames();
        while(cabeceros.hasMoreElements())
        {
            String nombreCabeceros =(String) cabeceros.nextElement() ;
            out.println("<b>"+nombreCabeceros+"</b>");
            out.println(req.getHeader(nombreCabeceros));
            out.println("<br>");
        }
        out.println("</body>");
        out.println("</html>");

    }

}
