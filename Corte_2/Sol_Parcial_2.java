import java.util.*;

class Componente{
    int id;
    String nombre;
    double peso;
    Componente(int id,String nombre, double peso){
        this.id=id;
        this.nombre=nombre;
        this.peso=peso;
    }
    public int getId(){return id;}
    public String getNombre(){return nombre;}
    public double getPeso(){return peso;}

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
class Robot{
    String codigo;
    double pesoMaximo;
    ArrayList<Componente> componentes = new ArrayList<Componente>();
    Robot(String codigo, double pesoMaximo){
        this.codigo=codigo;
        this.pesoMaximo=pesoMaximo;
        this.componentes=componentes;
    }
    public String getCodigo() {
        return codigo;
    }
    public double getPesoMaximo() {
        return pesoMaximo;
    }
    public ArrayList<Componente> getComponentes() {
        return componentes;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    //Metodos de la clase Robot
    public double pesoTotal(ArrayList<Componente> componentes){
        double pesoTotal=0;
        for (Componente componente:componentes){
            pesoTotal+=componente.getPeso();
        }
        return pesoTotal;
    }
    public boolean añadirComponente(int id, String nombre, double peso){
        if(peso+pesoTotal(componentes)<=getPesoMaximo()){
            componentes.add(new Componente(id, nombre, peso));
            return true;
        }
        else {
            System.out.println("No se ha añadido el componente dado que que el Robot no soporta su peso");
            return false;
        }
    }
}
class Catalogo{
    ArrayList<Robot> robots = new ArrayList<Robot>();
    //Metodos de Catalogo
    public Robot buscarRobot(String codigo){
        Robot robotEncontrado = null;
        for (Robot robot:robots){
            if(codigo.equals(robot.getCodigo())){
                robotEncontrado=robot;
            }
        }
        return robotEncontrado;
    }
    public void añadirRobot(String codigo, double pe){
        if(buscarRobot(codigo)==null){
            robots.add(new Robot(codigo,pe));
        }
        else {
            System.out.println("El Robot ya se encuentra registrado");
        }
    }
    public void añadirComponenteARobot(String codigo, int id, String nombre, double peso){
        Robot robot=null;
        try {
            robot=buscarRobot(codigo);
        }
        catch (NullPointerException e){
            System.out.println("El robot no esta dentro del registro");
        }
        finally {
            robot.añadirComponente(id, nombre, peso);
        }
    }
    public void eliminarRobot(String codigo){
        try {
            robots.remove(buscarRobot(codigo));
        }
        catch (NullPointerException exception){
            System.out.println("El robot no se encuentra en la lista");
        }
    }
    public void nombresDeComponentes(){
        ArrayList<String> list = new ArrayList<String>();
        for (Robot robot:robots){
            for (Componente componente:robot.getComponentes()){
                boolean verificador=false;
               for (String c:list){
                   if (componente.getNombre().equals(c)){
                       verificador=true;
                   }
               }
               if (!verificador){
                   list.add(componente.getNombre());
                   System.out.println(componente.getNombre());
               }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        String ciclo="Hola";
        Scanner scanner =new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        Componente componente;
        int n=0;

        do {
            System.out.println("1) Añadir robot\n2) Mostrar componentes de todos los robots\n3) Añadir componente a unrobot\n4) Salir");
            n=scanner.nextInt();
            switch (n){
                case 1:
                    System.out.println("Ingrese el codigo del robot");
                    String codigo=scanner.nextLine();
                    codigo=scanner.nextLine();
                    System.out.println("Ingrese el peso maximo del robot");
                    double PesoMaximo=scanner.nextDouble();
                    catalogo.añadirRobot(codigo,PesoMaximo);
                    break;
                case 2:
                    catalogo.nombresDeComponentes();
                    break;
                case 3:
                    System.out.println("Ingrese el codigo del robot");
                    codigo=scanner.nextLine();
                    codigo=scanner.nextLine();
                    if (catalogo.buscarRobot(codigo)!=null){
                        System.out.println("ingrese el ID del componente");
                        int id=scanner.nextInt();
                        System.out.println("Ingrese el nombre del componente");
                        String nombre=scanner.nextLine();
                        nombre=scanner.nextLine();
                        System.out.println("Ingrese el peso del componente");
                        double peso=scanner.nextDouble();
                        catalogo.buscarRobot(codigo).añadirComponente(id,nombre,peso);
                    }
                    else {
                        System.out.println("El robot no se ha encontrado");
                    }
            }
        }while (n!=4);
    }
}
