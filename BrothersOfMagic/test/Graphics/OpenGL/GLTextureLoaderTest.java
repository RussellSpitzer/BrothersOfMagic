/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphics.OpenGL;

import java.awt.image.BufferedImage;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author MagRus
 */
public class GLTextureLoaderTest {
    
    public GLTextureLoaderTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTexture method, of class GLTextureLoader.
     */
    @Test
    public void testCreateTexture() {
        System.out.println("createTexture");
        String textureName = "";
        BufferedImage textureImage = null;
        GLTextureLoader instance = new GLTextureLoader();
        GLTexture expResult = null;
        //GLTexture result = instance.createTexture(textureName, textureImage);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
