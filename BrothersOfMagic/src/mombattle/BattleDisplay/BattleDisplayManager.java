/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mombattle.BattleDisplay;

import Graphics.OpenGL.GLTextureLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mombattle.MOMBattle;
import mombattle.units.BaseUnit;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
/**
 *
 * @author MagRus
 */
public class BattleDisplayManager {
    public int BD_WIDTH;
    public int BD_HEIGHT;
    
    public ArrayList<BaseUnit> unitDrawList = null;
    public GLTextureLoader myLoader= new GLTextureLoader();
   
    
    public void createDisplay(int width, int height){
        BD_WIDTH=width;
        BD_HEIGHT=height;
         try {
            // TODO code application logic here
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(MOMBattle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //Todo change this to read from XML or something scalable
    //TODO we should be doing Pallet swaps to change our team colors
    public void loadTextures(){
        try{
            
        
        myLoader.loadTexture("/resources/BlueKnightSmall.jpg", "BlueKnightSmall");
        myLoader.loadTexture("/resources/BlueSoldierSmall.jpg", "BlueSoldierSmall");
        myLoader.loadTexture("/resources/RedKnightSmall.jpg", "RedKnightSmall");
        myLoader.loadTexture("/resources/Rock.jpg", "Rock");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        
    }
    
    public void init(boolean createDisplay){
        if (createDisplay) createDisplay(630,480);
        glEnable(GL_TEXTURE_2D);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, BD_WIDTH, BD_HEIGHT, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glViewport(0, 0, BD_WIDTH, BD_HEIGHT);
        
        // Texture loading
        loadTextures();
        
    }
   public void draw(){
       glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
       if (unitDrawList!=null){
           for (int i=0; i < unitDrawList.size(); i++){
               drawUnit(unitDrawList.get(i));
               
           }
           
           
       }
       
       Display.update(); /// Keyboard and mouse polling is here
       Display.sync(60);
   }

   public void drawUnit(BaseUnit unit){
        glPushMatrix();
        glBindTexture(GL_TEXTURE_2D, unit.sprite.textureID);
        //Todo this should be grid positions or something
        glTranslatef(unit.battleMapX, unit.battleMapY, 0);
        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 0);
            glVertex2f(0, 0);
            
            glTexCoord2f(0, unit.sprite.drawHeight);
            glVertex2f(0, unit.sprite.actualHeight);
            
            glTexCoord2f(unit.sprite.drawWidth, unit.sprite.drawHeight);
            glVertex2f(unit.sprite.actualWidth, unit.sprite.actualHeight);
            
            glTexCoord2f(unit.sprite.drawWidth, 0);
            glVertex2f(unit.sprite.actualWidth, 0);
        }
        glEnd();
        glPopMatrix();
       
   }
   
   
   
}

