package moduleIntegration;

public interface IGControleurInterface {
	
	
	void setMode(int mode);
	//donne au controleur le mode de jeu choisi
	
	
	//setSpeed represente la difficulte choisie
	void setSpeed(int vitesse);
	void mettreEnPause_Reprendre();

	
	void lancerJeu() throws InterruptedException;

}
