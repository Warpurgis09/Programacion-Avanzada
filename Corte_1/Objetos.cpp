#include <iostream>
#include <cmath>
#include <string>
#include<stdlib.h>

using namespace std;

/*Se Crea la clase Circulo: con los m�todos: Area, Diametro y Perimetro*/
class Circulo {
    	//Datos miembros PRIVADOS
    	float radio;
    //Miembros M�todos PUBLICOS  de la clase
    public:
    	//Constructor: se necesita que al instanciar el objeto se de el valor del radio
   		Circulo(float radio);
        //Primer miembro de la clase: C�lculo del �rea
        void area(){
            float area = 3.14159*radio*radio;
            cout << "El area del circulo es: " << area << endl;
        }
        // Segundo miembro de la clase: Calculo del perimetro 
        void perimetro(){
            float perimetro = 3.14159*2*radio;
            cout << "El perimetro del circulo es: " << perimetro << endl;
        }
        // Tercer miebro de l aclase: Calculo del Diametro
        void diametro(){
            float diametro = 2*radio;
            cout << "El diametro del circulo es de: " << diametro << endl;
        }
};

Circulo::Circulo(float _radio){
	radio = _radio;
}

// Creacion de la clase triangulo rectangulo: Los metodos de la clase son: hipotenusa y perimetro
class Triangulo_rectangulo {
    	// Los datos privados de la clase son: La base del triangulo y su altura
    	float base;
    	float altura;
    	//Miebros publicos de  la clase:
    public:
    	//Constructor: Para calcular los datos nescesarios de la clase se solicita el valor de la base  y la altura
    	Triangulo_rectangulo(float base, float altura);
	    //Primer miembro de la clase: hipotenusa del triangulo
	    float hipotenusa(){
	        float hipotenusa = sqrt((base*base)+(altura*altura));
	        cout << "La hipotenusa del triangulo es de: " << hipotenusa << endl;
	        return hipotenusa;
	    }
	    //Segundo miembro de la clase: Perimetro del triangulo
	    void perimetro(){
	        float perimetro = base+altura+hipotenusa();
	        cout << "El perimetro del triangulo es de: "<< perimetro<<endl;
	    }  
};

Triangulo_rectangulo::Triangulo_rectangulo(float _base, float _altura){
	base = _base;
	altura = _altura;
}

//Creacion de la clase persona: Las personas se pueden presentar
class Persona{
    	//Los datos privados de la clase son el nombre de la persona y su edad
    	protected:
    	string nombre;
    	int edad;
    //Los miembros publicos son: 
    public:
    	//Constructor: Define los datos que hay en una persona
    	Persona(string nombre, int edad);
    	//Primer miembro de la clase Persona: Presentarse
    	void presentarse(){
    		cout << "\nMi nombre es: "<<nombre<<endl;
    		cout << "Mi edad es: "<<edad<<endl;
		}
};
Persona::Persona(string _nombre, int _edad){
	nombre = _nombre;
	edad = _edad;
}

/*
//Creaci�n de la clase Profesor que hereda caracteristicas de las personas
class Profesor : protected Persona{
		//Miembros privados de la clase persona: area(Area de trabajo)
		protected:
	    string area;
	public:
		//Constructor: Define los datos que tiene un profesor
		Profesor(string nombre, int edad, string area);
		//Primer miembro de la clase profesor: Presentarse
		void presentarse(){
    		cout << "\nMi nombre es: "<<nombre<<endl;
    		cout << "Mi edad es: "<<edad<<endl;
    		cout << "Mi area de trabajo es: "<<area<<endl;
		}
};

Profesor::Profesor(string _nombre, int _edad, string _area){
	nombre= _nombre;
	edad=_edad;
	area=_area;
}
*/

int main(){
	//Se declaran la variables con las que se crean los objetos
    float radio,altura,base;
    //En esta secci�n se le pide al usuario los datos del circulo
    cout<< "Ingrese el radio del circulo: \n";
    cin>>radio;
    //Se crea un objeto de nombre "circulo1" con los datos ingresados por el usuario
    Circulo circulo1 = Circulo(radio);
    //Se utilizan los miembros metodos del Circulo
    circulo1.area();
    circulo1.perimetro();
    circulo1.diametro();
    
    cout << "\n\nTriangulo rectangulo:\n\n";
    //Se supone que los datos del triangulo ya existen
    Triangulo_rectangulo triangulo1 = Triangulo_rectangulo(12,10);
    //Se utilizan los miembros metodos del Trinagulo_rectangulo
    //No se llama el metodo de la "hipotenusa porque este ya se llama dentro del metodo del "perimetro" no es necesario llamarlo de nuevo"
    triangulo1.perimetro();
    
    cout << "\n\nPersonas\n\n";
    //Se supone que los datos de las personas ya existen
    Persona andres = Persona("Andres",1875);
    //Se utilizan los miebros metodos de la persona
    andres.presentarse();
    

    return 0;
}

