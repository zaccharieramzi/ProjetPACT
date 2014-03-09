package moduleIG;

import moduleOPENGL.Jouer.Pong;
import Jeu.Manitou;

public class MainTestIG {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manitou manitou= new Manitou();
		Pong pong= new Pong();
		FenetreAffichage menu = new FenetreAffichage(manitou, pong); 
		menu.show();
	}

}
