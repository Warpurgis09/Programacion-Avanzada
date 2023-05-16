import java.util.Calendar;
import java.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FormatoTiempo{


  public static void main(String args[]){
    //Formato fecha:
    Formatter fecha = new Formatter();
    Calendar cal = Calendar.getInstance();
    fecha.format("%tB,%tb,%tm", cal, cal, cal);//Formato hora
    Date hora = new Date();
    String strFormatHora = "HH:mm:ss a";
    SimpleDateFormat forma= new SimpleDateFormat(strFormatHora);//Se imprime
    System.out.print("Presentación 1 de fecha y hora: ");
    System.out.println(fecha + " "+ forma.format(hora) + "\n");

    //Otra forma
    fecha.format("%tc", cal);
    System.out.print("Presentación 2 de Fecha y Hora:  ");
    System.out.println(fecha + "\n");

    //Otra forma
    Date d = new Date();
    System.out.print("Presentación 3 de Fecha y Hora:  ");
    System.out.println(d.toString());
    
  }
}