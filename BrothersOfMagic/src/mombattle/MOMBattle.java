/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle;

import mombattle.units.Character;
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

            if (Mouse.isButtonDown(0)) {
                gameRunning = false;
            
            }

        }
    }
}
