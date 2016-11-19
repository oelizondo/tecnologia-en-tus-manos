package controllers;
import models.Lectura;
import java.sql.Connection;

public class ControlLectura {
  Lectura lectura;

   public ControlLectura(){
     lectura = new Lectura();
   }

   public String mostrarLecturas(Connection con) {
     return lectura.getLecturas(con);
   }

   public String mostrarLectura(int idLectura, Connection con){
     return lectura.getLectura(idLectura, con);
   }

   public String mostrarCapitulo(int idLectura, Connection con){
     return lectura.getCapitulo(1, con);
   }

}
