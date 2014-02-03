package moduleIG;

public interface BoutonInterface {

	String setText( String texteDuBouton);
	FenetreInterface setFenetreDAppartenance(FenetreInterface FenetreDAppartenance);
	FenetreInterface ouvertureFenetre(String typeFenetre);
	void envoiDInformationControleur();
	
}
