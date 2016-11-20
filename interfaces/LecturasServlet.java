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
     PrintWriter out = response.getWriter();
     Connection conn = (Connection) getServletContext().getAttribute("DBConnection");
     HttpSession sesion = request.getSession(false);
     PreparedStatement stmt;

    try {
      String query = "SELECT * from Lectura";
      stmt = conn.prepareStatement(query);
      ResultSet rs = stmt.executeQuery();
      out.println("<html><head><link rel='stylesheet' href='public/css/vendor/normalize.css'><link rel='stylesheet' href='public/css/vendor/skeleton.css'><link rel='stylesheet' href='public/css/style.css'></head><body>");
      out.println("<div class='container center'>");
      while(rs.next()) {
        out.println("<div class='row center'>");
        out.println("<h3> " + rs.getString("capitulo") + " </h3>");
        out.println("<h4> " + rs.getString("seccion") + " </h4>");
        out.println("<p> " + rs.getString("contenido") + " </p>");
        out.println("</div>");
      }
      out.println("</div>");
      out.println("</body></html>");
    }
    catch (SQLException e) {}

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html");
  }

}
