package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lectura{
    PreparedStatement stmt;

      public String desplegarContenido(int idLectura, Connection con){
        try{
            String query = "SELECT * FROM Lectura WHERE idLectura = ?";
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
