import java.text.SimpleDateFormat;
//Se importa la libreria util para poder hacer listas
import java.util.*;
//Se importa la libreria Date para utilizar fechas
import java.util.Date;

//Se declara la clase Compra para registrar compras realizadas
class Compra{
    /*Dentro de la clase compra, esta tiene como atributos objetos de las clases
    * Cliente y la clase Obra*/
    Date fecha;
    Cliente comprador;
    //Obra comprada;
    double precio;
    //Se instancia el constructor de la clase Compra
    Compra(Date f, Cliente c, double p){
        this.fecha=f;
        this.comprador=c;
        this.precio=p;
    }
    //Se declara un metodo para mostrar todos los datos de compra
    public void mostrar(){
        //Este Syste.out imprime la fecha en dia/mes/año
        System.out.println("La fecha de en la que se realizo la comra es: "+new SimpleDateFormat("dd-MM-yyyy").format(fecha));
        System.out.println("El cliente que realizo la compra es: \n");
        comprador.mostrarDatos();
        System.out.println("La obra comprada es: \n");
        //Obra.mostrarDatos;
    }
}
/*Se declara la clase Artista*/
class Artista{
    //Se declaran los atributos que tiene la clase Artista
    String nombre;
    Date fnacimiento;
    String nacionalidad;
    String biografia;
    //Se instancia el constructor de la clase Artista
    Artista(String n, Date f,String na, String b){
        this.nombre = n;
        this.fnacimiento = f;
        this.nacionalidad = na;
        this.biografia = b;
    }
    //Se crean los metodos get y set para cada uno de los atributos de Artista
    public String getNombre(){
        return nombre;
    }
    public Date getFnacimiento(){return fnacimiento;}
    public String getNacionalidad(){return nacionalidad;}
    public String getBiografia(){return biografia;}
    public void setNombre(String n){this.nombre=n;}
    public void setFnacimiento(Date f){this.fnacimiento=f;}
    public void setNacionalidad(String na){this.nacionalidad=na;}
    public void setBiografia(String b){this.biografia=b;}
    //Se crea una función para mostrar todos los datos de Artista
    public void mostrarDatos(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Fecha de nacimiento: "+getFnacimiento());
        System.out.println("Nacionalidad: "+getNacionalidad());
        System.out.println("Biografia: "+getBiografia());
    }

}
//Se declara la clase Cliente
class Cliente{
    //Se delcaran todos los atributos de Cliente
    String nombre;
    String dirección;
    String correoe;
    //Se instancia el constructor de la clase Cliente
    Cliente(String n, String d, String c){
        this.nombre = n;
        this.dirección = d;
        this.correoe = c;
    }
    //Se crean los metodos get y set para todos los atributos de la clase Cliente
    public String getNombre(){return nombre;}
    public String getDirección(){return dirección;}
    public String getCorreoe(){return correoe;}
    public void setNombre(String n){this.nombre=n;}
    public void setDirección(String d){this.dirección=d;}
    public void setCorreoe(String c){this.correoe=c;}
    //Se crea una funcion para mostrar todos los datos de Cliente
    public void mostrarDatos(){
        System.out.println("Nombre: "+getNombre());
        System.out.println("Dirección: "+getDirección());
        System.out.println("Correo electronico: "+getCorreoe());
    }
}





public class Galeria {
    public static void main(String[] args) {

    }
}
