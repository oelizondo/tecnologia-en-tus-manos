package models;

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

    public Boolean validarRespuesta(int idEjercicio, String sRespuesta, Connection con){
      try{
          String query = "SELECT respuesta FROM Ejercicio WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idEjercicio);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             String sRes = rs.getString ("respuesta");

             if (sRes != sRespuesta) {
               return false;
             }
             rs.close();

           }
        } catch (SQLException e) {return false;}
       return true;
    }

    public int sacarCalificacion(int idEjercicio, Connection con){
      try{
          String query = "SELECT calificacion FROM Ejercicio WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idEjercicio);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             int iCal = rs.getInt ("calificacion");
             rs.close();
             return iCal;

           }
        } catch (SQLException e) {return 0;}
       return 0;
    }
}
