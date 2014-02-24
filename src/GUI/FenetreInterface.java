package GUI;

import Jeu.Controleur;
import Jeu.DecorInterface;

public interface FenetreInterface {
	
	String setText(String titreDeLaFenetre);
	Controleur createJeu();
	BoutonInterface createBouton(BoutonInterface bouton, String typeBouton);
	FenetreInterface createFenetre(FenetreInterface fenetre, String typeFenetre);
	DecorInterface modifierDecor(DecorInterface decor);
	
	
	
}
