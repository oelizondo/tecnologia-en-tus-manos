package interfaces;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import controllers.ControlLectura;

@WebServlet(urlPatterns = "/Lecturas",
  initParams = {
     @WebInitParam(name = "class", value = "interfaces.LecturasServlet")
  }
)

public class LecturasServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
     doPost(request,response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

     PrintWriter out = response.getWriter();
     Connection conn = (Connection) getServletContext().getAttribute("DBConnection");

     ControlLectura cl = new ControlLectura();
     String lecturas = cl.mostrarCapitulo(1, conn);

     //Solo permitir acceso si existe una sesion
     HttpSession sesion = request.getSession(false);
      //Mostrar el menu de opciones
    response.setContentType("text/html");
    out.println(
       "<!DOCTYPE html> \n" +
       "<html> \n" +
       "<head> \n" +
       "<meta charset=utf-8> \n" +
       "<link rel='stylesheet' href='public/css/vendor/normalize.css'> \n" +
       "<link rel='stylesheet' href='public/css/vendor/skeleton.css'> \n" +
       "<link rel='stylesheet' href='public/css/style.css'> \n" +
       "<title>Tecnologia en tus manos</title> \n" +
       "</head> \n" +
       "<body> \n" +
       "<div class='row navigaition'> <h1>" + lecturas + " </h1> </div>\n" +
       "</body> \n" +
       "</html>");
  }

}
