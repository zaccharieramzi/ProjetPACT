package Jeu;

public class MouvementBalle {

	Balle balle;
	DecorInterface decor;
	Raquette raquetteP1;
	Raquette raquetteP2;
	Score score;
	double x;
	double y;
	double z;
	double dx;
	double dy;
	double alea=Math.random()*Math.PI*2;
	double dz;
	boolean balleStaysInTheField;


	public MouvementBalle(Balle balle, DecorInterface decor, Raquette raquetteP1, Raquette raquetteP2, Score score){
		this.balle=(Balle) balle;
		this.decor=decor;
		this.raquetteP1=raquetteP1;
		this.raquetteP2=raquetteP2;
		this.score=score;
		this.x=balle.getX();
		this.y=balle.getY();
		this.z=balle.getZ();
		this.dx=balle.getDx();
		this.dy=balle.getDy();
		this.dz=balle.getDz();
		this.balleStaysInTheField=decor.getBalleStaysInTheField();
	};
	public void deplace() {

		balle.move();
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
				balle.setDx(alea);
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
					balle.setDx(alea);
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

