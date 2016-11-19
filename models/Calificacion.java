package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

  public class Calificacion{
    PreparedStatement stmt;
      public int getCalificacion(int idEstudiante, int idEjercicio, Connection con){
        try{
          String query = "SELECT calificacion FROM Calificacion WHERE IdEstudiante = ? AND IdEjercicio= ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idEstudiante);
          stmt.setInt(2, idEjercicio);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             int sCalificacion = rs.getInt ("calificacion");
             rs.close();
             return(sCalificacion);
           }
        } catch (SQLException e) {}
       return 0;
        }
  }
