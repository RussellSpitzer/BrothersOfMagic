/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.OpenGL;

import Graphics.ResourceLoader;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Hashtable;
import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
/**
 *
 * @author MagRus
 */
public class GLTextureLoader {
    
     private ColorModel glAlphaColorModel; 
      private ColorModel glColorModel; 

    public GLTextureLoader() {
        glAlphaColorModel= new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
           new int[] {8,8,8,8},
            true,
            false,
            ComponentColorModel.TRANSLUCENT,
            DataBuffer.TYPE_BYTE);

        glColorModel= new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
           new int[] {8,8,8,0},
            false,
            false,
            ComponentColorModel.OPAQUE,
            DataBuffer.TYPE_BYTE);
    }
    
    
    
    public static HashMap<String,GLTexture> textureMap = new HashMap<String, GLTexture>();
    
   
    
    private IntBuffer textureIDBuffer = BufferUtils.createIntBuffer(1);
    private int createOpenGLTexture(){
        glGenTextures(textureIDBuffer);
        return textureIDBuffer.get(0);
    }
    
    public GLTexture loadTexture (String path, String name) throws IOException{
        GLTexture tex = textureMap.get(name);
        if (tex != null) return tex;
        ResourceLoader rl= new ResourceLoader();
        tex = createTexture(name,rl.loadImage(path));
            System.out.println(
                    "Loaded "+name+" from "+path+"\n"
                    + "Height ="+tex.textureHeight+" Width="+tex.textureWidth+"\n"
                    + "TexID " + tex.textureID);
            
         org.lwjgl.opengl.Util.checkGLError();
        return tex;

        
        
    }
    
    private GLTexture createTexture(String textureName, BufferedImage textureImage)
    {
        GLTexture newTexture = new GLTexture();
        ByteBuffer imageData= convertImageToBytes(textureImage,newTexture); 
        //System.out.println(imageData.toString());
        //for (int x=0; x< imageData.capacity(); x+=3){
        //    System.out.println(imageData.get(x)+","+imageData.get(x+1)+","+imageData.get(x+2));
       // }
        newTexture.textureID=createOpenGLTexture();
        glBindTexture(GL_TEXTURE_2D, newTexture.textureID);
         org.lwjgl.opengl.Util.checkGLError();
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, newTexture.minFilter);
        glTexParameteri(GL_TEXTURE_2D,GL_TEXTURE_MAG_FILTER, newTexture.magFilter);
         org.lwjgl.opengl.Util.checkGLError();
        glTexImage2D(GL_TEXTURE_2D,
                0,
                GL_RGBA,
                newTexture.textureWidth, 
                newTexture.textureHeight,
                0,
                (textureImage.getColorModel().hasAlpha())?GL_RGBA:GL_RGB,
                GL_UNSIGNED_BYTE, 
                imageData);
    
         org.lwjgl.opengl.Util.checkGLError();
        textureMap.put(textureName,newTexture);
        
        return newTexture;
    }
    
    
    private ByteBuffer convertImageToBytes (BufferedImage inputImage, GLTexture tex){
        //First we need to make sure the BufferedImage is a power of 2 if not we make a larger canvas and draw to that
        tex.actualWidth=inputImage.getWidth();
        tex.actualHeight=inputImage.getHeight();
        
        while (inputImage.getWidth()> tex.textureWidth)
            tex.textureWidth*=2;
        while (inputImage.getHeight()> tex.textureHeight)
            tex.textureHeight*=2;
        
        tex.drawHeight=(tex.actualHeight/tex.textureHeight);
        tex.drawWidth=(tex.actualWidth/tex.textureWidth);
        
        
        // Next we use a raster to convert a Buffered image into byte data
        WritableRaster raster;
           BufferedImage twoSizedImage;
           if (inputImage.getColorModel().hasAlpha()){
          raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, 
                tex.textureWidth, 
                tex.textureHeight, 
                4,
                null);
        //Make the 2Fold version of the image attached to the new raster
         twoSizedImage = new BufferedImage(glAlphaColorModel,
                raster,
                false,
                new Hashtable());}
           else
           {
                raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, 
                tex.textureWidth, 
                tex.textureHeight, 
                3,
                null);
        //Make the 2Fold version of the image attached to the new raster
         twoSizedImage = new BufferedImage(glColorModel,
                raster,
                false,
                new Hashtable());
           }
        
        //Clear the twoSizedImage 
        Graphics g = twoSizedImage.getGraphics();
        g.setColor(new Color(0f,0f,0f,0f));
        g.fillRect(0, 0, tex.textureWidth, tex.textureHeight);
        //Now draw the input image into the twosized image;
        g.drawImage(inputImage, 0, 0, null);
        
        //Grab the byte version of the image data
        byte[] imageData = ((DataBufferByte)(twoSizedImage).getRaster().getDataBuffer()).getData();
        
        ByteBuffer imageBuffer = ByteBuffer.allocateDirect(imageData.length);
        imageBuffer.order(ByteOrder.nativeOrder()); //Make sure we don't do any endian nonsense
        imageBuffer.put(imageData);
        imageBuffer.flip(); //Puts the write head of the buffer back to the beginning keeping this position as length
        
        return imageBuffer;
        
        
        
        
        
    }
}
