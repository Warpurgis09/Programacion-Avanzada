/*
Fecha:
Autores: Rafael Eduardo Torregroza y Santiago Urrutia
Tema: POO
Proposito: Este es un proyecto para la clase de programación avanzada en la univeridad Javeriana
Este es unproyecto para crear la interfaz de una galeria de arte en la cual se pueden realizar compras de las obras dentro
de esta galeria.
 */


import java.text.DateFormat;
import java.text.ParseException;
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
    SimpleDateFormat fnacimiento;
    String nacionalidad;
    String biografia;
    //Se instancia el constructor de la clase Artista
    Artista(String n, SimpleDateFormat f,String na, String b){
        this.nombre = n;
        this.fnacimiento = f;
        this.nacionalidad = na;
        this.biografia = b;
    }
    //Se crean los metodos get y set para cada uno de los atributos de Artista
    public String getNombre(){
        return nombre;
    }
    public SimpleDateFormat getFnacimiento(){return fnacimiento;}
    public String getNacionalidad(){return nacionalidad;}
    public String getBiografia(){return biografia;}
    public void setNombre(String n){this.nombre=n;}
    public void setFnacimiento(SimpleDateFormat f){this.fnacimiento=f;}
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
    SimpleDateFormat año;
    double precio;
    Artista pintor;
    //Se instancia el constructor de la clase Obra
    Obra(String titulo,String tecnica,SimpleDateFormat año,double precio,Artista pintor){
        this.titulo=titulo;
        this.tecnica=tecnica;
        this.año=año;
        this.precio=precio;
        this.pintor=pintor;
    }
    //Se crean las funciones set y get de la clase Obra
    public String getTitulo(){return titulo;}
    public String getTecnica(){return tecnica;}
    public SimpleDateFormat getAño(){return año;}
    public double getPrecio(){return precio;}
    public Artista getPintor(){return pintor;}
    public void setTitulo(String titulo){this.titulo=titulo;}
    public void setTecnica(String tecnica){this.tecnica=tecnica;}
    public void setAño(SimpleDateFormat año){this.año=año;}
    public void setPrecio(double precio){this.precio=precio;}
    public void setPintor(Artista pintor){this.pintor=pintor;}
    //Se crea un metodo para mostrar todos los datos de la Obra
    public void mostrarDatos(){
        System.out.println("El titulo de la obra es: "+getTitulo());
        System.out.println("La tecnica que se utilizo para crear la obra es: "+getTecnica());
        System.out.println("El año en el que se creo la obra es: "+getAño());
        System.out.println("El precio de la obra es: "+getPrecio());
        System.out.println("El pintor de la obra es: "+pintor.getNombre());
    }
}
//Se crea la clase de ControlGaleria
class ControlGaleria{
    //Se declara un array list de los artistas en la clase
    ArrayList<Artista> artistas = new ArrayList<Artista>();
    //Se declara un array lista para las obras en la galeria
    ArrayList<Obra> obras= new ArrayList<Obra>();

    /*Se crea una función para agregar Artistas y puede terminar con una exepcion de tipo Parse
    que es la funcion utilizada para convertir un String a Date
     */
    public void agregarArtista() throws ParseException {
        Scanner scan = new Scanner (System.in);
        String nombre;
        String fecha;
        String nacionalidad;
        String biografia;
        //Se crea un objeto de tipo Symple date format para recivir la fecha en un formato
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Ingrese el nombre del Artista: ");
        nombre = scan.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del Artista en el siguiente formato (dd/MM/yyyy): ");
        fecha = scan.nextLine();
        //Desde esta función se convierte el texto en fecha
        sdf.parse(fecha);
        System.out.println("Ingrese la nacionalidad del Artista:");
        nacionalidad = scan.nextLine();
        System.out.println("Ingrese la biografia del Artista");
        biografia = scan.nextLine();
        artistas.add(new Artista(nombre,sdf,nacionalidad,biografia));
    }

    //Se declara una función para buscar artistas segun el nombre para facilitar otros metodos
    public Artista buscarArtista(String nombre){
        Artista buscado=null;
        boolean verificador=false;
        //Se busca el nombre del artista en la lista
        for (Artista artista : artistas) {
            if (artista.getNombre().equals(nombre)) {
                verificador=true;
                buscado=artista;
            }
        }
        return buscado;
    }
    //Se declara el metodo para eliminar artista por el nombre de estos
    public void eliminarArtista(){
        System.out.println("Ingrese el nombre del artista a eliminar");
        /*
        Se crea un objeto de la clase scanner para leer datos desde pantalla
         */
        Scanner scanner = new Scanner(System.in);
        String nombre = scanner.nextLine();
        //Se utiliza una excepcion en caso de no encontrar el artista
        try {
            artistas.remove(buscarArtista(nombre));
        }
        catch (NullPointerException exception){
            System.out.println("El artista no existe en el registro");
        }
    }
    //Se declara una función para agregar obras a la lista con la misma excepcion de agregar artista
    public void agregarObra() throws ParseException{
        Scanner scan = new Scanner (System.in);
        String titulo;
        String tecnica;
        String año;
        double precio;
        String pintor;
        //Se crea un objeto de tipo Symple date format para recivir la fecha en un formato
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        System.out.println("Ingrese el nombre del Artista que creo la obra: ");
        pintor = scan.nextLine();
        //Primero se comprueba que el artista asignado a la obra exista
        if(buscarArtista(pintor)!=null){
            System.out.println("Ingrese el titulo de la obra: ");
            titulo=scan.nextLine();
            System.out.println("Ingrese la tecnica utilizada: ");
            tecnica=scan.nextLine();
            System.out.println("Ingrese el año de la creación de la obra: ");
            año=scan.nextLine();
            //Aqui se transforma el año(String) a fecha(SympleDateFormat)
            sdf.parse(año);
            System.out.println("Ingrese el valor de la obra: ");
            precio=scan.nextDouble();
            obras.add(new Obra(titulo,tecnica,sdf,precio,buscarArtista(pintor)));
        }
        else {
            System.out.println("No se encontro al artista responsable de la obra");
        }
    }
}
//Se crea la clase ControlCLiente
class ControlCliente{
    //Se crea un ArrayList para guardar los clientes
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
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
    //Esta funcion solo se creo para hacer pruebas
    public void mostrarCliente(){
        for (int i=0;i<clientes.size();i++) {
            clientes.get(i).mostrarDatos();
        }
    }
}


public class Galeria {
    public static void main(String[] args) {
        ControlGaleria controlGaleria = new ControlGaleria();
        ControlCliente controlCliente = new ControlCliente();
        Scanner scanner = new Scanner(System.in);
        int n=0;
        while (n!=3) {
            System.out.println("1) Añadir artista");
            System.out.println("2) Añadir obra");
            n=scanner.nextInt();
            try {
                switch (n) {
                    case 1:
                        controlGaleria.agregarArtista();
                        break;
                    case 2:
                        controlGaleria.agregarObra();
                        break;
                }
            } catch (ParseException exception) {
                System.out.println("La fecha ingresada es incorrecta");
            }
        }
    }
}
