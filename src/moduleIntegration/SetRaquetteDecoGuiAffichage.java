package moduleIntegration;

//cet interface implémentée dans Affichage permettra à GUI d'envoyer la déco et la raquette choisis à Affichage

public interface SetRaquetteDecoGuiAffichage {
	
	void setRaquette(int choixRaquette);
	void setDeco(int choixDeco);

}
