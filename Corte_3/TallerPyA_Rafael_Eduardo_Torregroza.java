import java.util.*;

//Clase principal
public class ProductoElectronico {
    //Atributos de la clase
    private String nombre;
    private double precio;
    private int garantia;

    //Metodos de la clase

    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public int getGarantia(){
        return garantia;
    }
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setPrecio(double p){
        this.precio=p;
    }
    public void setGarantia(int g){
        this.garantia=g;
    }
    public void cargar(){
        System.out.println("El equipo demora en cargar: 3 Horas");
    }
    public void mostrar(){
        System.out.println("El nombre del producto es: "+getNombre());
        System.out.println("Precio: "+getPrecio());
        System.out.println("La garantia dura: "+getGarantia()+" años");
    }



    public static void main(String[] args) {

        ArrayList<ProductoElectronico> list =new ArrayList<ProductoElectronico>();
        Scanner scan = new Scanner (System.in);
        //list.add(new Celular("Redmi 7",350.80,7,"Xiomi"));
        //list.add(new Computador("Azus",3850000,1,14.5));

        int n = 0;
        do {
            System.out.println("1) Agregar un nuevo producto celular");
            System.out.println("2) Agregar un nuevo producto computador");
            System.out.println("3) Revisar todos los productos");
            System.out.println("4) Salir");
            n = scan.nextInt();
            switch (n) {
                case 1:
                    //en este caso se ingresan los datos de un nuevo celular
                    System.out.println("Ingrese el nombre del producto");
                    String no;
                    /*Se utiliza dos veces la función .nextLine dado que para leer un string lo hace 
                    desde el ultimo \n pero anterior mente para leer el "n" no consumio el \n porque
                    solo lee hasta el proximo entero
                    por lo que al utilizar el nextLine una vez no funciono pero consumio el \n
                    y ya la segunda vez si funcionara
                     */
                    no = scan.nextLine();
                    no = scan.nextLine();
                    System.out.println("Ingrese el precio del producto");
                    double p = scan.nextDouble();
                    System.out.println("Ingrese los años de garantia");
                    int g = scan.nextInt();
                    System.out.println("Ingrese la marca del producto");
                    String m;
                    m = scan.nextLine();
                    m = scan.nextLine();
                    list.add(new Celular(no, p, g, m));

                    break;

                case 2:
                    //Esta función recoje los datos de un nuevo computador
                    System.out.println("Ingrese el nombre del producto");
                    String nom;
                    nom = scan.nextLine();
                    nom = scan.nextLine();
                    System.out.println("Ingrese el precio del producto");
                    double pr = scan.nextDouble();
                    System.out.println("Ingrese los años de garantia");
                    int ga = scan.nextInt();
                    System.out.println("Ingrese el tamaño de la pantalla");
                    double t; 
                    t= scan.nextInt();
                    t= scan.nextInt();
                    list.add(new Computador(nom, pr, ga, t));

                    break;
                case 3:
                    //Esta funcion imprime todos los elementos de la lista
                    for (ProductoElectronico pro : list) {
                        pro.mostrar();
                        pro.cargar();
                    }
                    break;
            }
        }while (n!=4);

    }
}

//Clase hija de ProductoElectronico
class Celular extends ProductoElectronico{
    private String marca;

    //Constructor de la clase
    Celular(String n,double p, int g, String m){
        setNombre(n);
        setPrecio(p);
        setGarantia(g);
        this.marca=m;
    }

    public String getMarca(){
        return marca;
    }
    public void cargar(){
        System.out.println("El equipo demora en cargar: 6 Horas\n");
    }
    public void mostrar(){
        System.out.println("El nombre del producto es: "+getNombre());
        System.out.println("Marca: "+getMarca());
        System.out.println("La garantia dura: "+getGarantia()+" años");
        System.out.println("Precio: "+getPrecio());
    }
}

//Clase hija de ProductoElectronico
class Computador extends ProductoElectronico{
    private double tamañoPantalla;

    //Constructor de la clase
    Computador(String n,double p, int g,double t){
        setNombre(n);
        setPrecio(p);
        setGarantia(g);
        this.tamañoPantalla=t;
    }
    public double getTamañoPantalla(){
        return tamañoPantalla;
    }
    public void cargar(){
        System.out.println("El equipo demora en cargar: 10 Horas\n");
    }
    public void mostrar(){
        System.out.println("El nombre del producto es: "+getNombre());
        System.out.println("El tamaño de la pantalla es: "+ getTamañoPantalla());
        System.out.println("la garantia dura: "+getGarantia()+" años");
        System.out.println("El precio es:"+getPrecio());
    }
}
