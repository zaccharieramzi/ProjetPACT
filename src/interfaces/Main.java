package interfaces;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;





public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame fenetre = new JFrame("MENTAL PONG");
		fenetre.setVisible(true);
		fenetre.setSize(1000, 1000);
		Dimension dimensionBonne = new Dimension(1,1);
		JButton boutonJouer = new JButton("Jouer");
		boutonJouer.setMinimumSize(dimensionBonne);
		JButton boutonQuitter = new JButton("Quitter");
		boutonQuitter.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 //Il faut que le bouton ait une référence sur la fenêtre sinon il ne peut pas faire grand chose.
			 }
			 }) ;
		JButton boutonAide = new JButton("Aide");
		boutonAide.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 JFrame fenetreDAide = new JFrame("Aide");
					fenetreDAide.setVisible(true);
					fenetreDAide.setSize(500, 5000);}
			 }) ;
		JButton boutonCredits = new JButton("Crédits");
		boutonCredits.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 JFrame fenetreCredits = new JFrame("Crédits");
					fenetreCredits.setVisible(true);
					fenetreCredits.setSize(500, 5000);}
			 }) ;
		JButton boutonStats = new JButton("Stats");
		boutonStats.addMouseListener(new MouseAdapter() {
			 @Override
			 public void mouseClicked(MouseEvent e) {
				 JFrame fenetreStats = new JFrame("Stats");
					fenetreStats.setVisible(true);
					fenetreStats.setSize(500, 5000);}
			 }) ;
		boutonStats.setMaximumSize(dimensionBonne);
		Container defaultPanel = fenetre.getContentPane();
		defaultPanel.add(boutonJouer,BorderLayout.CENTER);
		defaultPanel.add(boutonQuitter,BorderLayout.NORTH);
		defaultPanel.add(boutonAide,BorderLayout.WEST);
		defaultPanel.add(boutonCredits,BorderLayout.EAST);
		defaultPanel.add(boutonStats,BorderLayout.SOUTH);
		
		
		
	}

}
