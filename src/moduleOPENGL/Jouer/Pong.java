package moduleOPENGL.Jouer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.input.Keyboard.*;


import org.lwjgl.opengl.Display;

import moduleOPENGL.Jouer.Texture;
import moduleOPENGL.Jouer.TexturedVBO;


public class Pong extends Game implements moduleIntegration.SetRaquetteDecoGuiAffichage 
{
	// The textures
	Texture ballTex, paddleTex, paddle2Tex;

	// The VBOs
	TexturedVBO ballVBO, paddle1VBO, paddle2VBO, backgroundVBO;

	// Objects
	GObject paddle1, paddle2, ball;

	private String variable1="paddle.png";
	public String getVariable1(){
		return variable1;
	}
	public String getVariable2(){
		return variable2;
	}
	private String variable2="background.png";

	
	public Pong(){
		
		
		this.variable1="paddle.png";
		this.variable2="background.png";
	}

	public void init()
	{
		
		Display.setTitle("PACT:Pong");
		

		// Initialize OpenGL
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();

		glMatrixMode(GL_MODELVIEW);
		glOrtho(0, 800, 600, 0, 1, -1);
		glViewport(0, 0, Display.getWidth(), Display.getHeight());

		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		//        @Override
		//    	public void setRaquette(int choixRaquette) {
		//    		// TODO Auto-generated method stub
		//        	if (choixRaquette==1) variable1 = "src/ImagesGUI/raquetteSport";// u gotta  update this I don't know your path
		//    		if (choixRaquette==2) variable1 = "src/ImagesGUI/raquetteSport";
		//    		if (choixRaquette==3) variable1 = "src/ImagesGUI/raquetteSport";
		//    		if (choixRaquette==4) variable1 = "src/ImagesGUI/raquetteSport";
		//    	}
		//
		//    	@Override
		//    	public void setDeco(int choixDeco) {
		//    		// TODO Auto-generated method stub
		//    		if (choixRaquette==1) variable2 = "src/ImagesGUI/raquetteSport"; // u gotta update this too
		//    		if (choixRaquette==2) variable2 = "src/ImagesGUI/raquetteSport";
		//    		if (choixRaquette==3) variable2 = "src/ImagesGUI/raquetteSport";
		//    		if (choixRaquette==4) variable2 = "src/ImagesGUI/raquetteSport";
		//    	}





		// Load textures
		ballTex = Texture.loadTexture("ball.png");
		paddleTex = Texture.loadTexture("paddle3.png");
		paddle2Tex = Texture.loadTexture("paddle2.png");


		// Create VBOs
		ballVBO = TexturedVBO.loadTexturedVBO(ballTex);
		paddle1VBO = TexturedVBO.loadTexturedVBO(paddleTex);
		paddle2VBO = TexturedVBO.loadTexturedVBO(paddle2Tex);

		// Load background and create resized background VBO
		Texture backTex = Texture.loadTexture("mer4.jpg");
		backTex.width = 800;
		backTex.height = 600;
		backgroundVBO = TexturedVBO.loadTexturedVBO(backTex);

		// Create objects
		paddle2 = new GObject(paddle2VBO, (800 - 128) / 2, 10);
		paddle1 = new GObject(paddle1VBO, (800 - 128) / 2, 600 - 16 - 10);
		ball = new GObject(ballVBO, (800 - 16) / 2, (600 - 16) / 2);

		// Set ball velocities
		ball.dy = Math.random() > 0.5 ? 4 : -4;
		ball.dx = Math.random() > 0.5 ? 4 : -4;
	}

	/**
	 * Update the game logic
	 */
	public void update(long elapsedTime)
	{


		

		


		// Escape ends the game
		if (isKeyDown(KEY_ESCAPE))
			end();

		// Auto move paddle2
		paddle2.x = ball.x - 128 / 2;

		// Move paddle1 with keyboard
		paddle1.dx = 0;

		if (isKeyDown(KEY_LEFT))
			paddle1.dx = (float) -20;

		if (isKeyDown(KEY_RIGHT))
			paddle1.dx = (float) +20;

		// Bounce ball when it hits paddles
		if (ball.bounds.intersects(paddle1.bounds) || ball.bounds.intersects(paddle2.bounds))
			ball.dy = -ball.dy;

		// Bounce ball when it hits window boundaries
		if (ball.x <= 0 || ball.x + ball.width >= 800)
			ball.dx = -ball.dx;

		// Move all the objects
		ball.move();
		paddle1.move();
		paddle2.move();

		// Fix paddle2 from moving outside window
		paddle2.x = Math.min(paddle2.x, 800 - 128);
		paddle2.x = Math.max(paddle2.x, 0);

		// Fix paddle1 from moving outside window
		paddle1.x = Math.min(paddle1.x, 800 - 128);
		paddle1.x = Math.max(paddle1.x, 0);

		// Reset ball if moved out
		if (ball.y + ball.height >= 600)
		{
			ball.x = (800 - 16) / 2;
			ball.y = (600 - 16) / 2;

			ball.dy = Math.random() > 0.5 ? 4 : -4;
			ball.dx = Math.random() > 0.5 ? 4 : -4;
		}
	}

	/**
	 * Render the game to screen
	 */
	public void render()
	{
		glClear(GL_COLOR_BUFFER_BIT);

		// Render the background
		backgroundVBO.render(0, 0);

		// Render the objects
		ball.render();
		paddle1.render();
		paddle2.render();
	}


	public void resized()
	{
		glViewport(0, 0, Display.getWidth(), Display.getHeight());
	}


	public void dispose()
	{
		paddle1VBO.dispose();
		paddle2VBO.dispose();
		ballVBO.dispose();
		backgroundVBO.dispose();
	}

	public static void main(String[] args)
	{
		Pong pong= new Pong();
		System.out.println(pong.getVariable1());
		System.out.println(pong.getVariable2());
		pong.setRaquette(2);
		pong.setDeco(3);
		pong.gameLoop();
	}

	@Override
	public void setRaquette(int choixRaquette) {
		// TODO Auto-generated method stub
		switch(choixRaquette){
		case 1 : this.variable1="paddle3.png"; break;
		case 2 : this.variable1="paddle3.png"; break;
		case 3 : this.variable1="paddle3.png"; break;
		case 4 : this.variable1="paddle3.png"; break;
		}
	}

	@Override
	public void setDeco(int choixDeco) {
		// TODO Auto-generated method stub
		switch(choixDeco){
		case 1: this.variable2 = "background.png"; break;
		case 2: this.variable2 = "background.png"; break;
		case 3: this.variable2 = "background.png"; break;
		case 4: this.variable2 = "background.png"; break;
		
		}

	}




}