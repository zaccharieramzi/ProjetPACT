/*************************************************************
 * Ici nous metttons toutes les methodes qui sont redondantes*
 * lors de la création d'interface que cela soit pour Choisir*
 * les parametres ou même les menus							 *
 *************************************************************/

package interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;


public interface GraphicInterface {
	public JFrame instanceOfWindow(String name);
	public void clickBehavior(Object action);
	public JButton instanceOfButton(String textOnButton);
	 
	
}
