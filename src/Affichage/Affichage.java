package Affichage;

import moduleIntegration.SetRaquetteDecoGuiAffichage;


// cette classe contient des methodes qui vont �tre appelees par GUI pour lui donner le d�cor et la raquette choisis 


public class Affichage implements SetRaquetteDecoGuiAffichage {
	
	//cr�er un constructeur permettant de cr�er un �cran d'affichage (il est utilis� par ex dans la classe fenetre
	//pour appeler ses methodes setDeco et setRaquette
	
	public Affichage(){
		super();
	}

	public void setRaquette(int choixRaquette) {
		// TODO Auto-generated method stub
		System.out.println("raquette=" +choixRaquette);
	}

	public void setDeco(int choixDeco) {
		// TODO Auto-generated method stub
		System.out.println("deco="+choixDeco);
	}

}
