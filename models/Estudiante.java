package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estudiante{
    PreparedStatement stmt;

      public String getNombre(int idEstudiante, Connection con){
        try{
            String query = "SELECT nombre FROM Estudiante WHERE idEstudiante = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idEstudiante);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sNombre = rs.getString ("nombre");
               rs.close();
               return(sNombre);
             }
          } catch (SQLException e) {}
         return "";
      }

      public String getTelefono(int idEstudiante, Connection con){
        try{
            String query = "SELECT telefono FROM Estudiante WHERE idEstudiante = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idEstudiante);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sTelefono = rs.getString ("telefono");
               rs.close();
               return(sTelefono);
             }
          } catch (SQLException e) {}
         return "";
      }

      public String getMail(int idEstudiante, Connection con){
        try{
            String query = "SELECT mail FROM Estudiante WHERE idEstudiante = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idEstudiante);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               String sMail = rs.getString ("mail");
               rs.close();
               return(sMail);
             }
          } catch (SQLException e) {}
         return "";
      }

      public void setNombre(int idEstudiante, String sNombre, Connection con){
        try{
            String query = "UPDATE Estudiante SET nombre = ?  WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, sNombre);
            stmt.setInt(2, idEstudiante);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               rs.close();
             }
          } catch (SQLException e) {}
      }

      public void setTelefono(int idEstudiante, String sTelefono, Connection con){
        try{
            String query = "UPDATE Estudiante SET telefono = ?  WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, sTelefono);
            stmt.setInt(2, idEstudiante);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               rs.close();
             }
          } catch (SQLException e) {}
      }

      public void setMail(int idEstudiante, String sMail, Connection con){
        try{
            String query = "UPDATE Estudiante SET mail = ?  WHERE iD = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, sMail);
            stmt.setInt(2, idEstudiante);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               rs.close();
             }
          } catch (SQLException e) {}
      }


      public int tomarLecturas(int idLectura, Connection con){
        try{
            String query = "SELECT Id FROM Lectura WHERE Id = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idLectura);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               int idLect = rs.getInt ("Id");
               rs.close();
               return(idLect);
             }
          } catch (SQLException e) {}
         return 0;
      }

     public int verLecturas(Connection con){
       try{
          String query = "SELECT * FROM Lectura";
          stmt = con.prepareStatement(query);
          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             int idLectura = rs.getInt ("Id");
             rs.close();
             return(idLectura);
           }
        } catch (SQLException e) {}
       return 0;
       }

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


     public String getEjercicio(int idLectura, Connection con){
      try{
        String query = "SELECT Id FROM Lectura WHERE Id = ?";
        stmt = con.prepareStatement(query);
        stmt.setInt(1, idLectura);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { ///Va al primer registro si lo hay
         int nIdEjercicio = rs.getInt ("Id");
         rs.close();
         return(getPregunta(nIdEjercicio, con));
          }
        } catch (SQLException e) {}
        return "";
      }

    public int compartirAvances(int idAlumno, Connection con){
      try{
        String query = "SELECT COUNT(*) FROM calificacion WHERE Id = ? AND calificacion = 100";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,idAlumno);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { ///Va al primer registro si lo hay
         int iCount = rs.getInt ("COUNT(*)");
         rs.close();
         return(iCount);
          }
        } catch (SQLException e) {}
        return 0;
      }

    public void darseAlta(String nombre, String telefono, String mail, String password, Connection con){
      try {
         String query = "INSERT INTO alumno (IdAdministrador, nombre, telefono, mail, password) VALUES (?, ?, ?, ?, ?)";
         stmt = con.prepareStatement(query);
         stmt.setInt(1, 1);
         stmt.setString(2, nombre);
         stmt.setString(3, telefono);
         stmt.setString(4, mail);
         stmt.setString(5, password);
         stmt.execute();
      }catch (Exception e) { System.out.println ("No se pudo ejecutar agregar() a la tabla Alumno" + e ); }
    }
}
