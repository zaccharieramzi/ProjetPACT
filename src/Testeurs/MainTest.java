package Testeurs;

import Jeu.Manitou;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Manitou manitou = new Manitou();
		DirectionGiver testeur = new DirectionGiver(manitou);
		testeur.show();
		try {
			manitou.lancerJeu();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
