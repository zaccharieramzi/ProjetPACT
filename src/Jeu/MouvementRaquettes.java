package Jeu;

public class MouvementRaquettes {

	Raquette raquette;
	DecorInterface decor;
	boolean balleStaysInTheField;
	public MouvementRaquettes(Raquette raquette,DecorInterface decor){

		this.raquette=raquette;
		this.decor=decor;
	}

	public void deplace(int j){


		if (j==1){
			raquette.move();
			if (raquette.isAtLimitsY(decor)){
				if (raquette.getY()<0){
					raquette.setY(-decor.getY()/2+raquette.getWidth()/2);
				}
				else{
					raquette.setY(decor.getY()/2-raquette.getWidth()/2);
				}
			}
		}
		else {
			raquette.setDy(-raquette.getDy());
			if (raquette.isAtLimitsY(decor)){
				if (raquette.getY()<0){
					raquette.setY(-decor.getY()/2+raquette.getWidth()/2);
				}
				else{
					raquette.setY(decor.getY()/2-raquette.getWidth()/2);
				}
			}
		}

				this.balleStaysInTheField=decor.getBalleStaysInTheField();

	}
}

