package GUI;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

import Jeu.Controleur;
import Jeu.DecorInterface;
import Jeu.Manitou;

public class Fenetre implements FenetreInterface {
	
	private String titre;
	private Controleur controleur;
	private JFrame fenetre;
	

	public Fenetre(String titreDeLaFenetre){
		this.titre=titreDeLaFenetre;
		JFrame mainwindow= new JFrame(this.titre);
		this.fenetre=mainwindow;
		fenetre.setLocationRelativeTo(null);
		fenetre.setVisible(true);
		Manitou manitou = new Manitou();
		this.controleur = manitou;
	}
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
		JButton leBouton=bouton.getJButton();
		Container defaultPanel = this.fenetre.getContentPane() ;
		 defaultPanel.add(leBouton) ;

		return bouton;
	}

	@Override
	public FenetreInterface createFenetre(String typeFenetre) {
		// TODO Auto-generated method stub
		Fenetre fenetre = new Fenetre(typeFenetre);
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
