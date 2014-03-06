
import static org.lwjgl.opengl.GL11.GL_AMBIENT_AND_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_COLOR_MATERIAL;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_DIFFUSE;
import static org.lwjgl.opengl.GL11.GL_FRONT;
import static org.lwjgl.opengl.GL11.GL_LEQUAL;
import static org.lwjgl.opengl.GL11.GL_LIGHT0;
import static org.lwjgl.opengl.GL11.GL_LIGHTING;
import static org.lwjgl.opengl.GL11.GL_LIGHT_MODEL_AMBIENT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_NICEST;
import static org.lwjgl.opengl.GL11.GL_PERSPECTIVE_CORRECTION_HINT;
import static org.lwjgl.opengl.GL11.GL_POSITION;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_SHININESS;
import static org.lwjgl.opengl.GL11.GL_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_SPECULAR;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glClearDepth;
import static org.lwjgl.opengl.GL11.glColorMaterial;
import static org.lwjgl.opengl.GL11.glDepthFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glHint;
import static org.lwjgl.opengl.GL11.glLight;
import static org.lwjgl.opengl.GL11.glLightModel;
import static org.lwjgl.opengl.GL11.glMaterial;
import static org.lwjgl.opengl.GL11.glMaterialf;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glShadeModel;

import java.awt.PageAttributes.ColorType;
import java.io.FileInputStream;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.Color;
import org.lwjgl.util.WritableColor;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Project;
import org.lwjgl.util.glu.GLU.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GLContext;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class cube {

    private boolean do_run=true; //runs until done is set to true
    private int display_width = 640;
    private int display_height = 480;
        
    private static final int WIDTH = 800, HEIGHT = 600;
	private static final DisplayMode DISPLAY_MODE = new DisplayMode(WIDTH, HEIGHT);
	private static final String WINDOW_TITLE = "cubeTest";
	private static final int FPS = 70;	//frames per second
	
	private boolean isRunning;	//variable to tell if program is running or not
	private float zTranslation = -12f;
	
	//----------- Variables added for Lighting Test -----------//
	private FloatBuffer matSpecular;
	private FloatBuffer lightPosition;
	private FloatBuffer whiteLight; 
	private FloatBuffer lModelAmbient;
   

    //�  partir des exercices 3.1
    private int vertex_vbo_id = 0;
    private int color_vbo_id = 0;
    private int index_vbo_id = 0;
    private int nb_indices = 0;
    private boolean use_vbo = false; 
    private boolean use_shader = false; 
    
    private int program;
    private int vertexShader;
    private int fragmentShader;    

    
    public cube() {
    }

	private static FloatBuffer makeFloatBuffer(float[] values)
	{
		FloatBuffer buffer = BufferUtils.createFloatBuffer(values.length);
		buffer.put(values);
		buffer.flip();
		return buffer;
	}


    public void Run(){
        initDisplay();
        
        initGL();
        
        initShaders();
        
        while(do_run){
            if(Display.isCloseRequested())
                do_run=false;
            
            render();
            
            Display.update();
        }
        
        Display.destroy();
    }
    
    
    private void render(){
    //   float w, h;
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);        
    
    
        if (use_vbo) {
            cube_vbo();
        } else {
            cube();
        }
   
    }
    
    private void initDisplay(){    
        try{
            //Creation d'une fenetre permettant de dessiner avec OpenGL
            Display.setDisplayModeAndFullscreen(new DisplayMode(display_width, display_height) );
            Display.create();
            
            DisplayMode mode = Display.getDisplayMode();
        }catch(Exception e){
            System.out.println("Error setting up display: "+ e.getMessage());
            System.exit(0);
        }
    }
    
    private void initGL(){    
        /*GL viewport: nous utilisons toute la fenetre pour dessiner*/
        GL11.glViewport(0, 0, display_width, display_height);
        /*Matrice de projection (3D vers 2D): utilisation d'une projection en ortho*/
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        // D�but Modif depuis le d�but
       
        //Project.gluLookAt(5,5,-5,-5,-5,4,-10,5,10);
        GL11.glOrtho(-8.0, 8.0, -8.0, 8.0, -8.0, 8.0);
        
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);		glClearDepth(1.0f); // clear depth buffer
		glEnable(GL_DEPTH_TEST); // Enables depth testing
		glDepthFunc(GL_LEQUAL); // sets the type of test to use for depth testing
		glMatrixMode(GL_PROJECTION); // sets the matrix mode to project
		
		//float fovy = 45.0f;
		//float aspect = DISPLAY_MODE.getWidth() / (float)DISPLAY_MODE.getHeight();
		//float zNear = 0.01f;
		//100.0f
		//float zFar = 100.0f;
		//GLU.gluPerspective(fovy, aspect, zNear, zFar);
		
		glMatrixMode(GL_MODELVIEW);
		
		glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); 
		
		//----------- Variables & method calls added for Lighting Test -----------//
		initLightArrays();
		glShadeModel(GL_SMOOTH);
		glMaterial(GL_FRONT, GL_SPECULAR, matSpecular);				// sets specular material color
		glMaterialf(GL_FRONT, GL_SHININESS, 50.0f);					// sets shininess
		
		glLight(GL_LIGHT0, GL_POSITION, lightPosition);				// sets light position
		glLight(GL_LIGHT0, GL_SPECULAR, whiteLight);				// sets specular light to white
		glLight(GL_LIGHT0, GL_DIFFUSE, whiteLight);					// sets diffuse light to white
		glLightModel(GL_LIGHT_MODEL_AMBIENT, lModelAmbient);		// global ambient light 
		
		glEnable(GL_LIGHTING);										// enables lighting
		glEnable(GL_LIGHT0);										// enables light0
		
		glEnable(GL_COLOR_MATERIAL);								// enables opengl to use glColor3f to define material color
		glColorMaterial(GL_FRONT, GL_AMBIENT_AND_DIFFUSE);			// tell opengl glColor3f effects the ambient and diffuse properties of material
		//----------- END: Variables & method calls added for Lighting Test -----------//
    }
     
 
    private void initLightArrays() {
		matSpecular = BufferUtils.createFloatBuffer(4);
		matSpecular.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();
		
		lightPosition = BufferUtils.createFloatBuffer(4);
		lightPosition.put(1.0f).put(1.0f).put(1.0f).put(0.0f).flip();
		
		whiteLight = BufferUtils.createFloatBuffer(4);
		whiteLight.put(1.0f).put(1.0f).put(1.0f).put(1.0f).flip();
		
		lModelAmbient = BufferUtils.createFloatBuffer(4);
		lModelAmbient.put(0.5f).put(0.5f).put(0.5f).put(1.0f).flip();
	}
    
   private void cube (){

	   
	   float x = 0;
	   
	   GL11.glColor3f(1, 0, 0);
       GL11.glRotatef(x+=0.08f, 1, 1, 1);

       GL11.glBegin(GL11.GL_QUADS);
       GL11.glColor3f(0.0f,1.0f,0.0f);          // Set The Color To Green
       GL11.glVertex3f( 1.0f, 1.0f,-1.0f);          // Top Right Of The Quad (Top)
       GL11.glVertex3f(-1.0f, 1.0f,-1.0f);          // Top Left Of The Quad (Top)
       GL11.glVertex3f(-1.0f, 1.0f, 1.0f);          // Bottom Left Of The Quad (Top)
       GL11.glVertex3f( 1.0f, 1.0f, 1.0f);          // Bottom Right Of The Quad (Top)
       GL11.glColor3f(1.0f,0.5f,0.0f);          // Set The Color To Orange
       GL11.glVertex3f( 1.0f,-1.0f, 1.0f);          // Top Right Of The Quad (Bottom)
       GL11.glVertex3f(-1.0f,-1.0f, 1.0f);          // Top Left Of The Quad (Bottom)
       GL11.glVertex3f(-1.0f,-1.0f,-1.0f);          // Bottom Left Of The Quad (Bottom)
       GL11.glVertex3f( 1.0f,-1.0f,-1.0f);          // Bottom Right Of The Quad (Bottom)
       GL11.glColor3f(1.0f,0.0f,0.0f);          // Set The Color To Red
       GL11.glVertex3f( 1.0f, 1.0f, 1.0f);          // Top Right Of The Quad (Front)
       GL11.glVertex3f(-1.0f, 1.0f, 1.0f);          // Top Left Of The Quad (Front)
       GL11.glVertex3f(-1.0f,-1.0f, 1.0f);          // Bottom Left Of The Quad (Front)
       GL11.glVertex3f( 1.0f,-1.0f, 1.0f);          // Bottom Right Of The Quad (Front)
       GL11.glColor3f(1.0f,1.0f,0.0f);          // Set The Color To Yellow
       GL11.glVertex3f( 1.0f,-1.0f,-1.0f);          // Bottom Left Of The Quad (Back)
       GL11.glVertex3f(-1.0f,-1.0f,-1.0f);          // Bottom Right Of The Quad (Back)
       GL11.glVertex3f(-1.0f, 1.0f,-1.0f);          // Top Right Of The Quad (Back)
       GL11.glVertex3f( 1.0f, 1.0f,-1.0f);          // Top Left Of The Quad (Back)
       GL11.glColor3f(0.0f,0.0f,1.0f);          // Set The Color To Blue
       GL11.glVertex3f(-1.0f, 1.0f, 1.0f);          // Top Right Of The Quad (Left)
       GL11.glVertex3f(-1.0f, 1.0f,-1.0f);          // Top Left Of The Quad (Left)
       GL11.glVertex3f(-1.0f,-1.0f,-1.0f);          // Bottom Left Of The Quad (Left)
       GL11.glVertex3f(-1.0f,-1.0f, 1.0f);          // Bottom Right Of The Quad (Left)
       GL11.glColor3f(1.0f,0.0f,1.0f);          // Set The Color To Violet
       GL11.glVertex3f( 1.0f, 1.0f,-1.0f);          // Top Right Of The Quad (Right)
       GL11.glVertex3f( 1.0f, 1.0f, 1.0f);          // Top Left Of The Quad (Right)
       GL11.glVertex3f( 1.0f,-1.0f, 1.0f);          // Bottom Left Of The Quad (Right)
       GL11.glVertex3f( 1.0f,-1.0f,-1.0f);          // Bottom Right Of The Quad (Right)
       GL11.glEnd();
      
       
       
  }

   
    private void cube_vbo()
    {
        load_cube_vbo();      
        draw_vbos();
    }
   
  
    private static String getLogInfo(int obj) {
        return ARBShaderObjects.glGetInfoLogARB(obj, ARBShaderObjects.glGetObjectParameteriARB(obj, ARBShaderObjects.GL_OBJECT_INFO_LOG_LENGTH_ARB));
    }
    
    public static int createVBOID() {
      if (GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
        IntBuffer buffer = BufferUtils.createIntBuffer(1);
        ARBVertexBufferObject.glGenBuffersARB(buffer);
        return buffer.get(0);
      }
      return 0;
    }
    
    private int load_float_vbo(float [] values)
    {
      //chargeons les données dans un FloatBuffer
  		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(values.length);
	   	verticesBuffer.put(values);
	   	verticesBuffer.flip(); //NE PAS OUBLIER CETTE LIGNE!! ELLE PEUT CRASHER VOTRE JavaVM
      
      //creons un VBO dans la mémoire du GPU (pas encore de données associées))
      int vbo_id = createVBOID();
      
      //et copions les données dans la mémoire du GPU
  		if(GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
        ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB, vbo_id);
        ARBVertexBufferObject.glBufferDataARB(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB, verticesBuffer, ARBVertexBufferObject.GL_STATIC_DRAW_ARB);
      } else {
        System.out.println("VBOs NOT SUPPORTED !!");
      }
      return vbo_id;
    }
    
    private int load_index_vbo(int [] values)
    {
      //chargeons les données dans un IntBuffer
  		IntBuffer indicesBuffer = BufferUtils.createIntBuffer(values.length);
	   	indicesBuffer.put(values);
	   	indicesBuffer.flip(); //NE PAS OUBLIER CETTE LIGNE!! ELLE PEUT CRASHER VOTRE JavaVM
      
      //creons un VBO dans la mémoire du GPU (pas encore de données associées))
      int vbo_id = createVBOID();
      
      //et copions les données dans la mémoire du GPU
  		if(GLContext.getCapabilities().GL_ARB_vertex_buffer_object) {
        ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ELEMENT_ARRAY_BUFFER_ARB, vbo_id);
        ARBVertexBufferObject.glBufferDataARB(ARBVertexBufferObject.GL_ELEMENT_ARRAY_BUFFER_ARB, indicesBuffer, ARBVertexBufferObject.GL_STATIC_DRAW_ARB);
      } else {
        System.out.println("VBOs NOT SUPPORTED !!");
      }
      
      //souvenons nous du nombre d'index dans notre VBO:
      nb_indices = values.length;      
      return vbo_id;
    }
    
    
    private void draw_vbos() {
      if (vertex_vbo_id==0) return;
      if (index_vbo_id==0) return;
      
      if (use_shader) {
        ARBShaderObjects.glUseProgramObjectARB(program);
      }
      
      GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
      ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB, vertex_vbo_id);
      GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, 0);

      if (color_vbo_id != 0) {
        GL11.glEnableClientState(GL11.GL_COLOR_ARRAY);
        ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB, color_vbo_id);
        GL11.glColorPointer(4, GL11.GL_FLOAT, 0, 0);
      }

      //attachons le buffer d'indices comme le buffer 'ELEMENT_ARRAY', i.e. celui utilisé pour glDrawElements
      ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ELEMENT_ARRAY_BUFFER_ARB, index_vbo_id);
  		
      GL11.glDrawElements(GL11.GL_TRIANGLES, nb_indices, GL11.GL_UNSIGNED_INT, 0);

      GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
      if (color_vbo_id != 0) GL11.glDisableClientState(GL11.GL_COLOR_ARRAY);

      if (use_shader) {
        ARBShaderObjects.glUseProgramObjectARB(0);
      }
    }
   private void load_cube_vbo() {
        //nous avons déja crée le VBO, inutile de recommencer ...
        if (vertex_vbo_id != 0) return;

        //creons un VBO qui contient nos vertex - nous avons besoin de 3 sommets
     
        float[] vertices = new float[] {
        		
        		   -1, -1, -1,
        		   1, -1, -1,
        		   1, 1, -1,
        		   -1, 1, -1,
        		   -1, 1, 1,
        		   -1, -1, 1,
        		   1, -1, 1,
        		   1, -1, -1,
        		   
        		   
        		    1, 1, 1,
        		   1, 1, -1,
        		   -1, 1, -1,
        		   -1, 1, 1,
        		   -1, -1, 1,
        		   1, -1, 1,
        		   1, -1, -1,
        		   1, 1, -1,
        
        		
           };
        
    
        		    
       
        vertex_vbo_id = load_float_vbo(vertices);
        
        //creons un VBO qui contient les index des sommets dans les deux triangles de notre cube
        int[] indices = new int[]
        {
          0,1,2
        };
        index_vbo_id = load_index_vbo(indices);

        System.out.println("VBOs Setup - Vertex ID " + vertex_vbo_id + " - index ID " + index_vbo_id + " - nb indices " + nb_indices);
      }
    
    //
    //  Shader init
    //
    private void initShaders() {
        /*init openGL shaders*/
        program = ARBShaderObjects.glCreateProgramObjectARB();
        if (program==0) {
            System.out.println("Error: OpenGL shaders not supported");
            System.exit(0);
        }
        vertexShader=ARBShaderObjects.glCreateShaderObjectARB(ARBVertexShader.GL_VERTEX_SHADER_ARB);
        String vertexCode=""+
        "void main(void)" + 
        "{" + 
        "	gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;" +  
        "}";
        
        ARBShaderObjects.glShaderSourceARB(vertexShader, vertexCode);
        ARBShaderObjects.glCompileShaderARB(vertexShader);
        if (ARBShaderObjects.glGetObjectParameteriARB(vertexShader, ARBShaderObjects.GL_OBJECT_COMPILE_STATUS_ARB) == GL11.GL_FALSE)
        {
            System.out.println("Vertex shader not compiled: " + getLogInfo(vertexShader) );
        }
        
        fragmentShader=ARBShaderObjects.glCreateShaderObjectARB(ARBFragmentShader.GL_FRAGMENT_SHADER_ARB);
        String fragmentCode="" +
        "void main(void) {" +
        "	gl_FragColor = vec4 (0.0, 1.0, 0.0, 1.0);" +
        "}";
        
        ARBShaderObjects.glShaderSourceARB(fragmentShader, fragmentCode);
        ARBShaderObjects.glCompileShaderARB(fragmentShader);
        if (ARBShaderObjects.glGetObjectParameteriARB(fragmentShader, ARBShaderObjects.GL_OBJECT_COMPILE_STATUS_ARB) == GL11.GL_FALSE)
        {
            System.out.println("Fragment shader not compiled: " + getLogInfo(fragmentShader) );
        }
        
        
        ARBShaderObjects.glAttachObjectARB(program, vertexShader);
        ARBShaderObjects.glAttachObjectARB(program, fragmentShader);
        ARBShaderObjects.glLinkProgramARB(program);
        ARBShaderObjects.glValidateProgramARB(program);
    }
    
    
    
    public static void main(String[] args){
        cube app = new cube();
        /*parse our args*/
        for (int i=0; i<args.length; i++) {
            if (args[i].equals("-vbo")) {
                app.use_vbo = true;
            }
            else if (args[i].equals("-shader")) {
                app.use_shader = true;
            }
        }
        
        app.Run();
    }    
    
}


