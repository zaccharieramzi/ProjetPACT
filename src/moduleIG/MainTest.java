package moduleIG;


import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainTest {

	public static void main(String[] args) {
		
			 // Instanciation d�une fen�tre.
			//todo
			 JFrame mainWindow = new JFrame("ma fenetre");
		
			 // Ajout du comportement lorsque l'utilisateur click sur le bouton
			 // de fermeture de la fen�tre (bouton rouge sous Mac OS X).
			 mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
			
			 // Instanciation d'un bouton.
			 JButton button = new JButton("Hello World") ;
		 
			 // Ajout du bouton au panneau de la fen�tre.
			 Container defaultPanel = mainWindow.getContentPane() ;
			 defaultPanel.add(button) ;
			
			 // Centrage de la fen�tre par rapport � l'�cran.
			 mainWindow.setLocationRelativeTo(null);
			 
			 // Redimensionnement selon les dimensions optimales sp�cifi�es par les
			 // composants graphiques.
			 mainWindow.pack() ;
			 
			 // Affichage de la fen�tre. Bloque tant que la fen�tre n'est pas ferm�e !
			 mainWindow.setVisible(true) ;
			}

}
