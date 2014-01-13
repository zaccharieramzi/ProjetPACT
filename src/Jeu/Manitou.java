package Jeu;
import java.io.InputStream;
import java.util.Scanner;


public class Manitou implements Controleur {

	public Manitou() {
		super();
		// TODO Auto-generated constructor stub
	}
	private TableDePingPong decor=new TableDePingPong(10,6,0);
	private int speed=1;
	private double alea=Math.random()*Math.PI*2;
	private Balle balle = new Balle(0,0,0,0,alea,speed,1);
	private Raquette raquetteP1=new Raquette(-decor.getX()/2,0,0,speed,5);
	private Raquette raquetteP2=new Raquette(decor.getX()/2,0,0,speed,5);
	private Score score=new Score(0,0);
	
	
	
	@Override
	public void refresh() throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (score.limiteAtteinte(10)){
			
	
			int j = 0;
			
			System.out.println("Choisissez votre direction : 1 pour aller à droite , 0 pour aller à gauche!");
			j=sc.nextInt();
			calculatePositions(j,1);
			Thread.sleep(500);
		}
		sc.close();
	}
	@Override
	public void calculatePositions(int j1, int j2)/*j1 indique la direction donnée par le joueur 1 et j2 par le joueur 2. 
	Je commence par dire que 0 c'est gauche et 1 c'est droite.*/ {
		// TODO Auto-generated method stub

		if (j1==1){
			double y = raquetteP1.getY();
			raquetteP1.setY(y-raquetteP1.getSpeed());
			if (raquetteP1.isAtLimitsY(decor)){
				if (y<0){
					raquetteP1.setY(-decor.getY()/2+raquetteP1.getWidth()/2);
				}
				else{
					raquetteP1.setY(decor.getY()/2-raquetteP1.getWidth()/2);
				}
			}
		}
		else {
			double y = raquetteP1.getY();
			raquetteP1.setY(y+raquetteP1.getSpeed());
			if (raquetteP1.isAtLimitsY(decor)){
				if (y<0){
					raquetteP1.setY(-decor.getY()/2+raquetteP1.getWidth()/2);
				}
				else{
					raquetteP1.setY(decor.getY()/2-raquetteP1.getWidth()/2);
				}
			}
		}

		if (j2==1){
			double y = raquetteP2.getY();
			raquetteP2.setY(y-raquetteP2.getSpeed());
			if (raquetteP2.isAtLimitsY(decor)){
				if (y<0){
					raquetteP2.setY(-decor.getY()/2+raquetteP2.getWidth()/2);
				}
				else{
					raquetteP2.setY(decor.getY()/2-raquetteP2.getWidth()/2);
				}
			}
		}
		else {
			double y = raquetteP2.getY();
			raquetteP2.setY(y+raquetteP2.getSpeed());
			if (raquetteP2.isAtLimitsY(decor)){
				if (y<0){
					raquetteP2.setY(-decor.getY()/2+raquetteP2.getWidth()/2);
				}
				else{
					raquetteP2.setY(decor.getY()/2-raquetteP2.getWidth()/2);
				}
			}
		}
		double x=balle.getX();
		double y=balle.getY();
		double z=balle.getZ();
		double theta=balle.getAngleTheta();
		double phi = balle.getAnglePhi();
		int speed= balle.getSpeed();
		balle.setX(x+speed*Math.sin(theta)*Math.cos(phi));
		balle.setY(y+speed*Math.sin(theta)*Math.sin(phi));
		balle.setZ(z+speed*Math.cos(theta));
		if (balle.isAtLimitsX(decor)){
			decor.Rebond(balle);
		}
		if (balle.isAtLimitsZ(decor)){
			decor.Rebond(balle);
		}
		
		if (balle.isAtLimitsY(decor)){
			if (x<0){
				if (balle.staysInTheField(raquetteP1)){
					raquetteP1.Rebond(balle);
				}
				else { 
					alea=Math.random()*Math.PI*2;
					int i=score.getP2Score();
					score.setP2Score(i+1);
					System.out.println("La balle est sortie est et le joueur 2 a gagné un point");
					balle.reInitialize();
					balle.setAnglePhi(alea);
					/*FIN DE LA MANCHE*/
				}
			}
			else {
				if (balle.staysInTheField(raquetteP2)){
					raquetteP2.Rebond(balle);
				}
				else { 
					alea=Math.random()*Math.PI*2;
					int i=score.getP1Score();
					score.setP1Score(i+1);
					System.out.println("La balle est sortie est et le joueur 1 a gagné un point, son score est de "+score.getP1Score());
					balle.reInitialize();
					balle.setAnglePhi(alea);
					System.out.println("Voilà le nouvel angle choisi "+alea);
					/*FIN DE LA MANCHE*/
				}
			}
		}
		
	}

	

}
