package moduleIG;


import javax.swing.JFrame;
import javax.swing.JPanel;

import Jeu.Manitou;

import java.awt.Container;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


	public class FenetreAffichage {
		
		private static JFrame fenetre;
		private static Manitou manitou;
		public static boolean RIGHT_TO_LEFT = false;
		JPanel panneau = (JPanel) this.fenetre.getContentPane();
		public FenetreAffichage()
	{	
		this.fenetre= new JFrame("Menu principal");
		this.manitou= new Manitou();
	};
		public void addComponentsToPane(Container pane) 
		{
	        
	        if (!(pane.getLayout() instanceof BorderLayout)) {
	            pane.add(new JLabel("Container doesn't use BorderLayout!"));
	            return;
	        };
	        
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(
	                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	        };
	        
	        JButton buttonFacile = new JButton("Facile");
buttonFacile.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
	        	manitou.setSpeed(1);
	        	};
	        });
	        pane.add(buttonFacile, BorderLayout.PAGE_START);
	        
	        //Make the center component big, since that's the
	        //typical usage of BorderLayout.
	        JButton buttonNormal = new JButton("Normal");
	        buttonNormal.setPreferredSize(new Dimension(200, 100));
	        buttonNormal.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
	        	manitou.setSpeed(2);
	        	};
	        });
	        pane.add(buttonNormal, BorderLayout.CENTER);
	        
	        JButton buttonDifficile = new JButton("Difficile");
	        buttonDifficile.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
	        	manitou.setSpeed(3);
	        	};
	        });
	        pane.add(buttonDifficile, BorderLayout.LINE_START);
	        
	        JButton buttonExpert = new JButton("Expert");
buttonExpert.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
	        	manitou.setSpeed(4);
	        	};
	        });
	        pane.add(buttonExpert, BorderLayout.PAGE_END);
	        
	        JButton buttonValider = new JButton("To step 2");
buttonValider.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e) throws InterruptedException{
	        	fenetre.getContentPane().removeAll();
	        	addComponentsToPane2(fenetre.getContentPane());
	        	};
	        });
				pane.add(buttonValider, BorderLayout.LINE_END);
	    }
		public void addComponentsToPane2(Container pane) 
		{
	        
	        if (!(pane.getLayout() instanceof BorderLayout)) {
	            pane.add(new JLabel("Container doesn't use BorderLayout!"));
	            return;
	        };
	        
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(
	                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	        };
	        
	        JButton buttonFacile = new JButton("J1vsJ2");
	        buttonFacile.addMouseListener(new MouseAdapter() {
	        	
	// a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
	//Un setter pourrait servir
	
	        	public void MouseClicked(MouseEvent e){
	        	
	        	};
	        });
	        pane.add(buttonFacile, BorderLayout.PAGE_START);
	        
	        //Make the center component big, since that's the
	        //typical usage of BorderLayout.
	        
	        JButton buttonNormal = new JButton("J1vsIA");
	        buttonNormal.setPreferredSize(new Dimension(200, 100));
	        buttonNormal.addMouseListener(new MouseAdapter() {
	        	
	 // a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
	 //Un setter pourrait servir       
	        	
	        	public void MouseClicked(MouseEvent e){
	        	
	        	};
	        });
	        pane.add(buttonNormal, BorderLayout.CENTER);
	        
	        JButton buttonDifficile = new JButton("J1&J2vsIA");
	        buttonDifficile.addMouseListener(new MouseAdapter() {
	    
	 // a voir ce qu'on rajoute pour differencier entre les differents modes de jeu.
	 //Un setter pourrait servir
	        	
	        	public void MouseClicked(MouseEvent e){
	        	
	        	};
	        });
	        pane.add(buttonDifficile, BorderLayout.LINE_START);
	        
	        
	        
	        JButton buttonJouer = new JButton("To step 3");
buttonJouer.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e) throws InterruptedException{
	        	fenetre.getContentPane().removeAll();
	        	manitou.lancerJeu();
	        	};
	        });
	        pane.add(buttonJouer, BorderLayout.LINE_END);
	    
	    
		this.addComponentsToPane(panneau);
	    this.fenetre.pack();
	    this.fenetre.setVisible(true);
		}
		
		
		public void addComponentsToPane3(Container pane) 
		{
	        
	        if (!(pane.getLayout() instanceof BorderLayout)) {
	            pane.add(new JLabel("Container doesn't use BorderLayout!"));
	            return;
	        };
	        
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(
	                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	        };
	        
	        JButton buttonFirst = new JButton("Choix 1");
buttonFirst.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
		        	manitou.set.Deco(1);
	        	};
	        });
	        pane.add(buttonFirst, BorderLayout.PAGE_START);
	        
	        //Make the center component big, since that's the
	        //typical usage of BorderLayout.
	        JButton buttonSecond = new JButton("Choix 2");
	        buttonSecond.setPreferredSize(new Dimension(200, 100));
	        buttonSecond.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
		        	manitou.set.Deco(2);
	        	};
	        });
	        pane.add(buttonSecond, BorderLayout.CENTER);
	        
	        JButton buttonThird = new JButton("Choix 3");
	        buttonThird.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
	        	manitou.set.Deco(3);
	        	};
	        });
	        pane.add(buttonThird, BorderLayout.LINE_START);
	        
	        JButton buttonFourth = new JButton("Choix 4");
buttonFourth.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
		        	manitou.set.Deco(4);
	        	};
	        });
	        pane.add(buttonFourth, BorderLayout.PAGE_END);
	        
	        JButton buttonJouer = new JButton("To step 4");
buttonJouer.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e) throws InterruptedException{
	        	fenetre.getContentPane().removeAll();
	        	addComponentsToPane2(fenetre.getContentPane());
	        	};
	        });
	        pane.add(buttonJouer, BorderLayout.LINE_END);
		
	     
	        this.addComponentsToPane(panneau);
		    this.fenetre.pack();
		    this.fenetre.setVisible(true);
	}
		
		
		public void addComponentsToPane4(Container pane) 
		{
	        
	        if (!(pane.getLayout() instanceof BorderLayout)) {
	            pane.add(new JLabel("Container doesn't use BorderLayout!"));
	            return;
	        };
	        
	        if (RIGHT_TO_LEFT) {
	            pane.setComponentOrientation(
	                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
	        };
	        
	        JButton buttonFirst = new JButton("Choix 1");
buttonFirst.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
		        	manitou.set.Raquette(1);
	        	};
	        });
	        pane.add(buttonFirst, BorderLayout.PAGE_START);
	        
	        //Make the center component big, since that's the
	        //typical usage of BorderLayout.
	        JButton buttonSecond = new JButton("Choix 2");
	        buttonSecond.setPreferredSize(new Dimension(200, 100));
	        buttonSecond.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
		        	manitou.set.Raquette(2);
	        	};
	        });
	        pane.add(buttonSecond, BorderLayout.CENTER);
	        
	        JButton buttonThird = new JButton("Choix 3");
	        buttonThird.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
	        	manitou.set.Raquette(3);
	        	};
	        });
	        pane.add(buttonThird, BorderLayout.LINE_START);
	        
	        JButton buttonFourth = new JButton("Choix 4");
buttonFourth.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e){
		        	manitou.set.Raquette(4);
	        	};
	        });
	        pane.add(buttonFourth, BorderLayout.PAGE_END);
	        
	        JButton buttonJouer = new JButton(" Jouer ");
buttonJouer.addMouseListener(new MouseAdapter() {
	        	
	        	public void MouseClicked(MouseEvent e) throws InterruptedException{
	        	fenetre.getContentPane().removeAll();
	        	addComponentsToPane2(fenetre.getContentPane());
	        	};
	        });
	        pane.add(buttonJouer, BorderLayout.LINE_END);
		
	     
	        this.addComponentsToPane(panneau);
		    this.fenetre.pack();
		    this.fenetre.setVisible(true);
	}
		

		
		
}

