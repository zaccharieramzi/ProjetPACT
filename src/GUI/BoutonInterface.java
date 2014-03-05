package GUI;

import javax.swing.JButton;

public interface BoutonInterface {
	
	String setText(String titreDuBouton);
	FenetreInterface setFenetre(FenetreInterface fenetre);
	void isClicked(FenetreInterface fenetre);	
	JButton getJButton();

}
