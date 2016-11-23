package controllers;
import java.sql.Connection;
import models.Estudiante;

public class ControlLogin {
   Estudiante estudiante;
   public ControlLogin(){
     estudiante = new Estudiante();
   }

   public void agregarEstudiante (String usuario, String paswd, String cuenta, String nombre, Connection con){
      estudiante.darseAlta(usuario, paswd, cuenta, nombre, con);
   }

   ///Valida al estudiante en la base de datos
   public int validarEstudiante(String usuario, String password, Connection con){
      int ncuenta = estudiante.validar(usuario, password, con);
      return( ncuenta );
   }


}
