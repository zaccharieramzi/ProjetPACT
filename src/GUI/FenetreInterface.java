package GUI;

import Jeu.Controleur;
import Jeu.DecorInterface;

public interface FenetreInterface {
	
	String setText(String titreDeLaFenetre);
	Controleur createJeu();
	Controleur setControleur(Controleur controleur);
	BoutonInterface createBouton(String typeBouton);
	FenetreInterface createFenetre(String typeFenetre);
	DecorInterface modifierDecor(DecorInterface decor);
	DecorInterface changerDecorPropose(DecorInterface decor);
	
	
	
}
