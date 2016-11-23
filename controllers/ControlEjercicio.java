package controllers;
import java.sql.Connection;
import models.Ejercicio;
import models.Calificacion;

public class ControlEjercicio{
  Ejercicio ejercicio;
  Calificacion calificacion;

   public ControlEjercicio(){
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
