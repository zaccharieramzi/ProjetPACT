package moduleIG;


import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainTest {

	public static void main(String[] args) {
		
			 // Instanciation d’une fenêtre.
			//todo
			 JFrame mainWindow = new JFrame("ma fenêtre");
		
			 // Ajout du comportement lorsque l'utilisateur click sur le bouton
			 // de fermeture de la fenêtre (bouton rouge sous Mac OS X).
			 mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
			
			 // Instanciation d'un bouton.
			 JButton button = new JButton("Hello World") ;
		 
			 // Ajout du bouton au panneau de la fenêtre.
			 Container defaultPanel = mainWindow.getContentPane() ;
			 defaultPanel.add(button) ;
			
			 // Centrage de la fenêtre par rapport à l'écran.
			 mainWindow.setLocationRelativeTo(null);
			 
			 // Redimensionnement selon les dimensions optimales spécifiées par les
			 // composants graphiques.
			 mainWindow.pack() ;
			 
			 // Affichage de la fenêtre. Bloque tant que la fenêtre n'est pas fermée !
			 mainWindow.setVisible(true) ;
			}

}
