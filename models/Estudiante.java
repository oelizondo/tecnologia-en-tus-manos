package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estudiante{
    PreparedStatement stmt;

      public int tomarLecturas(int idLectura, Connection con){
        try{
            String query = "SELECT idLectura FROM Lectura WHERE idLectura = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idLectura);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { ///Va al primer registro si lo hay
               int idLect = rs.getInt ("idLectura");
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
             int idLectura = rs.getInt ("idLectura");
             rs.close();
             return(idLectura);
           }
        } catch (SQLException e) {}
       return 0;
       }

     public String getPregunta(int idEjercicio, Connection con){
       try{
         String query = "SELECT pregunta FROM Ejercicio WHERE idEjercicio = ?";
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
        String query = "SELECT idEjercicio FROM Lectura WHERE idLectura = ?";
        stmt = con.prepareStatement(query);
        stmt.setInt(1, idLectura);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { ///Va al primer registro si lo hay
         int nIdEjercicio = rs.getInt ("idEjercicio");
         rs.close();
         return(getPregunta(nIdEjercicio, con));
          }
        } catch (SQLException e) {}
        return "";
      }

    public int compartirAvances(int idAlumno, Connection con){
      try{
        String query = "SELECT COUNT(*) FROM calificacion WHERE idEstudiante = ? AND calificacion = 100";
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
         String query = "INSERT INTO Estudiante (idAdministrador, nombre, telefono, mail, password) VALUES (?, ?, ?, ?, ?)";
         stmt = con.prepareStatement(query);
         stmt.setInt(1, 1);
         stmt.setString(2, nombre);
         stmt.setString(3, telefono);
         stmt.setString(4, mail);
         stmt.setString(5, password);
         stmt.execute();
      }catch (Exception e) { System.out.println ("No se pudo ejecutar agregar() a la tabla Cliente" + e ); }
    }

    public int validar(String nombre, String password, Connection con) {
       try {
          String query = "SELECT * FROM Estudiante WHERE nombre = ? and password = ?";
          stmt = con.prepareStatement(query);
          stmt.setString(1, nombre);
          stmt.setString(2, password);

          ResultSet rs = stmt.executeQuery();
          if (rs.next()) { ///Va al primer registro si lo hay
             int ncuenta = rs.getInt ("ID");
             rs.close();
             return( ncuenta );
          }
       } catch (SQLException e) {}
       return 0;
    }

    public void agregar(String usuario, String paswd, int cuenta, String nombre, Connection con){
          try {
             String query = "INSERT INTO Estudiante (usuario, password, cuenta, nombre) VALUES (?, ?, ?, ?)";
             stmt = con.prepareStatement(query);
             stmt.setString(1, usuario);
             stmt.setString(2, paswd);
             stmt.setInt(3, cuenta);
             stmt.setString(4, nombre);
             stmt.execute();
          }catch (Exception e) { System.out.println ("No se pudo ejecutar agregar() a la tabla Cliente" + e ); }
       }
}
