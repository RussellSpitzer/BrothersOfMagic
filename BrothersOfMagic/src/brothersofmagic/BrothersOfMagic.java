/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package brothersofmagic;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;


/** 
 *
 * @author MagRus
 */
public class BrothersOfMagic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("POOP");
        try {
            Display.create();
              
              // TODO code application logic here
        } catch (LWJGLException ex) {
            Logger.getLogger(BrothersOfMagic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
