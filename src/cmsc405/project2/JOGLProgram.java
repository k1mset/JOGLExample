package cmsc405.project2;

/**
 * File: JOGLProgram.java
 * Date: 11/13/2018
 * Author: Dillan Cobb
 * Purpose: Create and display 6 unique shapes created in JOGL for the user.
 */

// Imports
import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLJPanel;

import java.awt.Dimension;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.swing.JFrame;

public class JOGLProgram extends GLJPanel implements GLEventListener  {
    
    // Main creates the display window
    public static void main(String[] args) {
        JFrame window = new JFrame("CMSC 405 - Project 2");
        JOGLProgram panel = new JOGLProgram();
        window.setContentPane(panel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    
    // Constructor sets the dimensions
    public JOGLProgram() {
        setPreferredSize( new Dimension(640, 480) );
        addGLEventListener(this);
    }
    
    // ---------------  Methods of the GLEventListener interface -----------

    // init method is called when the panel is created
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glOrtho(-1, 1 ,-1, 1, -1, 1);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glClearColor( 0, 0, 0, 1 );
        gl.glEnable(GL2.GL_DEPTH_TEST);
   }

    // display method is called when the panel needs to be drawn
    // Creates all the images for the panel
    public void display(GLAutoDrawable drawable) {    
        GL2 gl = drawable.getGL().getGL2();
         
        // Clear the drawable
        gl.glClearColor( 0, 0, 0, 1 );
        gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
        gl.glLoadIdentity();
        
        // Draw the right triangle
        gl.glPushMatrix();
        gl.glTranslatef(-0.8f, 0.5f, 0);
        createRightTriangle(gl, 1, 0, 0);
        gl.glPopMatrix();
        
        // Draw the square
        gl.glPushMatrix();
        gl.glTranslatef(-0.4f, 0.5f, 0);
        gl.glRotatef(45,0,0,1);
        createSquare(gl, 0, 1, 0);
        gl.glPopMatrix();
        
        // Draw the trapazoid
        gl.glPushMatrix();
        gl.glTranslatef(0, 0.5f, 0);
        gl.glScalef(2,2,2);
        createTrapazoid(gl, 0, 0, 1);
        gl.glPopMatrix();
        
        // Draw the 3d triangle
        gl.glPushMatrix();
        gl.glRotatef(45,1,0,0);
        gl.glRotatef(25,0,0,1);
        gl.glScalef(1.2f,2,2);
        gl.glTranslatef(-0.6f, 0, 0);
        create3dTriangle(gl);
        gl.glPopMatrix();
        
        // Draw the cube
        gl.glPushMatrix();
        gl.glRotatef(50,1,0,0);
        gl.glRotatef(25,0,1,0);
        gl.glTranslated(-0.2,0,0);
        gl.glScalef(0.5f,0.5f,0.5f);
        createCube(gl);
        gl.glPopMatrix();
        
        // Draw the house
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0, 0);
        gl.glRotated(30,1,0,0);
        gl.glRotated(30,0,1,0);
        createHouse(gl);
        gl.glPopMatrix();
        
        
        
    }

    // reshape method is called everytime the window is resized.
    public void reshape(GLAutoDrawable drawable,
                              int x, int y, int width, int height) {
        
    }

    // dispose method is called each time the panel is disposed of
    public void dispose(GLAutoDrawable drawable) {
    }
    
    // Creates a 2d right triangle
    public void createRightTriangle(GL2 object, double r, double g, double b) {
        object.glBegin(GL2.GL_TRIANGLES);
        
        object.glColor3d(r,g,b);
        
        object.glVertex2d(0, 0);
        object.glVertex2d(0.1, 0);
        object.glVertex2d(0, 0.2);
        
        object.glEnd(); 
    }
    
    // Creates a 2d square
    public void createSquare(GL2 object, double r, double g, double b) {
        float[][] vertexArr = new float[][] {
            {0, 0},
            {0.1f, 0},
            {0.1f, 0.1f},
            {0, 0.1f}
        };
        
        object.glBegin(GL2.GL_TRIANGLE_FAN);
        
        object.glColor3d(r,g,b);
        
        object.glVertex2f(vertexArr[0][0], vertexArr[0][1]);
        object.glVertex2f(vertexArr[1][0], vertexArr[1][1]);
        object.glVertex2f(vertexArr[2][0], vertexArr[2][1]);
        object.glVertex2f(vertexArr[3][0], vertexArr[3][1]);
        
        object.glEnd();
    }
    
    // Creates a 2d trapazoid
    public void createTrapazoid(GL2 object, double r, double g, double b) {
        float[][] vertexArr = new float[][] {
            {0, 0},
            {0.1f, 0.1f},
            {0.2f, 0.1f},
            {0.3f, 0}
        };
        
        object.glBegin(GL2.GL_TRIANGLE_FAN);
        
        object.glColor3d(r,g,b);
        
        object.glVertex2f(vertexArr[0][0], vertexArr[0][1]);
        object.glVertex2f(vertexArr[1][0], vertexArr[1][1]);
        object.glVertex2f(vertexArr[2][0], vertexArr[2][1]);
        object.glVertex2f(vertexArr[3][0], vertexArr[3][1]);
        
        object.glEnd();
    }    
    
    // Creates a 3d cube
    public void createCube(GL2 object) {
        object.glBegin(GL2.GL_QUADS);
        
        // Color red
        object.glColor3d(1,0,0);
        
        // Draws the top of the cube
        object.glVertex3d(0.1,0.1,-0.1);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(0.1,0.1,0.1);
        
        // Color green
        object.glColor3d(0,1,0);
        
        // Draws the bottom of the cube
        object.glVertex3d(0.1,-0.1,0.1);
        object.glVertex3d(-0.1,-0.1,0.1);
        object.glVertex3d(-0.1,-0.1,-0.1);
        object.glVertex3d(0.1,-0.1,-0.1);
        
        // Color green
        object.glColor3d(0,0,1);
        
        // Draws the front of the cube
        object.glVertex3d(0.1,0.1,0.1);
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(-0.1,-0.1,0.1);
        object.glVertex3d(0.1,-0.1,0.1);
        
        // Brownish color
        object.glColor3d(0.5,0.5,0);
        
        // Draws the back of the cube
        object.glVertex3d(0.1,-0.1,-0.1);
        object.glVertex3d(-0.1,-0.1,-0.1);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(0.1,0.1,-0.1);
        
        // Light blue color
        object.glColor3d(0,1,1);
        
        // Draws the left side fo the cube
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(-0.1,-0.1,-0.1);
        object.glVertex3d(-0.1,-0.1,0.1);
        
        // Purple color
        object.glColor3d(1,0,1);
        
        // Draws the right side of the cube
        object.glVertex3d(0.1,0.1,-0.1);
        object.glVertex3d(0.1,0.1,0.1);
        object.glVertex3d(0.1,-0.1,0.1);
        object.glVertex3d(0.1,-0.1,-0.1);
        
        object.glEnd();
    }
    
    // Creates a 3d pyramid
    public void create3dTriangle(GL2 object) {
        object.glBegin(GL2.GL_TRIANGLES);
        
        object.glColor3d(1, 0, 0);
        
        object.glVertex3d(0.1, 0.2, 0);
        object.glVertex3d(-0.1, -0.1, 0.1);
        object.glVertex3d(0.1, -0.1, 0.1);
        
        object.glColor3d(0, 1, 0);
        
        object.glVertex3d(0.1, 0.2, 0);
        object.glVertex3d(0.1, -0.1, 0.1);
        object.glVertex3d(0.1, -0.1, -0.1);
        
        object.glColor3d(0, 0, 1);
        
        object.glVertex3d(0.1, 0.2, 0);
        object.glVertex3d(0.1, -0.1, -0.1);
        object.glVertex3d(-0.1, -0.1, -0.1);
        
        object.glColor3d(0.3, 0.3, 0.3);
        
        object.glVertex3d(0.1, 0.2, 0);
        object.glVertex3d(-0.1, -0.1, -0.1);
        object.glVertex3d(-0.1, -0.1, 0.1);
        
        object.glEnd();
    }
    
    // Creates a 3d house
    public void createHouse(GL2 object) {
        
        object.glBegin(GL2.GL_QUADS);
        
        // Color green
        object.glColor3d(0,1,0);
        
        // Draws the bottom of the house
        object.glVertex3d(0.1,-0.1,0.1);
        object.glVertex3d(-0.1,-0.1,0.1);
        object.glVertex3d(-0.1,-0.1,-0.1);
        object.glVertex3d(0.1,-0.1,-0.1);
        
        // Color green
        object.glColor3d(0,0,1);
        
        // Draws the front of the house
        object.glVertex3d(0.1,0.1,0.1);
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(-0.1,-0.1,0.1);
        object.glVertex3d(0.1,-0.1,0.1);
        
        // Brownish color
        object.glColor3d(0.5,0.5,0);
        
        // Draws the back of the house
        object.glVertex3d(0.1,-0.1,-0.1);
        object.glVertex3d(-0.1,-0.1,-0.1);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(0.1,0.1,-0.1);
        
        // Light blue color
        object.glColor3d(0,1,1);
        
        // Draws the left side fo the house
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(-0.1,-0.1,-0.1);
        object.glVertex3d(-0.1,-0.1,0.1);
        
        // Purple color
        object.glColor3d(1,0,1);
        
        // Draws the right side of the house
        object.glVertex3d(0.1,0.1,-0.1);
        object.glVertex3d(0.1,0.1,0.1);
        object.glVertex3d(0.1,-0.1,0.1);
        object.glVertex3d(0.1,-0.1,-0.1);
        
        
        // Color red
        object.glColor3d(1,0,0);
        
        // Draws the front piece of the roof
        object.glVertex3d(0.1,0.15,0);
        object.glVertex3d(-0.1,0.15,0);
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(0.1,0.1,0.1);
        
        // Color yellow
        object.glColor3d(1,1,0);
        
        // Draws the back piece of the roof
        object.glVertex3d(0.1,0.15,0);
        object.glVertex3d(-0.1,0.15,0);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(0.1,0.1,-0.1);
        
        object.glEnd();
        
        object.glBegin(GL.GL_TRIANGLES);
        
        // Color white
        object.glColor3d(1,1,1);
        
        // Draws the left side of the roof
        object.glVertex3d(-0.1,0.1,0.1);
        object.glVertex3d(-0.1,0.1,-0.1);
        object.glVertex3d(-0.1,0.15,0);
        
        // Color gray
        object.glColor3d(0.2,0.2,0.2);
        
        // Draws the left side of the roof
        object.glVertex3d(0.1,0.1,0.1);
        object.glVertex3d(0.1,0.1,-0.1);
        object.glVertex3d(0.1,0.15,0);
        
        object.glEnd();
    }
    
}
