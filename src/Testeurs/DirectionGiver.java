package Testeurs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Jeu.Manitou;

public class DirectionGiver {

	private Manitou manitou;
	private JFrame fenetreDeTest;
	public DirectionGiver(final Manitou manitou){
		this.manitou=manitou;
	
	class ClavierDirection implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if (arg0.getKeyCode()==38) {
			manitou.setDirectionP1(1);
			}
			else {
				if (arg0.getKeyCode()==40){
					manitou.setDirectionP1(2);
				}
			}
		}
		
	};
	fenetreDeTest.addKeyListener(new ClavierDirection());
	}
}
