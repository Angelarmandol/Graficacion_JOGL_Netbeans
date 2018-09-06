/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yourorghere;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;

//Para usar GLU, colocar librerias
import javax.media.opengl.glu.GLU;
import javax.swing.*;

public class Dibujos_Linea extends JFrame{

    public Dibujos_Linea(){
       //Estable el ancho y alto de la ventana
        setSize(500,500);
        //Establecemos la posicion de la ventana
        setLocation(350,120);
        //Colocamos el titulo a nuestra ventana
        setTitle("Formas de dibujo para Lineas");
        //Creamos una instancia de la clase GraphicListener
        GraphicListener listener = new GraphicListener();
        //agregamos nuestra area de dibujo a la ventana del fram
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
    }

    public static void main (String args[]){
        Dibujos_Linea cuadrado = new Dibujos_Linea();
        cuadrado.setVisible(true);
        cuadrado.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

   //Permiten usar las funciones de opengl
   GL gl;
   GLU glu;

   public class GraphicListener implements GLEventListener{

       public void display(GLAutoDrawable arg0){
       //INICIALIZA GLU
       glu = new GLU();
        //Inicializa Gl
        gl = arg0.getGL();
        //Establecemos el color de fondo de la ventana de colores RGB
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        //Establecemos los parametros de proyeccion
        gl.glMatrixMode(GL.GL_PROJECTION);
        glu.gluOrtho2D(0.0f, 150.0f, 0.0f, 150.0f);
        
        //Comenta las Siguientes Lineas de Codigo
        gl.glBegin(GL.GL_LINES);
        //Indicamos Coordenadas
        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(10,10);

        gl.glColor3f(0.0f,1.0f,0.0f);
        gl.glVertex2i(20,20);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(20,40);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(30,50);

        gl.glColor3f(0.0f,0.0f,1.0f);
        gl.glVertex2i(30,30);

        gl.glColor3f(1.0f,1.0f,1.0f);
        gl.glVertex2i(40,40);
      gl.glEnd();//Fin de Lines


      gl.glBegin(GL.GL_LINE_STRIP);//Traza vertices
        //Indicamos Coordenadas
        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(60,10);

        gl.glColor3f(0.0f,1.0f,0.0f);
        gl.glVertex2i(70,20);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(70,40);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(80,50);

        gl.glColor3f(0.0f,0.0f,1.0f);
        gl.glVertex2i(80,30);

        gl.glColor3f(1.0f,1.0f,1.0f);
        gl.glVertex2i(90,40);
      gl.glEnd();//Fin de Line Strip

      gl.glBegin(GL.GL_LINE_LOOP);//Traza vertice y añade una linea entre el punto de inicio y el final
        //Indicamos Coordenadas
        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(110,10);

        gl.glColor3f(0.0f,1.0f,0.0f);
        gl.glVertex2i(120,20);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(120,40);

        gl.glColor3f(1.0f,0.0f,0.0f);
        gl.glVertex2i(130,50);

        gl.glColor3f(0.0f,0.0f,1.0f);
        gl.glVertex2i(130,30);

        gl.glColor3f(1.0f,1.0f,1.0f);
        gl.glVertex2i(140,40);

        gl.glEnd();//Fin de Line Loop
           
      gl.glFlush();//Procesa todas las Subrutinas de JOGL
       }

        public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
        }

         public void init(GLAutoDrawable arg0) {
        //Manejo de primitivas de JOGL
        GL gl = arg0.getGL();
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA,GL.GL_ONE_MINUS_SRC_ALPHA);
        }

          public void reshape(GLAutoDrawable arg0, int x, int y, int width, int height) {
        }
  }
}




