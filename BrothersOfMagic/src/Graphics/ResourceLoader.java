/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author MagRus
 */
public class ResourceLoader {
    
    
    
    public BufferedImage loadImage (String path) throws IOException{
        java.net.URL imgUrl = getClass().getResource(path);
        if (imgUrl==null) {
            throw new IOException("Couldn't Find Image at "+path);
        }
        return ImageIO.read(imgUrl);
        
        
        
    }
    
}
