package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Administrador{
    PreparedStatement stmt;


    public String getNombre(int idAdministrador, Connection con){
      try{
          String query = "SELECT nombre FROM Administrador WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idAdministrador);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             String sNombre = rs.getString ("nombre");
             rs.close();
             return(sNombre);
           }
        } catch (SQLException e) {}
       return "";
    }

    public String getTelefono(int idAdministrador, Connection con){
      try{
          String query = "SELECT telefono FROM Administrador WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idAdministrador);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             String sTelefono = rs.getString ("telefono");
             rs.close();
             return(sTelefono);
           }
        } catch (SQLException e) {}
       return "";
    }

    public String getMail(int idAdministrador, Connection con){
      try{
          String query = "SELECT mail FROM Administrador WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setInt(1, idAdministrador);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             String sMail = rs.getString ("mail");
             rs.close();
             return(sMail);
           }
        } catch (SQLException e) {}
       return "";
    }

    public void setNombre(int idAdministrador, String sNombre, Connection con){
      try{
          String query = "UPDATE Administrador SET nombre = ?  WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setString(1, sNombre);
          stmt.setInt(2, idAdministrador);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             rs.close();
           }
        } catch (SQLException e) {}
    }

    public void setTelefono(int idAdministrador, String sTelefono, Connection con){
      try{
          String query = "UPDATE Administrador SET telefono = ?  WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setString(1, sTelefono);
          stmt.setInt(2, idAdministrador);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             rs.close();
           }
        } catch (SQLException e) {}
    }

    public void setMail(int idAdministrador, String sMail, Connection con){
      try{
          String query = "UPDATE Administrador SET mail = ?  WHERE Id = ?";
          stmt = con.prepareStatement(query);
          stmt.setString(1, sMail);
          stmt.setInt(2, idAdministrador);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             rs.close();
           }
        } catch (SQLException e) {}
    }

    public Boolean darAlumnoDeBaja(int idEstudiante,Connection con){
      try{

        String query = "DELETE FROM Estudiante WHERE Id = ?;";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,idEstudiante);
        stmt.executeQuery();

      } catch (SQLException e) {return false;}
       return true;
    }

    public Boolean modificarLectura(int idLectura,Connection con){
      try{

        String query = "SELECT FROM Lectura WHERE Id = ?;";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,idLectura);
        stmt.executeQuery();

      } catch (SQLException e) {return false;}
       return true;
    }

    public Boolean modificarEjercico(int idEjercicio,Connection con){
      try{

        String query = "SELECT FROM Ejercicio WHERE Id = ?;";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,idEjercicio);
        stmt.executeQuery();

      } catch (SQLException e) {return false;}
       return true;
    }

    public int checarAvanceDeAlumno(int idEstudiante, Connection con){
      try{
        String query = "SELECT COUNT(*) FROM calificacion WHERE Id = ? AND calificacion = 100";
        stmt = con.prepareStatement(query);
        stmt.setInt(1,idEstudiante);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { ///Va al primer registro si lo hay
         int iCount = rs.getInt ("COUNT(*)");
         rs.close();
         return(iCount);
          }
        } catch (SQLException e) {}
        return 0;
      }



}
