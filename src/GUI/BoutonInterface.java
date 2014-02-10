package GUI;

public interface BoutonInterface {
	
	String setText(String titreDuBouton);
	FenetreInterface createFenetre(String titreDeLaFenetre);
	void fermerFenetre(FenetreInterface fenetre);
	void mettreFenetrePrincipaleEnRetrait(FenetreInterface fenetrePrincipale);
	String envoyerMessageAFenetrePrincipale(String message);
	void passerDecor(String direction);
	

}
