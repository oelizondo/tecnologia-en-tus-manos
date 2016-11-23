package interfaces;

import java.io.PrintWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.ControlEstudiante;

@WebServlet(urlPatterns = "/Signup",
  initParams = {
     @WebInitParam(name = "class", value = "interfaces.DarEstudianteAltaServlet")
  }
)

public class DarEstudianteAltaServlet extends HttpServlet {
  ControlEstudiante estudiante = new ControlEstudiante();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
      PrintWriter out = response.getWriter();
      Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
      HttpSession session = request.getSession(false);

       String nombre = request.getParameter("nombre");
       String telefono = request.getParameter("telefono");
       String mail = request.getParameter("mail");
       String password = request.getParameter("password");
       ControlEstudiante cEstudiante = new ControlEstudiante();
       cEstudiante.crearEstudiante(nombre, telefono, mail, password, conn);
       response.setContentType("text/html");
       out.println("<h3>Se dio de alta al alumno exitosamente</h3>");
       RequestDispatcher rd = getServletContext().getRequestDispatcher("/index");
       rd.include(request, response);
   }

}
