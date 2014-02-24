package GUI;

import javax.swing.JButton;

public class Bouton implements BoutonInterface {

	private String titre;
	private JButton bouton;
	
	public Bouton(String titreDuBouton){
		this.titre=titreDuBouton;
		JButton leBouton = new JButton(this.titre);
		this.bouton=leBouton;
	}
	@Override
	public String setText(String titreDuBouton) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FenetreInterface setFenetre(FenetreInterface fenetre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void isClicked(FenetreInterface fenetre) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public JButton getJButton() {
		// TODO Auto-generated method stub
		return this.bouton;
	}

}
