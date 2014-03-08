
			import java.io.FileInputStream;
			import java.io.IOException;
			import java.util.logging.Level;
			import java.util.logging.Logger;
			import org.lwjgl.LWJGLException;
			import org.lwjgl.Sys;
			import org.lwjgl.opengl.Display;
			import org.lwjgl.opengl.DisplayMode;
			import org.lwjgl.opengl.GL11;
			import org.lwjgl.util.glu.GLU;
			import org.newdawn.slick.opengl.Texture;
			import org.newdawn.slick.opengl.TextureLoader;
			/**
			*
			* @author Java Guy
			*/
			public class TextureExample {
			private static boolean gameRunning=true;
			private static int targetWidth = 800;
			private static int targetHeight = 600;
			private float xrot=0.1f;
			private float yrot=0.1f;
			private float zrot=0.1f;
			/** The texture that's been loaded */
			private Texture texture;
			public static void main(String[] args){
			TextureExample app=new TextureExample();
			

			}
			
			private static boolean initGL(){
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			// Calculate the aspect ratio of the window
			GLU.gluPerspective(45.0f,((float)targetWidth)/((float)targetHeight),0.1f,100.0f);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			GL11.glLoadIdentity();
			GL11.glEnable(GL11.GL_TEXTURE_2D);	 // Enable Texture Mapping ( NEW )
			GL11.glShadeModel(GL11.GL_SMOOTH);
			GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			GL11.glClearDepth(1.0f);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDepthFunc(GL11.GL_LEQUAL);
			GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
			return true;
			}
			private void init(){
			try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream("C:/Users/FATIMATA/Desktop/Nouveau dossier/zey.jpg"));
			} catch (IOException ex) {
			Logger.getLogger(TextureExample.class.getName()).log(Level.SEVERE, null, ex);
			}
			}
			private void run(){
			while(gameRunning){
			update();

			Display.update();
			// finally check if the user has requested that the display be
			// shutdown
			if (Display.isCloseRequested()) {
			gameRunning = false;
			Display.destroy();
			System.exit(0);
			}
			}
			}
			private void update(){
			xrot+=0.1f;
			yrot+=0.1f;
			zrot+=0.1f;
			}
			private void render(){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glLoadIdentity();
			GL11.glTranslatef(0.0f,0.0f,-5.0f);	 // Move Into The Screen 5 Units
			GL11.glRotatef(xrot,1.0f,0.0f,0.0f);	 // Rotate On The X Axis
			GL11.glRotatef(yrot,0.0f,1.0f,0.0f);	 // Rotate On The Y Axis
			GL11.glRotatef(zrot,0.0f,0.0f,1.0f);	 // Rotate On The Z Axis
			texture.bind(); // or GL11.glBind(texture.getTextureID());
			GL11.glBegin(GL11.GL_QUADS);
			// Front Face
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f(-1.0f, -1.0f, 1.0f);	// Bottom Left Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f( 1.0f, -1.0f, 1.0f);	// Bottom Right Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f( 1.0f, 1.0f, 1.0f);	// Top Right Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);	// Top Left Of The Texture and Quad
			// Back Face
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f(-1.0f, -1.0f, -1.0f);	// Bottom Right Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f(-1.0f, 1.0f, -1.0f);	// Top Right Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f( 1.0f, 1.0f, -1.0f);	// Top Left Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f( 1.0f, -1.0f, -1.0f);	// Bottom Left Of The Texture and Quad
			// Top Face
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f(-1.0f, 1.0f, -1.0f);	// Top Left Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);	// Bottom Left Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f( 1.0f, 1.0f, 1.0f);	// Bottom Right Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f( 1.0f, 1.0f, -1.0f);	// Top Right Of The Texture and Quad
			// Bottom Face
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f(-1.0f, -1.0f, -1.0f);	// Top Right Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f( 1.0f, -1.0f, -1.0f);	// Top Left Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f( 1.0f, -1.0f, 1.0f);	// Bottom Left Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f(-1.0f, -1.0f, 1.0f);	// Bottom Right Of The Texture and Quad
			// Right face
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f( 1.0f, -1.0f, -1.0f);	// Bottom Right Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f( 1.0f, 1.0f, -1.0f);	// Top Right Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f( 1.0f, 1.0f, 1.0f);	// Top Left Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f( 1.0f, -1.0f, 1.0f);	// Bottom Left Of The Texture and Quad
			// Left Face
			GL11.glTexCoord2f(0.0f, 0.0f);
			GL11.glVertex3f(-1.0f, -1.0f, -1.0f);	// Bottom Left Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 0.0f);
			GL11.glVertex3f(-1.0f, -1.0f, 1.0f);	// Bottom Right Of The Texture and Quad
			GL11.glTexCoord2f(1.0f, 1.0f);
			GL11.glVertex3f(-1.0f, 1.0f, 1.0f);	// Top Right Of The Texture and Quad
			GL11.glTexCoord2f(0.0f, 1.0f);
			GL11.glVertex3f(-1.0f, 1.0f, -1.0f);	// Top Left Of The Texture and Quad
			GL11.glEnd();
			}
			}