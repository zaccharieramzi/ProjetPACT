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
	private int directionP1;
	private int directionP2;
	private double alea=Math.random()*Math.PI*2;
	private Balle balle = new Balle(1,0,0,0,alea,speed,1);
	private Raquette raquetteP1=new Raquette(-decor.getX()/2,0,0,speed,5);
	private Raquette raquetteP2=new Raquette(decor.getX()/2,0,0,speed,5);
	private Score score=new Score(0,0);
	private MouvementBalle laBalle;
	private MouvementRaquettes lesRaquettes;
	private boolean pause;



	public void mettreEnPause_Reprendre(){
		this.pause= !pause;
		System.out.println("Je mets le jeu en pause");
	}
	@Override
	public void lancerJeu() throws InterruptedException {
		// TODO Auto-generated method stub

		while (score.limiteAtteinte(10)){
			laBalle= new MouvementBalle(balle, decor, raquetteP1, raquetteP2, score );
			lesRaquettes = new MouvementRaquettes(raquetteP1, raquetteP2, decor, directionP1, directionP2);
			while(decor.getBalleStaysInTheField()&&!pause){
				laBalle.run();
				lesRaquettes.run();
			}


		}

	}

	@Override
	public void setDirectionP1(int direction) {
		// TODO Auto-generated method stub
		this.directionP1=direction;
	}
	@Override
	public void setDirectionP2(int direction) {
		// TODO Auto-generated method stub
		this.directionP2=direction;
	}
	@Override
	public void setSpeed(int vitesse) {
		// TODO Auto-generated method stub
		this.speed=vitesse;
	}

	@Override
	public Balle getBalle() {
		// TODO Auto-generated method stub
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
