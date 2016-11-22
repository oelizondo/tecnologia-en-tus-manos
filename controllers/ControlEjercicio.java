package controllers;
import models.Calificacion;
import models.Ejercicio;
import java.sql.Connection;

Public class ControlEjercicio{
  Ejercicio ejercicio;
  Calificacion calificacion;
  PreparedStatement stmt;

   public ControlLectura(){
     ejercicio = new Ejercicio();
     calificacion = new Calificacion();
   }

   public void controlRespuesta(int idEstudiante, String sRespuesta, int idEjercicio, Connection con){
      if(ejercicio.validarRespuesta(idEjercicio,sRespuesta,con)){
        calificacion.setCalificacion(idEstudiante,idEjercicio,100,con);
      }
      else{
        calificacion.setCalificacion(idEstudiante,idEjercicio,0,con);
      }
   }
}
