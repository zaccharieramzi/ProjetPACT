package moduleIG;

public interface BoutonInterface {

	String setText( String texteDuBouton);
	FenetreInterface setFenetreDAppartenance(FenetreInterface fenetreDAppartenance);
	FenetreInterface setFenetrePrincipale(FenetreInterface fenetrePrincipale);
	BoutonInterface creerBouton(String typeBouton);
	void supprimerBouton(BoutonInterface boutonASupprimer);
	void fermetureFenetre(FenetreInterface fenetreAFermer);
	FenetreInterface ouvertureFenetre(String typeFenetre);
	void envoiDInformationControleur();
	
}
