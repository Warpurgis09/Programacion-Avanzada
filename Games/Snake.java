/*
Autor: Rafael Eduardo Torregroza Vidal
FechaA: 15/05/2023
Tema: Juego de Snake.
Descripcción: En este codigo se programo el juego de snake.
Proposito: Aprender nuevos conceptos sobre java.
*/


import javax.swing.*;
import java.awt.*;

//Libreria para espesificar colores
import java.awt.color.*;
//Especificar el tamaño de las ventanas
//Libreria para interactuar con las teclas
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
//Especificar un punto en el plano


//la clase Snake es una extencion de JFrame porque es una ventana
public class Snake extends JFrame {
    //las variables Width y height son para determinar la altura y ancho de la ventana en pixeles
    int width = 640;
    int height = 480;

    //esta variables determinan el tamaño de la serpiente
    int widthPoint=10;
    int heightPoint=10;

    //Esta variable lee las teclas de movimiento
    int direccion = KeyEvent.VK_R;
    //Esta variable me permitira reiniciar en juego despues de perder
    int continuar = KeyEvent.VK_R;

    //una variable que determina cada cuanto se refresca el juego
    long frecuencia= 40;
    Point snake;
    Point comida;
    boolean gameOver = false;

    ArrayList<Point>lista = new ArrayList<Point>();
    ImagenSnake imagenSnake;
    //En el constructor de la clase se le pone el titulo a la ventana el tamaño de esta y que sea visible
    public Snake(){
        setTitle("Snake");
        setSize(width,height);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //Toma el tamaño de la ventana

        //Esta funcion centra la ventana en el medio de la pantalla
        this.setLocation(dim.width/2-width/2, dim.height/2-height/2);

        //Con esta función cuando salga de la ventana tambien va a cerrar la aplicación
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Se crea un objeto de la clase teclas para poder hacer que el programa las reconosca
       Teclas teclas = new Teclas();
       this.addKeyListener(teclas);

       startGame();

       //se crea un objeto tipo snake y se determina donde empieza
       snake = new Point(width/2,height/2);

       imagenSnake = new ImagenSnake();
       //Se agrega el contenedor de la serpiente
        this.getContentPane().add(imagenSnake);


        setVisible(true);

        //Funciones que inician el juego
        Momento momento = new Momento();
        Thread thread = new Thread(momento);
        thread.start();
    }

    //Funcion para crear la comida
    public void startGame(){
        comida = new Point(200,200);
        snake = new Point(width/2,height/2);
        lista = new ArrayList<Point>();
        lista.add(snake);
        crearComida();
    }

    //Funcion que ubica la comida en un lugar aleatorio
    public void crearComida(){
        Random rnd = new Random();
        //Funcion que le asigna un numero random en x de la comida desde 0 hasta el ancho
        comida.x = rnd.nextInt(width);
        //Funciones que mantienen el valor de la pocición dentro de la ventana
        if((comida.x> (width-40))){
            comida.x = comida.x -40;
        }
        if(comida.x < 10){
            comida.x = comida.x + 10;
        }
        comida.y = rnd.nextInt(height);
        if(comida.y>(height-40)){
            comida.y = comida.y - 40;
        }
        if(comida.y < 10){
            comida.y = comida.y + 20;
        }
    }

    //En el main se crea un objeto de la clase Snake
    public static void main(String[] args) {Snake s = new Snake();}
    //Funcion que dibuja la nueva serpiente
    public void actualizar(){
        imagenSnake.repaint();

        lista.add(0,new Point(snake.x,snake.y));
        lista.remove((lista.size())-1);

        //Funcion para perder si se choca con el cuerpo o con los bordes
        for(int i=1;i<lista.size();i++){
            Point point = lista.get(i);
            if((snake.x == point.x && snake.y == point.y)||(snake.x==0)||(snake.y==0)||(snake.x==width)||(snake.y==height)){
                gameOver = true;
            }
        }

        //Si la serpiente entra en la zona de la commida
        if((snake.x<(comida.x+10))&&(snake.x>(comida.x-10))&&(snake.y<(comida.y+10))&&(snake.y>(comida.y-10))){
            //Al comer se agrega una nueva sección
            lista.add(0,new Point(snake.x,snake.y));
            crearComida();
        }
    }

    //En esta clase se dibuja la serpiente
    public class ImagenSnake extends JPanel{
        public void paintComponent(Graphics g){
            //Esta funcion la pinta en la ventana
            super.paintComponent(g);
            //Esta funcion determina el color en azul
            g.setColor(new Color(0,0,225));
            //Esta función determina el tamaño inicial de la serpiente y que sea un resctanguna que este lleno
            g.fillRect(snake.x,snake.y,widthPoint,heightPoint);

            //Esta cuncion añane el tamaño de la serpiente
            for (int i =0;i<lista.size();i++){
                Point point = (Point)lista.get(i);
                //Esta función determina el tamaño inicial de la serpiente y que sea un rectangulo que este lleno
                g.fillRect(point.x,point.y,widthPoint,heightPoint);
            }
            g.setColor(new Color(255,0,0));
            g.fillRect(comida.x,comida.y,widthPoint,heightPoint);
            if (gameOver){
                g.drawString("Game Over",200,320);
            }
            g.drawString("PUNTAJE: "+(lista.size()-1),0,10);
        }
    }

    //Sobre la clase teclas nos permite evaluar los eventos de las teclas sin tener que implementarlo nosotros
    public class Teclas extends KeyAdapter{
        public void keyPressed(KeyEvent e) {
            //Con esta funcion si se presioa la tecla escape se saldra de la aplicación
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
                //Estas funciones le dan direccion a la serpiente
                else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (direccion != KeyEvent.VK_DOWN) {
                        direccion = KeyEvent.VK_UP;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (direccion != KeyEvent.VK_UP) {
                        direccion = KeyEvent.VK_DOWN;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (direccion != KeyEvent.VK_RIGHT) {
                        direccion = KeyEvent.VK_LEFT;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (direccion != KeyEvent.VK_LEFT) {
                        direccion = KeyEvent.VK_RIGHT;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    continuar = KeyEvent.VK_ENTER;
                }
        }
    }
    //Clase Momento permite el movimiento de la serpiente
    public class Momento extends Thread{
        long last=0;
        public void run(){
            while (true){
                if((java.lang.System.currentTimeMillis()-last) >frecuencia) {
                    if (!gameOver) {
                        //Funcion que hace que la serpiente se mueva hacia arriba
                        if (direccion == KeyEvent.VK_UP) {
                            snake.y = snake.y - heightPoint;
                            if (snake.y < 0) {
                                snake.y = height - heightPoint;
                            }
                            if (snake.y > height) {
                                snake.y = 0;
                            }
                        }
                        //Función que hace que la serpiente se mueva hacia abajo
                        if (direccion == KeyEvent.VK_DOWN) {
                            snake.y = snake.y + heightPoint;
                            if (snake.y < 0) {
                                snake.y = height - heightPoint;
                            }
                            if (snake.y > height) {
                                snake.y = 0;
                            }
                        }
                        if (direccion == KeyEvent.VK_LEFT) {
                            snake.x = snake.x - widthPoint;
                            if (snake.x < 0) {
                                snake.x = width - widthPoint;
                            }
                            if (snake.x > width) {
                                snake.x = 0;
                            }
                        }
                        if (direccion == KeyEvent.VK_RIGHT) {
                            snake.x = snake.x + widthPoint;
                            if (snake.x < 0) {
                                snake.x = width - widthPoint;
                            }
                            if (snake.x > width) {
                                snake.x = 0;
                            }
                        }
                        actualizar();
                        last = java.lang.System.currentTimeMillis();
                    }
                }
                //Funcion que me permite reiniciar el juego despues de perder
                if(continuar == KeyEvent.VK_ENTER){
                    gameOver=false;
                    continuar = KeyEvent.VK_R;
                    direccion = KeyEvent.VK_R;
                    startGame();
                }
            }
        }
    }
}
