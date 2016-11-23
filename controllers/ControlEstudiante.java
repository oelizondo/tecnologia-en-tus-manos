package controllers;
import java.sql.Connection;
import models.Estudiante;

public class ControlEstudiante {
   Estudiante estudiante;

   public ControlEstudiante(){
     estudiante = new Estudiante();
   }

   public void crearEstudiante(String nombre, String telefono, String mail, String password, Connection con) {
     estudiante.darseAlta(nombre, telefono, mail, password, con);
   }
}
