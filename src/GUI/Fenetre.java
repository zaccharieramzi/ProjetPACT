package GUI;

import Jeu.Controleur;
import Jeu.DecorInterface;
import Jeu.Manitou;

public class Fenetre implements FenetreInterface {
	
	private String titre;
	private Controleur controleur;
	

	@Override
	public String setText(String titreDeLaFenetre) {
		// TODO Auto-generated method stub
		this.titre=titreDeLaFenetre;
		return this.titre;
	}

	@Override
	public Controleur createJeu() {
		// TODO Auto-generated method stub
		Controleur controleurDuJeu= new  Manitou();
		this.controleur= controleurDuJeu;
		
		return this.controleur;
	}

	@Override
	public Controleur setControleur(Controleur controleur) {
		// TODO Auto-generated method stub
		this.controleur=controleur;
		return this.controleur;
	}

	@Override
	public BoutonInterface createBouton(String typeBouton) {
		// TODO Auto-generated method stub
		BoutonInterface bouton= new Bouton(typeBouton);
		return bouton;
	}

	@Override
	public FenetreInterface createFenetre(FenetreInterface fenetre,
			String typeFenetre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DecorInterface modifierDecor(DecorInterface decor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DecorInterface changerDecorPropose(DecorInterface decor) {
		// TODO Auto-generated method stub
		return null;
	}

}
