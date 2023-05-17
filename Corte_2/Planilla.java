import java.util.*;

class Jugadores {
    private String nombre;
    private int ELO;
    private int edad;
    private int valor_premio;
    public Jugadores(String nombre,int ELO,int edad,int valor_premio){
        this.nombre=nombre;
        this.ELO=ELO;
        this.edad=edad;
        this.valor_premio=valor_premio;
    }
    public String GetNombre(){
        return nombre;
    }
    public int GetELO(){
        return ELO;
    }
    public int GetEdad(){
        return edad;
    }
    public int GetValor_premio(){
        return valor_premio;
    }
    public void SetNombre(String nombre){
        this.nombre=nombre;
    }
    public void SetELO(int ELO){
        this.ELO=ELO;
    }
    public void SetEdad(int edad){
        this.edad=edad;
    }
    public void SetValor_premio(int valor_premio){
        this.valor_premio=valor_premio;
    }
}

class OrdenarJugadoresELO implements Comparator<Jugadores>{
    public int compare(Jugadores ju1,Jugadores ju2){
        return ju1.GetELO()-ju2.GetELO();
    }
}
class OrdenarJugadoresEdad implements Comparator<Jugadores>{
    public int compare(Jugadores ju1,Jugadores ju2){
        return ju1.GetEdad()-ju2.GetEdad();
    }
}
class OrdenarJugadoresValor_premio implements Comparator<Jugadores>{
    public int compare(Jugadores ju1,Jugadores ju2){
        return ju1.GetValor_premio()-ju2.GetValor_premio();
    }
}

public class Planilla {
    public static void main(String[] args) {
        ArrayList<Jugadores> lista = new ArrayList<Jugadores>();
        lista.add(new Jugadores("El",100,1000,1));
        lista.add(new Jugadores("Ella",101,20,2));
        lista.add(new Jugadores("Ellos",102,70,3));
        lista.add(new Jugadores("Elias",103,6,4));
        lista.add(new Jugadores("ElMacho",104,3,5));
        lista.add(new Jugadores("ElNadie",105,546,6));
        lista.add(new Jugadores("ElKanicas",106,1,7));
        int n=0;
        do {
            System.out.print("\nQue opcion desea realizar\n1)Imprimir tal cual\n2)Ordenar por ELO\n3)Ordenar por edad\n4)Ordenar por el valor del premio\n5)Salir\n");
            Scanner scan = new Scanner (System.in);
            n = scan.nextInt();
            switch (n){
                case 2:
                    Collections.sort(lista, new OrdenarJugadoresELO());
                    for (Jugadores ju:lista){
                        System.out.println("("+ju.GetNombre()+","+ju.GetELO()+","+ju.GetEdad()+","+ju.GetValor_premio()+")");
                    }
                    break;
                case 3:
                    Collections.sort(lista, new OrdenarJugadoresEdad());
                    for (Jugadores ju:lista){
                        System.out.println("("+ju.GetNombre()+","+ju.GetELO()+","+ju.GetEdad()+","+ju.GetValor_premio()+")");
                    }
                    break;
                case 4:
                    Collections.sort(lista, new OrdenarJugadoresValor_premio());
                    for (Jugadores ju:lista){
                        System.out.println("("+ju.GetNombre()+","+ju.GetELO()+","+ju.GetEdad()+","+ju.GetValor_premio()+")");
                    }
                    break;
                case 1:
                    for (Jugadores ju:lista){
                        System.out.println("("+ju.GetNombre()+","+ju.GetELO()+","+ju.GetEdad()+","+ju.GetValor_premio()+")");
                    }
                    break;
            }
        }while (n!=5);
    }
}





