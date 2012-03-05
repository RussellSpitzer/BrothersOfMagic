/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.OpenGL;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author MagRus
 */
public class GLUtil {

    public static void init2DOpenGL(int width, int height) {
        glEnable(GL_TEXTURE_2D);
        glDisable(GL_DEPTH_TEST);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, width, height, 0, -1, 1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        glViewport(0, 0, width, height);



    }

    public static void drawQuad(float x, float y, float width, float height, GLTexture tex) {
        glPushMatrix();
        glBindTexture(GL_TEXTURE_2D, tex.textureID);
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        {
            glTexCoord2f(0, 0);
            glVertex2f(0, 0);
            glTexCoord2f(0, tex.drawHeight);
            glVertex2f(0, height);
            glTexCoord2f(tex.drawWidth, tex.drawHeight);
            glVertex2f(width, height);
            glTexCoord2f(tex.drawWidth, 0);
            glVertex2f(width, 0);
        }
        glEnd();
        glPopMatrix();


    }
}
