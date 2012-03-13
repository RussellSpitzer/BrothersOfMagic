/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import mombattle.units.ArmyUnit;
import Graphics.OpenGL.GLTexture;
import Graphics.OpenGL.GLUtil;
import Graphics.OpenGL.GLTextureLoader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import mombattle.BattleDisplay.BattleDisplayManager;
import org.lwjgl.input.Mouse;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author Andrew
 */
public class MOMBattle {

    static int WIDTH = 630;
    // This height is different than the one used in BattleDisplayManager, I don't know why but I am changing it to match.
    // It was 580 now its 480.
    static int HEIGHT = 480;
    static boolean gameRunning = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    new MOMBattle().run();
    
    }

    BattleDisplayManager bdm = new BattleDisplayManager();
    BattleManager bm = new BattleManager();

    long nextFrameStart;
    
    public MOMBattle() {
    }

    public void run() {
        bdm.init(true);
        bm.init();
    
        bdm.unitDrawList=bm.currUnits;
        while (gameRunning) {

            bdm.draw();
           
            
            //org.lwjgl.opengl.Util.checkGLError();
    
            //Play the game with the mouse button.
            if (Mouse.isButtonDown(0)) {
                
                int mX = Mouse.getX() - Mouse.getX()%30; int mY = HEIGHT - (30 + Mouse.getY() - Mouse.getY()%30);
                try {
                bm.play(mX, mY);
                } catch (NullPointerException e)
                {
                    System.out.println("No unit selected");
                }

            }
            
            // To exit press ESC key
            if (Keyboard.isKeyDown(1))
            {
             gameRunning = false;   
            }           

        }
    }
}
