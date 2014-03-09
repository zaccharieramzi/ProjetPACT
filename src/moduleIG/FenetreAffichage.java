package moduleIG;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Affichage.Affichage;
import Jeu.Manitou;

import java.awt.Container;

import javax.swing.*;

import moduleIntegration.ReproduireExec;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class FenetreAffichage {

	private  JFrame fenetre;
	private  Manitou manitou;
	public  boolean RIGHT_TO_LEFT = false;
	private  JPanel panneau;
	public void show(){
	this.addComponentsToPane(panneau);
	this.fenetre.pack();
	this.fenetre.setLocationRelativeTo(null);
	this.fenetre.setVisible(true);
	
	// les deux lignes suivantes font parties de l'intégration du système permettant la reproduction d'une execution
	
	}
	private Affichage ecran;
	private String chemin = "data\\ReproductionEXEC";
	private String message = "NOUVEAU JEU: \n";
	

	public FenetreAffichage(){	
		this.fenetre= new JFrame("Menu principal");
		this.manitou= new Manitou();
		this.ecran = new Affichage();
		 panneau = (JPanel) fenetre.getContentPane();
		
	}
	
	protected void setIcon(JButton button, String iconPath)
	  {
	    ImageIcon icon = new ImageIcon(iconPath) ;

	    // Dimensionne le bouton selon la taille de l'icône.
	    button.setPreferredSize(new Dimension(icon.getIconWidth(), icon
	          .getIconHeight())) ;
	    // Habille le bouton de l'icône.
	    button.setIcon(icon) ;
	  }


	public void addComponentsToPane(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton buttonFacile = new JButton();
		String facilePath = "src/ImagesGUI/facile.jpg";
		setIcon(buttonFacile, facilePath);
		buttonFacile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(1);
				message=message+"Speed envoyée : 1(FACILE)\n";
				//ReproduireExec.ecrire(chemin, message);
			}
			
		});
		pane.add(buttonFacile, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		
		
		JButton buttonNormal = new JButton();
//		buttonNormal.setPreferredSize(new Dimension(200, 100));	
		String NormalPath = "src/ImagesGUI/normal.jpg";
		setIcon(buttonNormal, NormalPath);
		buttonNormal.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(2);
				message=message+"Speed envoyée : 2(NORMAL)\n";
				//ReproduireExec.ecrire(chemin, message);
			};
		});
		pane.add(buttonNormal, BorderLayout.CENTER);

		JButton buttonDifficile = new JButton();
		String difficilePath = "src/ImagesGUI/difficile.jpg";
		setIcon(buttonDifficile, difficilePath);
		
		buttonDifficile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(3);
				message=message+"Speed envoyée : 1(DIFFICILE)\n";
				//ReproduireExec.ecrire(chemin, message);
			};
		});
		pane.add(buttonDifficile, BorderLayout.LINE_START);

		JButton buttonExpert = new JButton("Expert");
		String expertPath = "src/ImagesGUI/expert.jpg";
		setIcon(buttonExpert, expertPath);
		
		buttonExpert.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(4);
				message=message+"Speed envoyée : 4(EXPERT)\n";
				//ReproduireExec.ecrire(chemin, message);
			};
		});
		pane.add(buttonExpert, BorderLayout.LINE_END);
		
		//go to STEP 2	
		JButton buttonValider = new JButton();
		String step2Path = "src/ImagesGUI/step2.jpg";
		setIcon(buttonValider, step2Path);
		
		buttonValider.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				panneau.removeAll();
				fenetre.setTitle("Mode de jeu");
				addComponentsToPane2(panneau);
				fenetre.repaint();
				fenetre.pack();
//				panneau.repaint();
			};
		});
		pane.add(buttonValider, BorderLayout.PAGE_END);
	}

	public void addComponentsToPane2(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton buttonFacile = new JButton("J1vsJ2");
		
		
		buttonFacile.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
			//Un setter pourrait servir

			public void mouseClicked(MouseEvent e){
				manitou.setMode(1);
				message=message+"Mode envoyé : 1(J1vsJ2)\n";
				//ReproduireExec.ecrire(chemin, message);
			}
		});
		pane.add(buttonFacile, BorderLayout.LINE_END);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.

		JButton buttonNormal = new JButton("J1vsIA");
		buttonNormal.setPreferredSize(new Dimension(200, 100));
		buttonNormal.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
			//Un setter pourrait servir       

			public void mouseClicked(MouseEvent e){
				message=message+"Mode envoyé : 2(J1vsIA)\n";
				//ReproduireExec.ecrire(chemin, message);
			}
		});
		pane.add(buttonNormal, BorderLayout.CENTER);

		JButton buttonDifficile = new JButton("J1&J2vsIA");
		buttonDifficile.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
			//Un setter pourrait servir

			public void mouseClicked(MouseEvent e){
				message=message+"Mode envoyé : 3(J1&J2vsIA)\n";
				//ReproduireExec.ecrire(chemin, message);
			}
		});
		pane.add(buttonDifficile, BorderLayout.LINE_START);


		//go to STEP3
		JButton buttonJouer = new JButton();
		String step3Path = "src/ImagesGUI/step3.jpg";
		setIcon(buttonJouer, step3Path);
		
		buttonJouer.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				panneau.removeAll();
				fenetre.setTitle("Decor");
				addComponentsToPane3(panneau);
				fenetre.repaint();
				fenetre.pack();
//				panneau.repaint();
				
			}
		});
		pane.add(buttonJouer, BorderLayout.PAGE_END);



	}


	public void addComponentsToPane3(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}
			//DECOR1
		JButton buttonFirst = new JButton();
		String iconPath1 = "src/ImagesGUI/pelouse.jpg";
		setIcon(buttonFirst, iconPath1);
		
		buttonFirst.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){

				//ce n'est pas au controleur qu'il faut donner la dï¿½co mais ï¿½ affichage
				//manitou.setDeco(1);

				ecran.setDeco(1);
				message=message+"Deco envoyée: 1 \n";
				//ReproduireExec.ecrire(chemin, message);
				
				

			}
		});
		pane.add(buttonFirst, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		
		//DECOR2
		JButton buttonSecond = new JButton();
//		buttonSecond.setPreferredSize(new Dimension(200, 100));
		
		String iconPath2 = "src/ImagesGUI/ocean.jpg";
		setIcon(buttonSecond, iconPath2);
		
		buttonSecond.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(2);
				ecran.setDeco(2);
				message=message+"Deco envoyée: 2 \n";
				//ReproduireExec.ecrire(chemin, message);
				
			}
		});
		pane.add(buttonSecond, BorderLayout.CENTER);

		
		//DECOR3
		JButton buttonThird = new JButton();
		String iconPath3 = "src/ImagesGUI/jungle.jpg";
		setIcon(buttonThird, iconPath3);
		
		buttonThird.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(3);
				ecran.setDeco(3);
				message=message+"Deco envoyée: 3 \n";
				//ReproduireExec.ecrire(chemin, message);
				
			}
		});
		pane.add(buttonThird, BorderLayout.LINE_START);

		
		//DECOR4
		JButton buttonFourth = new JButton();
		String iconPath4 = "src/ImagesGUI/newYork.jpg";
		setIcon(buttonFourth, iconPath4);
		
		buttonFourth.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(4);
				ecran.setDeco(4);
				message=message+"Deco envoyée: 4 \n";
				//ReproduireExec.ecrire(chemin, message);
			
			}
		});
		pane.add(buttonFourth, BorderLayout.LINE_END);
		
		//go to step4
		//il faut renommer ce bouton
		JButton buttonJouer = new JButton();
		String step4Path = "src/ImagesGUI/step4.jpg";
		setIcon(buttonJouer, step4Path);
		
		buttonJouer.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				panneau.removeAll();
				fenetre.setTitle("Raquette");
				addComponentsToPane4(panneau);
				fenetre.repaint();
				fenetre.pack();
//				panneau.repaint();
			}
		});
		pane.add(buttonJouer, BorderLayout.PAGE_END);



	}


	public void addComponentsToPane4(Container pane) {

		if (!(pane.getLayout() instanceof BorderLayout)) {
			pane.add(new JLabel("Container doesn't use BorderLayout!"));
			return;
		}

		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(
					java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}
		
		//raquette 1
		JButton buttonFirst = new JButton();
		String iconPath1 = "src/ImagesGUI/raquetteSport.jpg";
		setIcon(buttonFirst, iconPath1);
		
		buttonFirst.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(1);
				ecran.setRaquette(1);
				message=message+"Raquette envoyée: 1 \n";
				//ReproduireExec.ecrire(chemin, message);
		
			}
		});
		pane.add(buttonFirst, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		
		//raquette 2
		JButton buttonSecond = new JButton();
		String iconPath2 = "src/ImagesGUI/requin.jpg";
		setIcon(buttonSecond, iconPath2);
		
//		buttonSecond.setPreferredSize(new Dimension(200, 100));
		buttonSecond.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(2);
				ecran.setRaquette(2);
				message=message+"Raquette envoyée: 2 \n";
				ReproduireExec.ecrire(chemin, message);
				
			}
		});
		pane.add(buttonSecond, BorderLayout.CENTER);
		
		//raquette 3
		JButton buttonThird = new JButton();
		String iconPath3 = "src/ImagesGUI/banane.jpg";
		setIcon(buttonThird, iconPath3);
		
		buttonThird.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(3);
				ecran.setRaquette(3);
				message=message+"Raquette envoyée: 3 \n";
//				ReproduireExec.ecrire(chemin, message);
				
			}
		});
		pane.add(buttonThird, BorderLayout.LINE_START);
		//RAQUETTE 4
		JButton buttonFourth = new JButton();
		String iconPath4 = "src/ImagesGUI/stars.jpg";
		setIcon(buttonFourth, iconPath4);
		
		buttonFourth.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(4);
				ecran.setRaquette(4);
				message=message+"Raquette envoyée: 4 \n";
//				ReproduireExec.ecrire(chemin, message);
				
			}
		});
		pane.add(buttonFourth, BorderLayout.LINE_END);

		JButton buttonJouer = new JButton();
		String playPath = "src/ImagesGUI/jouer.jpg";
		setIcon(buttonJouer, playPath);
		
		buttonJouer.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				panneau.removeAll();
				try {
					manitou.lancerJeu();
				} catch (InterruptedException e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(fenetre, e1.getMessage());
				}
			}
		});
		pane.add(buttonJouer, BorderLayout.PAGE_END);


	}
}


