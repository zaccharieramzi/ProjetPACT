package GUI;

public interface BoutonInterface {
	
	String setText(String titreDuBouton);
	FenetreInterface createFenetre(String titreDeLaFenetre);
	void fermerFenetre(FenetreInterface fenetre);
	

}
