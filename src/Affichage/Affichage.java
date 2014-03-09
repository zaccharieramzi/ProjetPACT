package Affichage;

import java.util.Date;
import java.util.GregorianCalendar;

import Jeu.Balle;
import Jeu.Manitou;
import moduleIntegration.SetRaquetteDecoGuiAffichage;


// cette classe contient des methodes qui vont etre appelees par GUI pour lui donner le décor et la raquette choisis 


public class Affichage implements SetRaquetteDecoGuiAffichage {
	
	private String chemin = "data\\ReproductionEXEC" ;
	private String message = "";
	GregorianCalendar calendar = new GregorianCalendar();
	Date time  = calendar.getTime();
	//message = message+"matrice du descripteur envoyée à Classif  " + time;
	
	//creer un constructeur permettant de créer un écran d'affichage (il est utilisé par ex dans la classe fenetre
	//pour appeler ses methodes setDeco et setRaquette
	
	public Affichage(){
		super();
	}

	public void setRaquette(int choixRaquette) {
		// TODO Auto-generated method stub	
		
		//là il doit prendre la raquette choisie et l'adapter dans l'ecran
		
	}

	public void setDeco(int choixDeco) {
		// TODO Auto-generated method stub
		
		//là il doit prendre l'image du déco et le mettre dans l'ecran
		//après il affiche l'ecran et le jeu commence 
	}

	public void afficher(){
		Manitou manitou = new Manitou();
		Balle balle = manitou.getBalle();
		System.out.println(balle.getX()+"  "+balle.getY()+"  "+balle.getZ()+"  ");
		manitou.getRaquetteP1();
		System.out.println("j'ai reçu la raquette");
	}
	
}
