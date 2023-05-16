#include <stdio.h>

/* Autor: Rafael Eduardo
  Fecha: 08/02/2023
  Tema: Vectores */

int main(void) { // Declaro la variable n que es el tamaño del vector el vector y otras variables
   int i,j,n,numeros[n];
  n=5; // Declaro el tamaño que tomara el vetor
  
  for(i=0;i<n;i++){ // Lleno el vector de numeros
    numeros[i]=1;
  }
  printf("\nVector inicial:\n");  // Imprimo todos los valores del vector
  for(i=0;i<n;i++){ 
    printf("\n %i",numeros[i]);
  }













  
  return 0;
}