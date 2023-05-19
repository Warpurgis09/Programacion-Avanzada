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
    Obra comprada;
    double precio;
    //Se instancia el constructor de la clase Compra
    Compra(Date f, Cliente c, double p){
        this.fecha=f;
        this.comprador=c;
        this.precio=p;
    }
    //Se declaran las funciones set y get para la Compra
    public Date getFecha(){return fecha;}
    public Cliente getComprador(){return comprador;}
    public double getPrecio(){return precio;}
    //public Obra getComprada(){return comparada;}
    public void setFecha(Date f){this.fecha=f;}
    public void setComprador(Cliente c){this.comprador=c;}
    public void setPrecio(double p){this.precio=p;}
    public void setComprada(Obra o){this.comprada=o;}
    //Se declara un metodo para mostrar todos los datos de compra
    public void mostrar(){
        //Este Syste.out imprime la fecha en dia/mes/año
        System.out.println("La fecha de en la que se realizo la comra es: "+new SimpleDateFormat("dd-MM-yyyy").format(fecha));
        System.out.println("El cliente que realizo la compra es: \n");
        comprador.mostrarDatos();
        System.out.println("La obra comprada es: \n");
        comprada.mostrarDatos();
    }
}
//Se declara la clase Artista
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
        System.out.println("Fecha de nacimiento: "+new SimpleDateFormat("dd-MM-yyyy").format(getFnacimiento()));
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
//Se delcara la clase Obra
class Obra{
    //Se declaran los atrobutos de la clase Obra
    String titulo;
    String tecnica;
    Date año;
    double precio;
    Artista pintor;
    //Se instancia el constructor de la clase Obra
    Obra(String titulo,String tecnica,Date año,double precio,Artista pintor){
        this.titulo=titulo;
        this.tecnica=tecnica;
        this.año=año;
        this.precio=precio;
        this.pintor=pintor;
    }
    //Se crean las funciones set y get de la clase Obra
    public String getTitulo(){return titulo;}
    public String getTecnica(){return tecnica;}
    public Date getAño(){return año;}
    public double getPrecio(){return precio;}
    public Artista getPintor(){return pintor;}
    public void setTitulo(String titulo){this.titulo=titulo;}
    public void setTecnica(String tecnica){this.tecnica=tecnica;}
    public void setAño(Date año){this.año=año;}
    public void setPrecio(double precio){this.precio=precio;}
    public void setPintor(Artista pintor){this.pintor=pintor;}
    //Se crea un metodo para mostrar todos los datos de la Obra
    public void mostrarDatos(){
        System.out.println("El titulo de la obra es: "+getTitulo());
        System.out.println("La tecnica que se utilizo para crear la obra es: "+getTecnica());
        System.out.println("El año en el que se creo la obra es: "+new SimpleDateFormat("yyyy").format(getAño()));
        System.out.println("El precio de la obra es: "+getPrecio());
        System.out.println("El pintor de la obra es: "+pintor.getNombre());
    }
}
//Se crea la clase de ControlGaleria
class ControlGaleria{
    /*
    Se declaran los atributos de la clade ControlGaleria que por el momento seran dos listas
    una de los artistas y otra de las compras y un atributo de la clase
    ControlCliente
     */
    ArrayList<Artista> artistas;
    ControlCliente controlCliente = new ControlCliente();
    //Se crean los metodos get para los atributos de ControlGaleria
    public ArrayList<Artista> getArtistas(){return artistas;}
    public ControlCliente getControlCliente(){return controlCliente;}
    //Se crea el metoso para controlar los clientes
    public void setControlCliente(){
        ControlCliente controlCliente1 = new ControlCliente();
        System.out.println("Agregar u nuevo cliente: ");
        controlCliente1.agregarCliente();
    }
    //Esta funcion solo se creo con el proposito de hacer pruebas
    public void mostrarCliente(){
        controlCliente.mostrarCliente();
    }

    //No se nescesita instanciar un constructor para esta clase
}
//Se crea la clase ControlCLiente
class ControlCliente{
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public ArrayList<Compra> compras;
    //Esta clase tampoco nescesita un constructor
    //Se crean elmetodo get para los atributos de la clase ControlCliente
    public ArrayList<Cliente> getClientes(){return clientes;}
    public ArrayList<Compra> getCompras(){return compras;}
    //Se crea el metodo de agregar clientes
    public void agregarCliente(){
        Scanner scan = new Scanner (System.in);
        String nombre;
        String direccion;
        String correoe;
        System.out.println("Ingrese el nombre del cliente:");
        nombre = scan.nextLine();
        System.out.println("Ingrese la dirrecion de vivienda del nuevo cliente:");
        direccion = scan.nextLine();
        System.out.println("Ingrese el correo electronico:");
        correoe = scan.nextLine();
        clientes.add(new Cliente(nombre,direccion,correoe));
    }
    //Esta funcion solo se creo para hacre pruebas
    public void mostrarCliente(){
        for (Cliente c:clientes) {
            c.mostrarDatos();
        }
    }
}


public class Galeria {
    public static void main(String[] args) {
        ControlGaleria controlGaleria = new ControlGaleria();
        controlGaleria.setControlCliente();
        controlGaleria.mostrarCliente();
    }
}
