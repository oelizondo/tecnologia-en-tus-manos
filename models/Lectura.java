package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lectura{
    PreparedStatement stmt;

      public String getCapitulo(int idLectura, Connection con){
        try{
            String query = "SELECT capitulo FROM Lectura WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idLectura);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sCapitulo = rs.getString ("capitulo");
               rs.close();
               return(sCapitulo);
             }
          } catch (SQLException e) {}
         return "";
      }

      public String getSeccion(int idLectura, Connection con){
        try{
            String query = "SELECT seccion FROM Lectura WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idLectura);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sSeccion = rs.getString ("seccion");
               rs.close();
               return(sSeccion);
             }
          } catch (SQLException e) {}
         return "";
      }

      public String getContenido(int idLectura, Connection con){
        try{
            String query = "SELECT contenido FROM Lectura WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idLectura);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sContenido = rs.getString ("contenido");
               rs.close();
               return(sContenido);
             }
          } catch (SQLException e) {}
         return "";
      }

      // sets los hace el administrador
      //

      public String desplegarContenido(int idLectura, Connection con){
        try{
            String query = "SELECT * FROM Lectura WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idLectura);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sContenido = rs.getString ("*");
               rs.close();
               return(sContenido);
             }
          } catch (SQLException e) {}
         return "";
      }

}
