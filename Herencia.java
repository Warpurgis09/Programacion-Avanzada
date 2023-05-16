

class persona {

    //atributos

    private String nombre;

    private String apellidos;

    private int edad;

 

    //constructor

    public persona (String nombre, String apellidos, int edad) {

        this.nombre = nombre;

        this.apellidos = apellidos;

        this.edad = edad;

    }

 

    //funciones

    public String getnombre() { return nombre; }

    public String getapellidos() { return apellidos; }

    public int getedad() { return edad; }

}

class profesor extends persona {

    //atributos propios de la subclase

    private String idprofesor;

 

    //constructor

    public profesor (String nombre, String apellidos, int edad) {

        super(nombre, apellidos, edad);

        idprofesor = "unknown";

    }

 

    //métodos propios de la subclase

    public void setidprofesor (String idprofesor) { this.idprofesor = idprofesor; }

 

    public String getidprofesor () { return idprofesor; }

 

    public String tostring() {

        return "" + getnombre() + " " + getapellidos() + " - " + getedad() + " - " + getidprofesor();

    }

}
public class Herencia{
  public static void main(String[] args){
    
  }
}
