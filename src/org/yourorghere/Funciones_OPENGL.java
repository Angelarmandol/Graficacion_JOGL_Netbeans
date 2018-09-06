package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;

//Para usar GLU, colocar librerias
import javax.media.opengl.glu.GLU;
import javax.swing.*;

public class Funciones_OPENGL extends JFrame {

    public Funciones_OPENGL() {
        //Estable el ancho y alto de la ventana
        setSize(500, 500);
        //Establecemos la posicion de la ventana
        setLocation(350, 120);
        //Colocamos el titulo a nuestra ventana
        setTitle("Poligonos en JOGL");
        //Creamos una instancia de la clase GraphicListener
        GraphicListener listener = new GraphicListener();
        //agregamos nuestra area de dibujo a la ventana del fram
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    }

    public static void main(String args[]) {
        Funciones_OPENGL cuadrado = new Funciones_OPENGL();
        cuadrado.setVisible(true);
        cuadrado.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    GL gl;
    GLU glu;

    public class GraphicListener implements GLEventListener {

        public void display(GLAutoDrawable arg0) {

            //INICIALIZA GLU
            glu = new GLU();
            //Inicializa Gl
            gl = arg0.getGL();
            //Establecemos el color de fondo de la ventana de colores RGB
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            //Establecemos los parametros de proyeccion
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);

            //el grosor de las lineas
            gl.glLineWidth(2f);
            //el tamaño de los puntos
            gl.glPointSize(3.0f);

//             //Creacion de un cuadrado
//            gl.glColor3f(.5f, 1, 0);
//            gl.glBegin(gl.GL_QUADS);
//            gl.glVertex2f(.3f, .3f);
//            gl.glVertex2f(.3f, .6f);
//            gl.glVertex2f(.6f, .6f);
//            gl.glVertex2f(.6f, .3f);
//            gl.glEnd();

//            //Creacion de un triangulo
//            gl.glColor3f(1f, .5f, 0);
//            gl.glBegin(gl.GL_TRIANGLES);
//            gl.glVertex2f(0.3f, 0.3f);
//            gl.glVertex2f(0.6f, .3f);
//            gl.glVertex2f(.45f, .4f);
//            gl.glEnd();


         //creacion del poligonos
         //Establece la cara que se desea pintar y la forma en la que se desea pintar
         gl.glPolygonMode(GL.GL_FRONT, GL.GL_FILL);
         gl.glColor3f(1.0f, 0.0f, 0.0f);//rojo
         dibujaHexagono(gl,0.4f,0.4f,.5f,0.4f,0.6f,0.5f,0.5f,0.6f,0.4f, 0.6f,0.3f,0.5f);
//
         gl.glPolygonMode(gl.GL_FRONT, gl.GL_LINES);
        gl.glColor3f(0.0f,1.0f,.0f);
        dibujaHexagono(gl,0.4f,0.2f,.5f,0.2f,0.6f,0.3f,0.5f,0.4f,0.4f, 0.4f,0.3f,0.3f);

        gl.glPolygonMode(gl.GL_FRONT, gl.GL_POINT);
        gl.glColor3f(0.0f,0.0f,1.0f);
        dibujaHexagono(gl,0.6f,0.3f,.7f,0.3f,0.8f,0.4f,0.7f,0.5f,0.6f, 0.5f,0.5f,0.4f);
//
       gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
       gl.glColor3f(1.0f,1.0f,0.0f);
       dibujaHexagono(gl,0.6f,0.5f,.7f,0.5f,0.8f,0.6f,0.7f,0.7f,0.6f, 0.7f,0.5f,0.6f);

       gl.glPolygonMode(GL.GL_BACK, GL.GL_LINE);
       gl.glColor3f(0.0f,1.0f,0.0f);
       dibujaHexagono(gl, 0.4f, 0.6f, .5f, 0.6f, 0.6f, 0.7f, 0.5f, 0.8f, 0.4f, 0.8f, 0.3f, 0.7f);

       gl.glPolygonMode(GL.GL_BACK, GL.GL_POINT);
       gl.glColor3f(1.0f,0.0f,1.0f);
       dibujaHexagono(gl, 0.2f, 0.3f, .3f, 0.3f, 0.4f, 0.4f, 0.3f, 0.5f, 0.2f, 0.5f, 0.1f, 0.4f);

       gl.glColor3f(1.0f,0.50f,1.0f);
       dibujaHexagono(gl, 0.2f, 0.5f, .3f, 0.5f, 0.4f, 0.6f, 0.3f, 0.7f, 0.2f, 0.7f, 0.1f, 0.6f);

         //Procesa todas las subrutinas de JOGL, tan rapido como sea posible
         gl.glFlush();
        }

        void dibujaLinea(GL gl, float x1, float y1, float x2, float y2) {
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2f(x1, y1);
            gl.glVertex2f(x2, y2);
            gl.glEnd();
        }

        void dibujaHexagono(GL gl, float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4, float x5, float y5, float x6, float y6) {

            gl.glBegin(GL.GL_POLYGON);
            gl.glVertex2f(x1, y1);
            gl.glVertex2f(x2, y2);
            gl.glVertex2f(x3, y3);
            gl.glVertex2f(x4, y4);
            gl.glVertex2f(x5, y5);
            gl.glVertex2f(x6, y6);
            gl.glEnd();
        }

        public void init(GLAutoDrawable arg0) {
            //Manejo de primitivas de JOGL
            GL gl = arg0.getGL();
            gl.glEnable(GL.GL_BLEND);
            gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        }

        public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
        }

        public void reshape(GLAutoDrawable arg0, int x, int y, int width, int height) {
        }
    }
}




