package Testeurs;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Jeu.Manitou;

public class DirectionGiver {

	private Manitou manitou;
	private JFrame fenetreDeTest;
	private JPanel panneau;
	public DirectionGiver(final Manitou manitou){
		this.manitou=manitou;
		this.fenetreDeTest= new JFrame("Test");
		this.panneau=(JPanel) this.fenetreDeTest.getContentPane();
		this.panneau.setLayout(new BoxLayout(panneau, BoxLayout.PAGE_AXIS));
		
			}
	
	public void addComponentsToPane(Container pane){
		JButton buttonHaut = new JButton("Haut");
		buttonHaut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				manitou.setDirectionP1(1);
				System.out.println("Ca marche");
			}
		});
		panneau.add(buttonHaut);
		JButton buttonBas = new JButton("Bas");
		buttonHaut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				manitou.setDirectionP1(0);
			}
		});
		panneau.add(buttonBas);
		JButton buttonPause= new JButton("Pause/Reprendre");
		buttonHaut.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				manitou.mettreEnPause_Reprendre();
			}
		});
		panneau.add(buttonPause);
		
	}
	public void show() {
		addComponentsToPane(this.panneau);
		this.fenetreDeTest.pack();
		this.fenetreDeTest.setLocationRelativeTo(null);
		this.fenetreDeTest.setVisible(true);
	}
}
