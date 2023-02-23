#include<stdio.h>
#include<stdlib.h>   // Se declarar las librerias nescesarias para generar numeros aleatorios y imprimir mensajes
#include<time.h>

int main(){
	// Ejercicio 1 
	
	srand(time(NULL));  // Se llama a la función que nos permitira generar numeros aleatorios
	
	int array[10],i;    // Declaramos un vector ded 10 posiciones
	int *apuntador=&array[0];  // creamos un apuntador que apunta a el primer elemento del array
	
	for(i=0;i<10;i++){					// En este ciclo se llena cada posicion del vetor con un numero aleatorio se imprime el valor y la dirrecion en la que esta almacenado
		
		array[i]= rand()%26;
		printf("\n %i",*apuntador);
		printf("\n %i",apuntador);
		apuntador++;
	}
	
	
	// Ejercicio 2
	
	
	
	
	
	
}



