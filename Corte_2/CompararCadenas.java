
class CompararCadenas {
  public static void main(String[] arg){
    String cadena1 = "Los Amigos";
    String cadena2 = "Los amigos";
    //Se instancia objetos del tipo String
    Object obCadena = cadena1;
    //Determinar si ambas cadenas sin iguales
    System.out.println(cadena1.compareTo(cadena2));
    System.out.println(cadena1.compareToIgnoreCase(cadena2));
    System.out.println(cadena1.equals(cadena2));
    System.out.println(cadena1=cadena2);
  }
}