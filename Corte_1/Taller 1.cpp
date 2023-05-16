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
	
		int n=1,continuar;
	
	struct datos{
		char nombre[20];  // Se crea una estructura con los datos basicos de un cliente
		int edad;
		int cedula;
		
	}; 
	datos personas[n];  // Se crea un vector de la estructura para guardar mas de un solo cliente
	

	
	for(i=0;i<n;i++){   // En este ciclo se adquieren los datos del cliente
		printf("\n Ingrese el nombre del cliente\n");
		scanf("%s",&personas[i].nombre);
		printf("\n Ingrese la edad del cliente\n");
		scanf("%i",&personas[i].edad);
		printf("\n Ingrese la cedula del cliente\n");
		scanf("%i",&personas[i].cedula);
		
		printf("\n Desea ingresar otro cliente\nSI 1\nNO 0\n"); // se pregunta si quiere ingresar otro cliente
		scanf("%i",&continuar); // si desea continuar se repetira el ciclo de arriva de pedir los datos
		if(continuar==1){
			n++;
		}
	}
}



