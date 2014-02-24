package Jeu;

public class MouvementRaquettes implements Runnable {
	
	RaquetteInterface raquetteP1;
	RaquetteInterface raquetteP2;
	DecorInterface decor;
	int j1;
	int j2;
	public MouvementRaquettes(RaquetteInterface raquetteP1,RaquetteInterface raquetteP2,DecorInterface decor){
		
		this.raquetteP1=raquetteP1;
		this.raquetteP2=raquetteP2;
		this.decor=decor;
	}
	
	public void run(){
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
	
	}

}
