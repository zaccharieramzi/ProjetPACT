package Jeu;
import moduleIntegration.*;


public class Manitou implements SetDirectionInterfaceClassifCon, GetPositionOfRaquetteBalleAffichageCon,
IGControleurInterface{

	public Manitou() {
		super();
		// TODO Auto-generated constructor stub
	}
	private DecorInterface decor=new TableDePingPong(10,6,0);
	private int speed=1;
	private double alea=Math.random()*Math.PI*2;
	private Balle balle = new Balle(1,0,0,0,alea,speed,1);
	private Raquette raquetteP1=new Raquette(-decor.getX()/2,0,0,decor.getY()/2);
	private Raquette raquetteP2=new Raquette(decor.getX()/2,0,0,decor.getY()/2);
	private Score score=new Score(0,0);
	private MouvementBalle laBalle;
	private MouvementRaquettes laRaquette1=new MouvementRaquettes(raquetteP1,decor);
	private MouvementRaquettes laRaquette2=new MouvementRaquettes(raquetteP2,decor);
	private String state;



	public void mettreEnPause_Reprendre(){
		if (this.state=="En pause"){this.state="En jeu";}
		else{this.state="En pause";}
	}
	public Score getScore(){
		return this.score;
	}
		@Override
	public void setDirectionP1(int direction) {
		// TODO Auto-generated method stub
		this.laRaquette1.deplace(direction);
	}
	@Override
	public void setDirectionP2(int direction) {
		// TODO Auto-generated method stub
		this.laRaquette2.deplace(direction);
	}
	@Override
	public void setSpeed(int vitesse) {
		// TODO Auto-generated method stub
		this.speed=vitesse;
	}
	public String getState(){
		return this.state;
	}
	@Override
	public Balle getBalle() {
		// TODO Auto-generated method stub
		laBalle.deplace();
		return this.balle;
	}

	@Override
	public Raquette getRaquetteP1() {
		// TODO Auto-generated method stub
		return this.raquetteP1;
	}

	@Override
	public Raquette getRaquetteP2() {
		// TODO Auto-generated method stub
		return this.raquetteP2;
	}

	@Override
	public void setMode(int mode) {
		// TODO Auto-generated method stub

	}

	// Il faut rajouter des setters et getters concernant les 4 differents décors et les 4 différents types de raquette

}
