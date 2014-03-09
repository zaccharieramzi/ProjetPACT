package Jeu;

public class MouvementBalle implements Runnable {

	Balle balle;
	DecorInterface decor;
	RaquetteInterface raquetteP1;
	RaquetteInterface raquetteP2;
	ScoreInterface score;
	double x;
	double y;
	double z;
	double theta;
	double phi;
	double alea=Math.random()*Math.PI*2;;
	int speed;
	boolean balleStaysInTheField;


	public MouvementBalle(BalleInterface balle, DecorInterface decor, RaquetteInterface raquetteP1, RaquetteInterface raquetteP2, ScoreInterface score){
		this.balle=(Balle) balle;
		this.decor=decor;
		this.raquetteP1=raquetteP1;
		this.raquetteP2=raquetteP2;
		this.score=score;
		this.x=balle.getX();
		this.y=balle.getY();
		this.z=balle.getZ();
		this.theta=balle.getAngleTheta();
		this.phi=balle.getAnglePhi();
		this.speed=balle.getSpeed();
		this.balleStaysInTheField=decor.getBalleStaysInTheField();
	};
	public void run() {
//System.out.println("C'est bon");
		balle.setX(x+(1/100)*speed*Math.sin(theta)*Math.cos(phi));
		balle.setY(y+(1/100)*speed*Math.sin(theta)*Math.sin(phi));
		balle.setZ(z+(1/100)*speed*Math.cos(theta));
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
				else { this.decor.setBalleStaysInTheField(false);
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
					this.decor.setBalleStaysInTheField(false);
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
			try {
				Thread.sleep(41);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

