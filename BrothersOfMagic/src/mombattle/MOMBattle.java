/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import Graphics.OpenGL.GLTexture;
import Graphics.OpenGL.GLUtil;
import Graphics.OpenGL.GLTextureLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.lwjgl.input.Mouse;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Andrew
 */
public class MOMBattle {

    static int WIDTH = 640;
    static int HEIGHT = 580;
    static boolean gameRunning = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(MOMBattle.class.getName()).log(Level.SEVERE, null, ex);
        }

        GLUtil.init2DOpenGL(WIDTH, HEIGHT);
        GLTexture test = null;
        GLTextureLoader myLoader = new GLTextureLoader();
        try {
            test =myLoader.loadTexture("/resources/BlueKnightSmall.png", "BlueKnight");
          //  test =myLoader.loadTexture("/resources/RedKnightSmall.jpg", "RedKnight");
        } catch (IOException ex) {
            Logger.getLogger(MOMBattle.class.getName()).log(Level.SEVERE, null, ex);
        }


        Character bob1 = new Character(10, 5, 4, 1, 100, 5, 9, "/resources/BlueKnightSmall.jpg");
        Character bob2 = new Character(10, 5, 2, 1, 100, 4, 9, "/resources/BlueSoldierSmall.jpg");
        Character tim1 = new Character(10, 5, 2, 1, 1, 4, 0, "/resources/RedKnightSmall.jpg");
        Character tim2 = new Character(10, 5, 2, 1, 1, 5, 0, "/resources/RedKnightSmall.jpg");
        Character tim3 = new Character(10, 5, 2, 1, 1, 6, 0, "/resources/RedKnightSmall.jpg");
        Character[] player = {bob1, bob2};
        Character[] computer = {tim1, tim2, tim3};
        BattleGraphics battle = new BattleGraphics(player, computer);


        while (gameRunning) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            GLUtil.drawQuad((float)Mouse.getX(), HEIGHT-(float)Mouse.getY(), 100,100,test);
            battle.drawScreen();
             //org.lwjgl.opengl.Util.checkGLError();
           
            if (Mouse.isButtonDown(0)) gameRunning=false;

        }
        







    }
}
