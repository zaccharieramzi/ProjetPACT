package moduleIG;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Affichage.Affichage;
import Jeu.Manitou;

import java.awt.Container;

import javax.swing.*;

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
	}
	private Affichage ecran;

	public FenetreAffichage(){	
		this.fenetre= new JFrame("Menu principal");
		this.manitou= new Manitou();
		this.ecran = new Affichage();
		 panneau = (JPanel) fenetre.getContentPane();
		
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

		JButton buttonFacile = new JButton("Facile");
		buttonFacile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(1);
			};
		});
		pane.add(buttonFacile, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		JButton buttonNormal = new JButton("Normal");
		buttonNormal.setPreferredSize(new Dimension(200, 100));
		buttonNormal.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(2);
			};
		});
		pane.add(buttonNormal, BorderLayout.CENTER);

		JButton buttonDifficile = new JButton("Difficile");
		buttonDifficile.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(3);
			};
		});
		pane.add(buttonDifficile, BorderLayout.LINE_START);

		JButton buttonExpert = new JButton("Expert");
		buttonExpert.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				manitou.setSpeed(4);
			};
		});
		pane.add(buttonExpert, BorderLayout.LINE_END);

		JButton buttonValider = new JButton("To step 2");
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

			}
		});
		pane.add(buttonNormal, BorderLayout.CENTER);

		JButton buttonDifficile = new JButton("J1&J2vsIA");
		buttonDifficile.addMouseListener(new MouseAdapter() {

			// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
			//Un setter pourrait servir

			public void mouseClicked(MouseEvent e){

			}
		});
		pane.add(buttonDifficile, BorderLayout.LINE_START);



		JButton buttonJouer = new JButton("To step 3");
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

		JButton buttonFirst = new JButton("Decor 1");
		buttonFirst.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){

				//ce n'est pas au controleur qu'il faut donner la d�co mais � affichage
				//manitou.setDeco(1);

				ecran.setDeco(1);
				

			}
		});
		pane.add(buttonFirst, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		JButton buttonSecond = new JButton("Decor 2");
		buttonSecond.setPreferredSize(new Dimension(200, 100));
		buttonSecond.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(2);
				ecran.setDeco(2);
				
			}
		});
		pane.add(buttonSecond, BorderLayout.CENTER);

		JButton buttonThird = new JButton("Decor 3");
		buttonThird.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(3);
				ecran.setDeco(3);
				
			}
		});
		pane.add(buttonThird, BorderLayout.LINE_START);

		JButton buttonFourth = new JButton("Decor 4");
		buttonFourth.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setDeco(4);
				ecran.setDeco(4);
			
			}
		});
		pane.add(buttonFourth, BorderLayout.LINE_END);

		JButton buttonJouer = new JButton("To step 4");
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

		JButton buttonFirst = new JButton("Raquette1");
		buttonFirst.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(1);
				ecran.setRaquette(1);
		
			}
		});
		pane.add(buttonFirst, BorderLayout.PAGE_START);

		//Make the center component big, since that's the
		//typical usage of BorderLayout.
		JButton buttonSecond = new JButton("Raquette2");
		buttonSecond.setPreferredSize(new Dimension(200, 100));
		buttonSecond.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(2);
				ecran.setRaquette(2);
				
			}
		});
		pane.add(buttonSecond, BorderLayout.CENTER);

		JButton buttonThird = new JButton("Raquette3");
		buttonThird.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(3);
				ecran.setRaquette(3);
				
			}
		});
		pane.add(buttonThird, BorderLayout.LINE_START);

		JButton buttonFourth = new JButton("Raquette4");
		buttonFourth.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e){
				//manitou.setRaquette(4);
				ecran.setRaquette(4);
				
			}
		});
		pane.add(buttonFourth, BorderLayout.LINE_END);

		JButton buttonJouer = new JButton(" Jouer ");
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

