/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.OpenGL;

import static org.lwjgl.opengl.GL11.*; // Put Opengl in this namespace

/**
 *
 * @author MagRus
 */
public class GLTexture {
    
    public int textureID;
    public int textureWidth=2;
    public int textureHeight=2;
    public float actualHeight=0;
    public float actualWidth=0;
    public float drawHeight;
    public float drawWidth;
    public int minFilter=GL_LINEAR;
    public int magFilter=GL_LINEAR;
    
 

    

}
