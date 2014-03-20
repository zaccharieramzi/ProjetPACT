package moduleIntegration;

import Jeu.Balle;
import Jeu.Raquette;
import Jeu.Score;

public interface GetPositionOfRaquetteBalleAffichageCon {
	
	Balle getBalle();
	Raquette getRaquetteP1();
	Raquette getRaquetteP2();
	Score getScore();
	String getState(); //Les différents états que j'imaginais étaient "En pause", "En jeu", "Fin de partie"
}
