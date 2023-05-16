/*
Fecha: 077/03/2023
Autores: Rafael Torregroza y Santiago Urrutia
Thema: Proyecto de programación

Instrucciones: Crear una aplicación para una empresa capaz de registrar sus empleados
dentro de un archivo binario, ademas de poder alterar este archivo para poder 



*/
#include <iostream>
#include <fstream>
#include <string.h>
#include <cstdlib>
#include <ctime>

using namespace std;
void funcionregistrarempleados(struct empleados datos[], int n);
int funcionagregarempleados(struct empleados datos[], int n);
void funcionmostrarempleados(struct empleados datos[], int n);
void funcioncambiarcelular(struct empleados datos[], int n);
int funciondespedir(struct empleados datos[], struct empleados despedidos[], int n, int j);
void funcionmostrarempleadosdespedidos(struct empleados despedidos[], int j);


struct empleados {
	int codigo;
	char nombre[20];
	char apellidos[20];
	int celular;
};


int main(){
	int i=0,j=0,k=1,l,m=0;
	empleados datos[100];
	empleados despedidos[100];
	empleados leer;
	
	while(i==0){
	
		ofstream salidaArchivo;
		ifstream entradaArchivo;
		cout<<"Que operacion desea realizar \n1) Registrar un empleado\n2) Agregar un empleado\n3) Mostrar empleados registrados\n4) Cambiar un numero de celular\n5) Despedir un empleado\n6) Mostrar empleados despedidos\n";
		cin>>l;
		
		switch(l){
			case 1:
				salidaArchivo.open("Empleados.bin",ios::binary);
				while(k==1){
					m++;
					cout<<"\nIngreso de datos\n";
					funcionregistrarempleados(datos,m);
					salidaArchivo.write((char*)&datos[m-1], sizeof(empleados));
					cout<<"Desea registrar otro empleado \n1) SI\n2) NO\n";
					cin>>k;
				}
				salidaArchivo.close();
				break;
			case 2:
				salidaArchivo.open("Empleados.bin",ios::binary|ios::app);
				if((funcionagregarempleados(datos,m))==0){
					m++;
				}
				salidaArchivo.write((char*)&datos[m-1], sizeof(empleados));
				salidaArchivo.close();
				break;																	//m=entradaArchivo.tellg()/sizeof("Empleados.bin");
			case 3:
				entradaArchivo.open("Empleados.bin",ios::binary|ios::in);  
				m=0;                                                                                 
				while(!entradaArchivo.eof()){
				    entradaArchivo.read((char*)&datos[m], sizeof(empleados));
				    m++;
				}
				funcionmostrarempleados(datos,m);	
				entradaArchivo.close();
				break;
			case 4:
				salidaArchivo.open("Empleados.bin",ios::binary|ios::out);
				funcioncambiarcelular(datos,m);
				for(i=0;i<m-1;i++){
					salidaArchivo.write((char*)&datos[i], sizeof(empleados));
				}
				salidaArchivo.close();
				break;
			case 5:
				salidaArchivo.open("Empleados.bin",ios::binary|ios::out);
				j++;
				if(funciondespedir(datos,despedidos,m,j)==0){
					m--;
				}
				else{
					j--;
				}
				for(i=0;i<m-1;i++){
					salidaArchivo.write((char*)&datos[i], sizeof(empleados));
					}
				salidaArchivo.close();
				
				salidaArchivo.open("EmpleadosDespedidos.bin",ios::binary|ios::app);
				for(i=0;i<j;i++){
					salidaArchivo.write((char*)&despedidos[i], sizeof(empleados));	
				}
				salidaArchivo.close();
				for(i=0;i<j;i++){
					cout<<"Empleado despedido #"<<i+1<<endl;  
					cout<<"\nCodigo: "<<despedidos[i].codigo<<endl;
					cout<<"\nNombre: "<<despedidos[i].nombre<<endl;
					cout<<"\nApellidos: "<<despedidos[i].apellidos<<endl;
					cout<<"\nCelular: "<<despedidos[i].celular<<endl<<endl;
				}
				break;
			case 6:
				entradaArchivo.open("EmpleadosDespedidos.bin",ios::binary|ios::in);  
				j=0;                                                                               
				while(!entradaArchivo.eof()){
				    entradaArchivo.read((char*)&despedidos[j], sizeof(empleados));
				    j++;
				}
				j--;
				funcionmostrarempleadosdespedidos(despedidos,j);	
				entradaArchivo.close();
				cout<<j;
				break;
		}
	}
}


void funcionregistrarempleados(struct empleados datos[], int n){
	
	cout<<"\n\n Funcion para registrar empleados\n\n";	
	cout<<"\nIngrese el codigo del empleado: "<<endl;
	cin>>datos[n-1].codigo;
	cout<<"Ingrese el nombre del empleado: "<<endl;
	cin>>datos[n-1].nombre;
	cout<<"Ingrese el apellido del empleado: "<<endl;
	cin>>datos[n-1].apellidos;
	cout<<"Ingrese el telefono del empleado: "<<endl;
	cin>>datos[n-1].celular;
}	

int funcionagregarempleados(struct empleados datos[], int n){
	
	int codigoe,i,verificador=0;
	
	cout<<"\n\n Funcion para agregar empleados\n\n";
	cout<<"\nIngrese el codigo del empleado: "<<endl;
	cin>>codigoe;
	for(i=0;i<n;i++){
		
		if(codigoe==datos[i].codigo){
			verificador=1;
			cout<<"\nEste empleado ya esta registrado";
		}
	}
	if(verificador==0){
		n++;
		datos[n-1].codigo=codigoe;
		cout<<"Ingrese el nombre del empleado: "<<endl<<n<<endl;
		cin>>datos[n-1].nombre;
		cout<<"Ingrese el apellido del empleado: "<<endl;
		cin>>datos[n-1].apellidos;
		cout<<"Ingrese el telefono del empleado: "<<endl;
		cin>>datos[n-1].celular;
	}
	return verificador;
}

void funcionmostrarempleados(struct empleados datos[], int n){
	
	int i=0;
	
	for(i=0;i<n-1;i++){
		
		cout<<"\n \nEmpleado numero: "<<i+1;
		cout<<"\nCodigo: "<<datos[i].codigo<<endl;
		cout<<"\nNombre: "<<datos[i].nombre<<endl;
		cout<<"\nApellidos: "<<datos[i].apellidos<<endl;
		cout<<"\nCelular: "<<datos[i].celular<<endl<<endl;
	}
	
}


void funcioncambiarcelular(struct empleados datos[], int n){
	
	int codigoe,i,nuevocelular;
	cout<<"\nIngrese el codigo del empleado a modificar numero de telefono\n";
	cin>>codigoe;
	
	for(i=0;i<n;i++){
		if(codigoe==datos[i].codigo){
			cout<<"\nIngrese el nuevo numero del empleado"<<endl;
			cin>>nuevocelular;
			datos[i].celular=nuevocelular;
		}
	}
}


int funciondespedir(struct empleados datos[], struct empleados despedidos[], int n, int j){
	
	
	int codigoe,i,k,l=1;
	string nombredespedido;
	cout<<"\nIngrese el codigo del empleado a despedir\n";
	cin>>codigoe;
	for(i=0;i<n;i++){
		if(codigoe==datos[i].codigo){
			despedidos[j-1].codigo = datos[i].codigo;
			despedidos[j-1].celular = datos[i].celular;
			strcpy(despedidos[j-1].nombre,datos[i].nombre);
			strcpy(despedidos[j-1].apellidos,datos[i].apellidos);
			nombredespedido=datos[i].nombre;
			
			for(k=i;k<n;k++){
				
				datos[k].codigo=datos[k+1].codigo;
				datos[k].celular=datos[k+1].celular;
				strcpy(datos[k].nombre,datos[k+1].nombre);
				strcpy(datos[k].apellidos,datos[k+1].apellidos);
			}
			l=0;
			
			time_t t;
			t= time(NULL);
			struct tm *fecha;
			fecha = localtime(&t);

			
			string carta="Carta_Despido_"+string(nombredespedido) +".txt";
			ofstream salida;
			salida.open((char*)&carta);		
			salida<<"Querido empleado: ";
			salida<<despedidos[j-1].nombre<<" ";
			salida<<despedidos[j-1].apellidos<<" ";
			salida<<"De codigo de empleado: ";
			salida<<despedidos[j-1].codigo<<" ";
			salida<<"Le informamos que el dia ";
			salida<<fecha->tm_mday<<" del mes ";
			salida<<fecha->tm_mon+1<<" y del a�o ";
			salida<<fecha->tm_year+1900;
			salida<<" Usted ha sido despedido porque me cae mal";
		
		}
	}
	if(l!=0){
		cout<<"\nEl codigo del empleado no se encuentra dentro de los registros";
	}
	return l;
}


void funcionmostrarempleadosdespedidos(struct empleados despedidos[], int j){
	int i;
	
	for(i=0;i<j;i++){
		cout<<"Empleado despedido #"<<i+1<<endl;  
		cout<<"\nCodigo: "<<despedidos[i].codigo<<endl;
		cout<<"\nNombre: "<<despedidos[i].nombre<<endl;
		cout<<"\nApellidos: "<<despedidos[i].apellidos<<endl;
		cout<<"\nCelular: "<<despedidos[i].celular<<endl<<endl;
	}
}


