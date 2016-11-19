package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio{
    PreparedStatement stmt;

    public String getPregunta(int idEjercicio, Connection con){
      try{
          String query = "SELECT pregunta FROM Ejercicio WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idEjercicio);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             String sPregunta = rs.getString ("pregunta");
             rs.close();
             return(sPregunta);
           }
        } catch (SQLException e) {}
       return "";
    }

    public String getRespuesta(int idEjercicio, Connection con){
      try{
          String query = "SELECT respuesta FROM Ejercicio WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idEjercicio);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             String sRespuesta = rs.getString ("respuesta");
             rs.close();
             return(sRespuesta);
           }
        } catch (SQLException e) {}
       return "";
    }
}
