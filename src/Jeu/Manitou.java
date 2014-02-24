package Jeu;
import java.io.InputStream;
import java.util.Scanner;


public class Manitou implements Controleur {

	public Manitou() {
		super();
		// TODO Auto-generated constructor stub
	}
	private DecorInterface decor=new TableDePingPong(10,6,0);
	private int speed=1;
	private double alea=Math.random()*Math.PI*2;
	private Balle balle = new Balle(0,0,0,0,alea,speed,1);
	private Raquette raquetteP1=new Raquette(-decor.getX()/2,0,0,speed,5);
	private Raquette raquetteP2=new Raquette(decor.getX()/2,0,0,speed,5);
	private Score score=new Score(0,0);
	private MouvementBalle laBalle;
	private MouvementRaquettes lesRaquettes;
	
	
	
	@Override
	public void refresh() throws InterruptedException {
		// TODO Auto-generated method stub
		
		while (score.limiteAtteinte(10)){
			laBalle= new MouvementBalle(balle, decor, raquetteP1, raquetteP2, score );
			lesRaquettes = new MouvementRaquettes( raquetteP1, raquetteP2, decor);
			new Thread(laBalle).start();
			new Thread(lesRaquettes).start();
			
			
			
		}
		
	}
	@Override
	public void setDecor(DecorInterface decor) {
		// TODO Auto-generated method stub
		this.decor= decor;
	}

	

}
