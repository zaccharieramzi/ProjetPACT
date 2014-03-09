package Pong;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.*;
import org.lwjgl.opengl.*;

import entities.AbstractEntity;
import entities.AbstractMoveableEntity;


import static org.lwjgl.opengl.GL11.*;


public class PongGame {

	
	
	public static final int WIDTH=640;
	public static final int HEIGHT=480;
	private boolean isRunning= true;
	private Ball ball;
	private Bat bat1;
	private Bat bat2;
	public PongGame(){
		
		setUpDisplay();
		setUpOpenGL();
		setUpEntities();
		setUpTimer();
		while (isRunning){
			
			render();
			logic(getDelta());
			input();
			Display.update();
			Display.sync(60);
			
			if(Display.isCloseRequested()){
				isRunning=false;
			}
		}
		Display.destroy();
	}
	
	private void input() {
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
			bat1.setDY(-0.2);
			bat2.setDY(-0.2);
		} else if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			bat1.setDY(0.2);
			bat2.setDY(0.2);
		}else {
			bat1.setDY(0);
			bat2.setDY(0);
		}
	}

	private long lastFrame;
	
	private long getTime(){
		
		return(Sys.getTime()*1000);
	}
	
	private int getDelta() {
	long currentTime=getTime();
	int delta=(int)(currentTime- lastFrame);
	lastFrame=getTime();
	return delta;
	}

	private void setUpDisplay(){
		
		try{
			
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle("Pong");
			Display.create();
			
		} catch (LWJGLException e){
			e.printStackTrace();
		}
		
	}
	
	private void setUpOpenGL(){
		
		    GL11.glLoadIdentity();
	    
	        GL11.glOrtho(0,640,480,0,1,-1);

			glMatrixMode(GL_PROJECTION); // sets the matrix mode to project
			
			glMatrixMode(GL_MODELVIEW);
		
	}
	
	private void setUpEntities(){
		bat1=new Bat(10,HEIGHT/2-80/2,10,80);
		bat2=new Bat(WIDTH-50,HEIGHT/2-80/2,10,80);
		
		ball=new Ball(WIDTH/2-10/2,HEIGHT/2-10/2,10,10);
		
		ball.setDX(-.1);
	
		
		
	}
	
private void setUpTimer(){
	
	lastFrame=getTime();
		
	}
	
	private void render(){
		
		glClear(GL_COLOR_BUFFER_BIT);
		ball.draw();
		bat1.draw();
		bat2.draw();

	}
	
	private void logic(int delta){
		
		ball.update(delta);
		bat1.update(delta);
		bat2.update(delta);
		if(ball.getX()<=bat1.getX()+bat1.getWidth() && ball.getX()>= bat1.getX() && ball.getY()>=bat1.getY() && ball.getY()<=bat1.getY()+bat1.getHeight()){
			
			ball.setDX(0.3);
		}
		
        if(ball.getX()<=bat2.getX()+bat2.getWidth() && ball.getX()>= bat2.getX() && ball.getY()>=bat2.getY() && ball.getY()<=bat2.getY()+bat2.getHeight()){
			
			ball.setDX(0.3);
		}
		
	}
	
	private static class Bat extends AbstractMoveableEntity {
		public Bat(double x, double y, double width, double height) {
	
			super(x, y, width, height);
			
		}

	
	@Override

	public void draw(){
		
		glRectd(x,y,x+width,y+height);
	}

	}
	private static class Ball extends AbstractMoveableEntity {
		
		public Ball(double x,double y,double width,double height){
			
			super(x,y,width,height);
	
		}
	
	
	@Override
	
	public void draw(){
		
		glRectd(x,y,x+width,y+height);
	}

	
	}
	public static void main(String[] args){
		
		new PongGame();
	}
}
