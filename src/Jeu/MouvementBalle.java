package Jeu;

public class MouvementBalle {

	Balle balle;
	DecorInterface decor;
	RaquetteInterface raquetteP1;
	RaquetteInterface raquetteP2;
	ScoreInterface score;
	double x=balle.getX();
	double y=balle.getY();
	double z=balle.getZ();
	double theta=balle.getAngleTheta();
	double phi = balle.getAnglePhi();
	double alea;
	int speed= balle.getSpeed();
	
	public MouvementBalle(BalleInterface balle, DecorInterface decor, RaquetteInterface raquetteP1, RaquetteInterface raquetteP2, ScoreInterface score){
		this.balle=(Balle) balle;
		this.decor=decor;
		this.raquetteP1=raquetteP1;
		this.raquetteP2=raquetteP2;
		this.score=score;
	};
	
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
